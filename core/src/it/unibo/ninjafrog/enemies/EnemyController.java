package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface EnemyController {

    void update(float dt);
    
    void draw(SpriteBatch batch);
    
    void collide(RinoModel rino);
    
    boolean isSetToDestroy(RinoModel rino);
    
    void reverseVelocity(RinoModel enemy);
    
    void collide(TurtleModel turtle);
    
    boolean isSetToDestroy(TurtleModel turtle);
}
