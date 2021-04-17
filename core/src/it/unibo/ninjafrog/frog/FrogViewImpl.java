package it.unibo.ninjafrog.frog;


import com.badlogic.gdx.graphics.g2d.Animation;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import it.unibo.ninjafrog.screens.PlayScreen;
import it.unibo.ninjafrog.utilities.GameConst;

public class FrogViewImpl extends Sprite implements FrogView {
    private static final int IMAGE_DIM = 32;
    private static final float ANIM_VEL = 0.1f;
    private static final int DJ_ANIM_INIT = 13;
    private static final int DJ_ANIM_END = 19;
    private static final int RUN_ANIM_END = 13;

    private final FrogController frogController;
    private float stateTimer;
    private boolean runningRight;
    private FrogState prevState;
    private FrogState currentState;
    private final TextureRegion frogJump;
    private final TextureRegion frogStand;
    private final TextureRegion frogBonusJump;
    private final TextureRegion frogBonusStand;
    private final Animation<TextureRegion> frogRun;
    private final Animation<TextureRegion> frogBonusRun;
    private final Animation<TextureRegion> frogBonusDoubleJump;

    public FrogViewImpl(final FrogController frogController, final PlayScreen screen) {
        super(screen.getAtlas().findRegion("ninjaAndEnemies")); 
        this.frogController = frogController;
        this.runningRight = true;
        this.stateTimer = 0;
        frogJump = new TextureRegion(getTexture(), 420 , 3, IMAGE_DIM, IMAGE_DIM);
        frogStand = new TextureRegion(getTexture(), 4, 3, IMAGE_DIM, IMAGE_DIM);
        frogBonusJump = new TextureRegion(getTexture(), 420, 36, IMAGE_DIM, IMAGE_DIM);
        frogBonusStand = new TextureRegion(getTexture(), 4, 39, IMAGE_DIM, IMAGE_DIM);

        final Array<TextureRegion> frames = new Array<>();
        //frogRun animation
        for (int i = 1; i < RUN_ANIM_END; i++) {
            frames.add(new TextureRegion(getTexture(), i * IMAGE_DIM, 3, IMAGE_DIM, IMAGE_DIM));
        }
        frogRun = new Animation<>(ANIM_VEL, frames);
        frames.clear();
        //frogBonusRun animation
        for (int i = 1; i < RUN_ANIM_END; i++) {
            frames.add(new TextureRegion(getTexture(), i * IMAGE_DIM, 36, IMAGE_DIM, IMAGE_DIM ));
        }
        frogBonusRun = new Animation<>(ANIM_VEL, frames);
        frames.clear();
        //frogBonusDoubleJump animation
        for (int i = DJ_ANIM_INIT; i < DJ_ANIM_END; i++) {
            frames.add(new TextureRegion(getTexture(), i * IMAGE_DIM, IMAGE_DIM, IMAGE_DIM, IMAGE_DIM));
        }
        frogBonusDoubleJump = new Animation<>(ANIM_VEL, frames);
        frames.clear();
        setBounds(0, 0, 18 / GameConst.PPM, 18 / GameConst.PPM);
    }
    @Override
    public final void update(final float dt) {
        setPosition(frogController.getBody().getPosition().x - getWidth() / 2, frogController.getBody().getPosition().y - getHeight() / 2);
        setRegion(getFrame(dt));
    }
    @Override
    public final void draw(final Batch batch) {
        super.draw(batch);
    }
    private TextureRegion getFrame(final float dt) {
        currentState = frogController.getState();
        TextureRegion region = null;
        switch (currentState) {
        case JUMPING:
            if (this.frogController.isDoubleJumpActive()) {
                region = frogBonusJump;
            } else {
                region = frogJump;
            }
            break;
        case RUNNING:
            if (this.frogController.isDoubleJumpActive()) {
                region = frogBonusRun.getKeyFrame(stateTimer, true);
                } else {
                region = frogRun.getKeyFrame(stateTimer, true);
                }
            break;
        case FALLING:
        case STANDING:
            default:
                if (frogController.isDoubleJumpActive()) {
                    region = frogBonusStand;
                } else {
                region = frogStand;
                }
                break;
        }
        if ((frogController.getBody().getLinearVelocity().x < 0 || !frogController.isRunningRight()) && !region.isFlipX()) {
            region.flip(true, false);
            runningRight = false;
        } else if ((frogController.getBody().getLinearVelocity().x > 0 || frogController.isRunningRight()) && region.isFlipX()) {
            region.flip(true, false);
            runningRight = true;
        }
        this.stateTimer = currentState == prevState ? stateTimer + dt : 0;
        prevState = currentState;

        return region;
    }
    @Override
    public final boolean isRunningRight() {
        return this.runningRight;
    }


}
