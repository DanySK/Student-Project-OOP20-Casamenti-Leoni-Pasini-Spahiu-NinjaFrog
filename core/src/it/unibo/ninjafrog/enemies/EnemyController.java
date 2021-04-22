package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Definition of the EnemyController interface.
 */
public interface EnemyController {
    /**
     * Method that calls the update method update for every rino and turtle model.
     * 
     * @param dt the delta of the time
     */
    void update(float dt);

    /**
     * Method that calls the draw method for every rino and turtle view.
     * 
     * @param batch
     */
    void draw(SpriteBatch batch);

    /**
     * Method that call the collide method in the rinoModel.
     * 
     * @param rinoModel the model interface of the rino A
     *                  {@link it.unibo.ninjafrog.enemies.RinoModel RinoModel}
     */
    void collide(RinoModel rinoModel);

    /**
     * Method that check if the rinoModel is in the rinos map.
     * 
     * @param rinoModel A {@link it.unibo.ninjafrog.enemies.RinoModel RinoModel} the
     *                  model interface of the rino
     * @return the method isSetToDestroy of the RinoModel
     */
    boolean isSetToDestroy(RinoModel rinoModel);

    /**
     * Method that check if the rinoModel is in the rinos map and call the method
     * reverseVelocity in the RinoModel.
     * 
     * @param rinoModel A {@link it.unibo.ninjafrog.enemies.RinoModel RinoModel} the
     *                  model interface of the rino
     */
    void reverseVelocity(RinoModel rinoModel);

    /**
     * Method that check if the rinoModel is in the rinos map.
     * 
     * @param rinoModel {@link it.unibo.ninjafrog.enemies.RinoModel RinoModel} the
     *                  model interface of the rino
     * @return the method getX of the RinoModel
     */
    float getX(RinoModel rinoModel);

    /**
     * Method that check if the rinoModel is in the rinos map.
     * 
     * @param rinoModel {@link it.unibo.ninjafrog.enemies.RinoModel RinoModel} the
     *                  model of the enemy rino
     * @return the method getX of the RinoModel
     */
    float getY(RinoModel rinoModel);

    /**
     * Method that check if the rinoView is in the rinos map.
     * 
     * @param rinoView {@link it.unibo.ninjafrog.enemies.RinoView RinoView} the view
     *                 of the enemy rino
     * @return the boolean "destroyed" of the RinoViewImpl
     */
    boolean isDestroyed(EnemyView rinoView);

    /**
     * Method that check if the rinoView is in the rinos map.
     * 
     * @param rinoView {@link it.unibo.ninjafrog.enemies.RinoView RinoView} the view
     *                 of the enemy rino
     * @return the state time of that rino
     */

    float getStateTime(EnemyView rinoView);

    /**
     * Method that check if the rinoModel is in the rinos map and call the method
     * setDeathRegion of the RinoModel.
     * 
     * @param rinoModel {@link it.unibo.ninjafrog.enemies.RinoModel RinoModel} the
     *                  model of the enemy rino
     */

    void setDeathRegion(RinoModel rinoModel);

    /**
     * Method that check if the rinoModel is in the rinos map and call the method
     * update in the view part of the enemi rino.
     * 
     * @param rinoModel {@link it.unibo.ninjafrog.enemies.RinoModel RinoModel} the
     *                  model of the enemy rino
     * @param body      the body of the enemies
     * @param dt        the delta of the time
     */

    void upadeView(RinoModel rinoModel, Body body, float dt);

    /**
     * Method that check if the rinoView is in the rinos map.
     * 
     * @param rinoView {@link it.unibo.ninjafrog.enemies.RinoView RinoView} the view
     *                 of the enemy rino
     * @return the result of the method is runningLeft of the RinoModel
     */

    boolean isRunningLeft(EnemyView rinoView);

    /**
     * Method that check if the rinoView is in the rinos map and set the boolean
     * runningLeft of the rinoModelImpl.
     * 
     * @param rinoView {@link it.unibo.ninjafrog.enemies.RinoView RinoView} the view
     *                 of the enemy rino
     * @param b        this is the boolean that will set runningLeft
     */

    void setRunningLeft(EnemyView rinoView, boolean b);

    /**
     * Method that check if the turtleModel is in the turtles map and return X
     * position of the turtle.
     * 
     * @param turtleModel {@link it.unibo.ninjafrog.enemies.TurtleModel TurtleModel}
     *                    the model part of the enemy turtle
     * @return X coordinate of the turtle in the map
     */

    float getX(TurtleModel turtleModel);

    /**
     * Method that check if the turtleModel is in the turtles map and return Y
     * position of the turtle.
     * 
     * @param turtleModel {@link it.unibo.ninjafrog.enemies.TurtleModel TurtleModel}
     *                    the model part of the enemy turtle
     * @return Y coordinate of the turtle in the map
     */

    float getY(TurtleModel turtleModel);

    /**
     * Method that check if the turtleModel is in the turtles map and call the
     * method setDeathRegion in the TurtleView.
     * 
     * @param turtleModel {@link it.unibo.ninjafrog.enemies.TurtleModel TurtleModel}
     *                    the model part of the enemy turtle
     */

    void setDeathRegion(TurtleModel turtleModel);

    /**
     * Method that check if the turtleModel is in the turtles map and call the
     * method setDeathRegion in the TurtleView.
     * 
     * @param turtleModel {@link it.unibo.ninjafrog.enemies.TurtleModel TurtleModel}
     *                    the model part of the enemy turtle
     * @param body        the body of the enemy turtle
     * @param dt          the delta of the time
     */

    void upadeView(TurtleModel turtleModel, Body body, float dt);

    /**
     * Method that check if the turtleModel is in the turtles map and call the
     * method collide in the TurtleView.
     * 
     * @param turtleModel {@link it.unibo.ninjafrog.enemies.TurtleModel TurtleModel}
     *                    the model part of the enemy turtle
     * @param bit         the part of the body where the main charapter hit the
     *                    turtle
     */

    void collide(TurtleModel turtleModel, Short bit);

    /**
     * Method that check if the turtleModel is in the turtles map and call the
     * method collide in the TurtleView.
     * 
     * @param turtleModel {@link it.unibo.ninjafrog.enemies.TurtleModel TurtleModel}
     *                    the model part of the enemy turtle
     * @return the boolean isSetToDestroy in the rinoViewImpl
     */
    boolean isSetToDestroy(TurtleModel turtleModel);

}
