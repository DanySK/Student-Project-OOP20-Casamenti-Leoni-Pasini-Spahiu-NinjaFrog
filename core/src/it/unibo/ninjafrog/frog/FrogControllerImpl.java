package it.unibo.ninjafrog.frog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;

import it.unibo.ninjafrog.screens.PlayScreen;

public class FrogControllerImpl implements FrogController {
    private static final  float VEL = 0.1f;

    private boolean pause;
    private PlayScreen screen;
    private final FrogModel frog;
    private final FrogView frogView;

    public FrogControllerImpl(final PlayScreen screen) {
        
        this.frog = new FrogModelImpl(screen, this);
        this.frogView = new FrogViewImpl(this, screen);
        this.pause = false;
    }


    @Override
    public final Body getBody() {
        return this.frog.getBody();
    }
    @Override
    public final void update(final float dt) {
        handleInput();
        frog.update(dt);
        frogView.update(dt);
    }
    @Override
    public final void draw(final Batch batch) {
        frogView.draw(batch);
    }
    @Override
    public final void handleInput() {
        if (!this.pause) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                if (frog.isDoubleJumpActive()) {
                    frog.doubleJump();
                } else {
                    frog.jump();
                    }
                }
            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                frog.move(VEL);
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                frog.move(VEL);
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                this.pause = !this.pause;
            }
        } else {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
                this.screen.setMenuScreen();
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                this.pause = !this.pause;
            }
        }
    }


    @Override
    public final FrogModel getModel() {
        return this.frog;
    }


    @Override
    public final boolean isDoubleJumpActive() {
        return this.frog.isDoubleJumpActive();
    }


    @Override
    public final FrogState getState() {
        return this.frog.getState();
    }


    @Override
    public final boolean isRunningRight() {
        return this.frog.isRunningRight();
    }
    @Override
    public final boolean isPaused() {
        return this.pause;
    }

}
