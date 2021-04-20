package it.unibo.ninjafrog.enemies;

import it.unibo.ninjafrog.world.Collidable;

public interface TurtleModel extends Collidable {

    void defineEnemy();

    void update(float dt);

    float getSatateTime();

    boolean isSetToDestroy();

    boolean isDestroyed();

}
