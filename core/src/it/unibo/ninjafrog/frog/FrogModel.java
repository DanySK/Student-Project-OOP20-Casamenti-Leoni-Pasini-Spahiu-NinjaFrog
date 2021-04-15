package it.unibo.ninjafrog.frog;

import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.physics.box2d.Body;

public interface FrogModel {

    /**
     * @return frog's body.
     */
    Body getBody();
    /**
     * @return frog's 2d position.
     */
    Vector2 getPos();
    /**
     * define the frog.
     */
    void defineFrog();
    /**
     * @return frog's state.
     */
    FrogState getState();
    /**
     * set frog's state.
     */
    void setState();
    /**
     * the frog jump.
     */
    void jump();
    /**
     * @param direction the direction;
     */
    void move(float direction);
    /**
     * the frog double jump.
     */
    void doubleJump();
    /**
     * @return true if the doublejump is active.
     */
    boolean isDoubleJumpActive();
    /**
     *  set the double jump.
     *  @param isDoubleJump set the double jump.
     */
    void setDoubleJump(boolean isDoubleJump);
    /**
     * @return true if the frog is moving to the right.
     */
    boolean isRunningRight();
    /**
     * add one life to the frog.
     */
    void addLife();
    /**
     * remove one life from the frog.
     */
    void removeLife();
    /**
     * update the model
     * .
     * @param dt delta of time.
     */
    void update(float dt);



}
