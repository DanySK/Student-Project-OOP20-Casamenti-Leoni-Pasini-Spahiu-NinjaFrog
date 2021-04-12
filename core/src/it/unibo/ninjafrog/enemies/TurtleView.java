package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;

public interface TurtleView {

    void update(Body b2body, float dt);


    void draw(Batch batch);


}
