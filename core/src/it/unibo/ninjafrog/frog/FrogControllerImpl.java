package it.unibo.ninjafrog.frog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Body;

public class FrogControllerImpl implements FrogController {

    private FrogState currrentState;
    private FrogState previousState;
    private static final  float VEL = 0.1f;
    private boolean pause = false;
    private final FrogModel frog;
    private final FrogView frogView;
    
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
    }
    @Override
    public void draw() {
    }
    @Override
    public void handleInput() {
        if (!this.pause) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {

                }
            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                frog.move(VEL);
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                frog.move(VEL);
            }
        } else {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
                //setto lo screen del menu
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                this.pause = !this.pause;
            }
        }
    }

}
