package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * 
 * Interface with the essential methods of a moving enemy like rino.
 *
 */

public interface RinoView {
    /**
     * Method that update calls other private method for update the view part of a
     * rino.
     * 
     * @param body the body of the rino
     * @param dt   the delta of the time
     */

    void update(Body body, float dt);

    /**
     * Method that draw the rino texture.
     * 
     * @param batch the game batch
     */

    void draw(SpriteBatch batch);

    /**
     * 
     * @return the X coordinate of the rino in float
     */

    float getX();

    /**
     * 
     * @return the Y coordinate of the rino in float
     */

    float getY();

    /**
     * Method that set the texture of the rino with the death animation.
     */

    void setDeathRegion();

}
