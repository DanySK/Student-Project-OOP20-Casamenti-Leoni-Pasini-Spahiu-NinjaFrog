package it.unibo.ninjafrog.enemies;

import it.unibo.ninjafrog.world.Collidable;
     /**
      * Interface with the method that the RinoModelImpl have to implement.
      *
      */

public interface RinoModel extends Collidable {
    /**
     * Method that call other private method for create the body and the head of the rino.
     */

    void defineEnemy();
    /**
     * Method that update the rinoModel.
     * @param dt the delta of the time
     */

    void update(float dt);
    /**
     * Method that change the direction of the rino.
     * @param x true if you want to change the X direction
     * @param y true if you want to change the Y direction
     */

    void reverseVelocity(boolean x, boolean y);
    /**
     * 
     * @return the boolean is setToDestroy of the rino
     */

    boolean isSetToDestroy();
    /**
     * 
     * @return the boolean destroyed of the rino
     */

    boolean isDestroyed();
    /**
     * 
     * @return the float stateTime of the rino
     */

    float getStateTime();
    /**
     * 
     * @return the boolean runningLeft of the rino
     */

    boolean isRunningLeft();
    /**
     * Method that set the boolean runningLeft of the rino.
     * @param b how u want to set the boolean runningLeft
     */

    void setRunningLeft(boolean b); 

}
