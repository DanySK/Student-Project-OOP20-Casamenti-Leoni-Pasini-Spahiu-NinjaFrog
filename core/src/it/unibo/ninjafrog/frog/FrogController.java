package it.unibo.ninjafrog.frog;

import com.badlogic.gdx.physics.box2d.Body;

public interface FrogController {

    /**
     * @return the frog's body.
     */
    Body getBody();
    /**
     * @param dt delta of time;
     */
    void update(float dt);
    /**
     * draw the frog.
     */
    void draw();
    /**
     * handle the keyboard's input.
     */
    void handleInput();

}
