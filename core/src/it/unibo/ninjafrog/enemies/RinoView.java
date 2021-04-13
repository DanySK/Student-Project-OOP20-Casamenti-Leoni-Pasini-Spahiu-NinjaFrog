package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public interface RinoView {
    
    void update(Body body, float dt);
    
    void draw(SpriteBatch batch);
    
    float getX();
    
    float getY();
    
    void seDeathRegion();

}
