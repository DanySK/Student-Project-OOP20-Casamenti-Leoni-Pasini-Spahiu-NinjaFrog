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
     * @return frog's state.
     */
    FrogState getState();
    /**
     * set frog's state.
     */
    void setState();
    /**
     * @return true if the doublejump is active.
     */
    boolean isDoubleJumpActive();
    /**
     *  set the double jump.
     *  @param b 
     */
    void setDoubleJump(boolean b);
    /**
     * @return true if the frog is moving to the right.
     */
    boolean isRunningRight();
    /**
     * @return the frog's lives.
     */
    Integer getLife();
    /**
     * add one life to the frog.
     */
    void addLife();
    /**
     * remove one life from the frog.
     */
    void removeLife();
    /**
     * @return true if the game is paused.
     */
    boolean isPaused();
    


}
