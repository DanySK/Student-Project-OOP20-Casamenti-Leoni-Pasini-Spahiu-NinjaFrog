package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
/**
 * Interface with the essential methods for a turtle.
 */
public interface TurtleView {
    /**
     * Method that update the view part of the turtle
     * @param body the body of the turtle
     * @param dt the delta of the time
     */

    void update(Body body, float dt);
    /**
     * Method that draw the view par of the turtle
     * @param batch the game batch
     */

    void draw(Batch batch);
    /**
     * 
     * @return true if the turtle spikes are out
     */

    boolean hasSpike();
    /**
     * Method that set the texture of turtle with the death animation
     */
 
    void setDesthRegion();
    /**
     * 
     * @return the X coordinate of the turtle
     */

    float getX();
    /**
     * 
     * @return the Y coordinate of the turtle
     */

    float getY();

}
