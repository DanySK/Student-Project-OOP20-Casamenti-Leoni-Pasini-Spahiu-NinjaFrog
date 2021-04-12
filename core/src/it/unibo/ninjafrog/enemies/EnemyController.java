package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public interface EnemyController {
    
    void update (float dt);
    
    void draw (SpriteBatch batch);
    
    void collide(RinoModel rino);
    
    boolean isSetToDestroy(RinoModel rino);
    
    void reverseVelocity(RinoModel rino);
    
    float getX(RinoModel rinoModel);
    
    float getY (RinoModel rinoModel);
    
    boolean isDestroyed(RinoView rinoView);
    
    float getStateTime(RinoView rinoView);
    
    void setDeathRegion (RinoModel rinoModel);
    
    void upadeView (RinoModel rinoModel, Body b2body, float dt);
    
    void collide (TurtleModel turtleModel);
    
    boolean isSetToDestroy (TurtleModel turtleModel);
    
    boolean isRunningLeft(RinoView rinoView);
    
    void setRunningLeft(RinoView rinoView, boolean b);
    
}
