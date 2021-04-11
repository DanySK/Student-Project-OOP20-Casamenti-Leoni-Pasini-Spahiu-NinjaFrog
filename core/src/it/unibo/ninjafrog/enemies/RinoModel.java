package it.unibo.ninjafrog.enemies;

public interface RinoModel {

    void reverseVelocity(boolean b, boolean c);

    boolean isSetToDestroy();

    void defineEnemy();

    void update(float dt);

}
