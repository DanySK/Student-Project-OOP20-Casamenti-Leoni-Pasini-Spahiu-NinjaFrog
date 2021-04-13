package it.unibo.ninjafrog.frog;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

public class FrogViewImpl extends Sprite implements FrogView {
    private static final int IMAGE_DIM = 32;
    private static final float ANIM_VEL = 0.1f;
    private final float stateTimer;
    private FrogModel frog;
    private Body body;
    private FrogState currentState;
    private FrogState prevState;
    private TextureRegion frogJump;
    private TextureRegion frogStand;
    private TextureRegion frogBonusJump;
    private TextureRegion frogBonusStand;
    private Animation<TextureRegion> frogRun;
    private Animation<TextureRegion> frogBonusRun;
    private Animation<TextureRegion> frogBonusDoubleJump;

    public FrogViewImpl() {
        this.stateTimer = 0;
        frogJump = new TextureRegion(getTexture(), 420 ,3,IMAGE_DIM,IMAGE_DIM);
        frogStand = new TextureRegion(getTexture(), 4, 3, IMAGE_DIM, IMAGE_DIM);
        frogBonusJump = new TextureRegion(getTexture(), 420, 36, IMAGE_DIM, IMAGE_DIM);
        frogBonusStand = new TextureRegion(getTexture(), 4, 39, IMAGE_DIM, IMAGE_DIM);

        final Array<TextureRegion> frames = new Array<TextureRegion>();
        //frogRun animation
        for (int i = 1; i < 13 ; i++) {
            frames.add(new TextureRegion(getTexture(),i*32, 3, IMAGE_DIM, IMAGE_DIM));
        }
        frogRun = new Animation<>(ANIM_VEL, frames);
        frames.clear();
        //frogBonusRun animation
        for (int i = 1; i < 13; i++) {
            frames.add(new TextureRegion(getTexture(), i*32, 36, IMAGE_DIM, IMAGE_DIM ));
        }
        frogBonusRun = new Animation<>(ANIM_VEL, frames);
        frames.clear();
        //frogBonusDoubleJump animation
        for (int i = 13; i < 19; i++ ) {
            frames.add(new TextureRegion(getTexture(), i*32, 36, IMAGE_DIM, IMAGE_DIM));
        }
        frogBonusDoubleJump = new Animation<>(ANIM_VEL, frames);

    }
    @Override
    public void setFrog(final FrogModel frog) {
        this.frog = frog;
        this.body = frog.getBody();
    }
    @Override
    public void update(final float dt) {
    }
    @Override
    public void draw(final Batch batch) {
        super.draw(batch);
    }
    private TextureRegion getFrame(final float dt) {
        currentState = frog.getState();
        TextureRegion region = null;
        switch (currentState) {
        case JUMPING:
            if (this.frog.isDoubleJumpActive()) {
                region = frogBonusJump;
            } else {
                region = frogJump;
            }
            break;
        case RUNNING:
            if (this.frog.isDoubleJumpActive()) {
                region = frogBonusRun.getKeyFrame(stateTimer, true);
                } else {
                region = frogRun.getKeyFrame(stateTimer, true);
                }
            break;
        case FALLING:
        case STANDING:
            default:
                if (frog.isDoubleJumpActive()) {
                    region = frogBonusStand;
                } else {
                region = frogStand;
                }
                break;
        }
        if ((frog.getBody().getLinearVelocity().x < 0 || !frog.isRunningRight()) && !region.isFlipX()) {
            region.flip(true, false);
        } else if ((frog.getBody().getLinearVelocity().x > 0 || frog.isRunningRight()) && region.isFlipX()) {
            region.flip(true, false);
    }
        return null;
    }


}
