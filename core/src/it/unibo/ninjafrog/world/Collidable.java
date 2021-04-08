package it.unibo.ninjafrog.world;

/**
 * Definition of Collidable interface.
 * Every class which implements this interface has to define a {@link Collidable#collide()} method.
 */
public interface Collidable {
    /**
     * Method to be called when a collision with the main character occurs.
     */
    void collide();
}
