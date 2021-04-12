package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;

public interface RinoView {
    void update(Body b2body, float dt);

    void setDeathRegion();

    float getY();

    float getX();

    void draw(Batch batch);
}
