package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

import it.unibo.ninjafrog.screens.PlayScreen;
import it.unibo.ninjafrog.utilities.GameConst;

public class RinoViewImpl extends Sprite implements RinoView {
    private final EnemyControllerImpl controller;
    private final PlayScreen screen;
    private final Array<TextureRegion> frames;
    private final Animation<TextureRegion> walkAnimation;
    public RinoViewImpl(final PlayScreen screen, final float x, final float y, final EnemyControllerImpl enemyControllerImpl) {
        this.controller = enemyControllerImpl;
        this.screen = screen;
        setPosition(x, y);
        frames = new Array<>();        
        for (int i = 0; i < 6; i++) {
            frames.add(new TextureRegion(screen.getAtlas().findRegion("ninjaAndEnemies"), i * 52, 68, 50, 30));
        }
    walkAnimation = new Animation<TextureRegion>(0.1f, frames);
    setBounds(getX(), getY(), 25 / GameConst.PPM, 17 / GameConst.PPM);  
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
        setRegion(new TextureRegion(screen.getAtlas().findRegion("ninjaAndEnemies"), 417, 68, 50, 30));
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
