package it.unibo.ninjafrog.frog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;

import it.unibo.ninjafrog.screens.PlayScreen;

public class FrogControllerImpl implements FrogController {

    private FrogState currrentState;
    private FrogState previousState;
    private static final  float VEL = 0.1f;
    private boolean pause = false;
    private final FrogModel frog;
    private final FrogView frogView;
    private PlayScreen screeen;

    public FrogControllerImpl(final FrogModel frog, final FrogView frogView) {
        this.frog = frog;
        this.frogView = frogView;
        this.frogView.setFrog(this.frog);
    }


    @Override
    public Body getBody() {
        return this.frog.getBody();
    }
    @Override
    public void update(final float dt) {
        handleInput();
        frog.update(dt);
        frogView.update(dt);
    }
    @Override
    public void draw(final Batch batch) {
        frogView.draw(batch);
    }
    @Override
    public void handleInput() {
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
        } else {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
                this.screeen.setMenuScreen();
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                this.pause = !this.pause;
            }
        }
    }


    @Override
    public FrogModel getModel() {
        return this.frog;
    }

}
