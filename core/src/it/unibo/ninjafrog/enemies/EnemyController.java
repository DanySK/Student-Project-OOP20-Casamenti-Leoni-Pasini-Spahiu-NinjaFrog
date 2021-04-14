package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public interface EnemyController {
    
    void update (float dt);
    
    void draw (SpriteBatch batch);
    
    void collide(RinoModel rinoModel);
    
    boolean isSetToDestroy(RinoModel rinoModel);
    
    void reverseVelocity(RinoModel rinoModel);
    
    float getX(RinoModel rinoModel);
    
    float getY (RinoModel rinoModel);
    
    boolean isDestroyed(RinoView rinoView);
    
    float getStateTime(RinoView rinoView);
    
    void setDeathRegion (RinoModel rinoModel);
    
    void upadeView (RinoModel rinoModel, Body b2body, float dt);
    
    boolean isRunningLeft(RinoView rinoView);
    
    void setRunningLeft(RinoView rinoView, boolean b);
    
    //__________________________________________________

    float getX(TurtleModel turtleModel);
    
    float getY(TurtleModel turtleModel);
    
    void setDeathRegion(TurtleModel turtleModel);

    void upadeView(TurtleModel turtleModel, Body body, float dt);

    boolean isDestroyed(TurtleView turtleView);

    double getStateTime(TurtleView turtleView);
    
    void collide (TurtleModel turtleModel);
    
    boolean isSetToDestroy (TurtleModel turtleModel);
    
    
    
}
