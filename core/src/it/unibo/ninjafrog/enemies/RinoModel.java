package it.unibo.ninjafrog.enemies;

import it.unibo.ninjafrog.world.Collidable;

public interface RinoModel extends Collidable{
    
    void defineEnemy();

    void update(float dt);
    
    void reverseVelocity(boolean x ,boolean y);
    
    boolean isSetToDestroy();
    
    boolean isDestroyed();
    
    float getStateTime();
    
    boolean isRunningLeft();
    
    void setRunningLeft(boolean b);
       
}
