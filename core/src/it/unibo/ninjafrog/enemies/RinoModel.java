package it.unibo.ninjafrog.enemies;

public interface RinoModel {
    
    void defineEnemy();

    void update(float dt);
    
    void reverseVelocity(boolean x ,boolean y);
    
    boolean isSetToDestroy();
    
    
}
