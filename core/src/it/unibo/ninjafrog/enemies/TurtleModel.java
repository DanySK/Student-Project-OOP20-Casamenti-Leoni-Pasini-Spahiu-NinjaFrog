package it.unibo.ninjafrog.enemies;

import it.unibo.ninjafrog.world.Collidable;

/**
 * 
 * Interface that the TurtleModelImpl has to implement.
 *
 */

public interface TurtleModel extends Collidable {
    /**
     * Method that call other private method for create the body and the head of the
     * turtle.
     */

    void defineEnemy();

    /**
     * Method that update the turtle body.
     * 
     * @param dt the delta of the time
     */

    void update(float dt);

    /**
     * 
     * @return the float stateTime of the turtle
     */

    float getStateTime();

    /**
     * 
     * @return the boolean setToDestroy of the turtle
     */

    boolean isSetToDestroy();

    /**
     * 
     * @return the boolean destroyed of the turtle
     */

    boolean isDestroyed();

}
