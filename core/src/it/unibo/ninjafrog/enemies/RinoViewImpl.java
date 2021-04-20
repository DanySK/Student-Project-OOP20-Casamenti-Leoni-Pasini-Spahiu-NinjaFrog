package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

import it.unibo.ninjafrog.game.utilities.GameConst;
import it.unibo.ninjafrog.screens.PlayScreen;

public class RinoViewImpl extends Sprite implements RinoView {
    private static final int X_COORDINATE_FOR_DEATH_REGION = 417;
    private static final int X_DISTANCE_FOR_EVERY_FRAMES = 52;
    private static final int HEIGHT_IN_THE_PNG = 30;
    private static final int WIDTH_IN_THE_PNG = 50;
    private static final int Y_COORDINATE_IN_THE_PNG = 68;
    private static final int  NUMBER_OF_FRAMES_= 6;
    private static final float FRAMES_DURATION = 0.1f;
    private static final int BOUNDS_HEIGHT = 17;
    private static final int BOUNDS_WIDTH = 25;
    private final EnemyControllerImpl controller;
    private final PlayScreen screen;
    private final Array<TextureRegion> frames;
    private final Animation<TextureRegion> walkAnimation;
    public RinoViewImpl(final PlayScreen screen, final float x, final float y, final EnemyControllerImpl enemyControllerImpl) {
        this.controller = enemyControllerImpl;
        this.screen = screen;
        setPosition(x, y);
        frames = new Array<>();
        for (int i = 0; i < NUMBER_OF_FRAMES_; i++) {
            frames.add(new TextureRegion(screen.getAtlas().findRegion("ninjaAndEnemies"), i * X_DISTANCE_FOR_EVERY_FRAMES, Y_COORDINATE_IN_THE_PNG, WIDTH_IN_THE_PNG, HEIGHT_IN_THE_PNG));
        }
    walkAnimation = new Animation<>(FRAMES_DURATION, frames);
    setBounds(getX(), getY(), BOUNDS_WIDTH / GameConst.PPM, BOUNDS_HEIGHT / GameConst.PPM);
    }
    @Override
    public final void update(final Body body, final float dt) {
        setPosition(body.getPosition().x - getWidth() / 2, body.getPosition().y - getHeight() / 2);
        setRegion(getFrame(body, dt));
    }

    @Override
    public final void draw(final SpriteBatch batch) {
        if (!this.controller.isDestroyed(this) || this.controller.getStateTime(this) < 0.5) {
            super.draw(batch);
        }
    }

    @Override
    public final void setDeathRegion() {
        setRegion(new TextureRegion(screen.getAtlas().findRegion("ninjaAndEnemies"), X_COORDINATE_FOR_DEATH_REGION, Y_COORDINATE_IN_THE_PNG, WIDTH_IN_THE_PNG, HEIGHT_IN_THE_PNG));
    }
    private TextureRegion getFrame(final Body body, final float dt) {
        TextureRegion region;
        region = walkAnimation.getKeyFrame(controller.getStateTime(this), true);
        if ((body.getLinearVelocity().x < 0 || !controller.isRunningLeft(this)) && region.isFlipX()) {
            region.flip(true, false);
            controller.setRunningLeft(this, false);
        } else if ((body.getLinearVelocity().x > 0 || controller.isRunningLeft(this)) && !region.isFlipX()) {
            region.flip(true,  false);
            controller.setRunningLeft(this, true);  
        }
        return region;
    }

}
