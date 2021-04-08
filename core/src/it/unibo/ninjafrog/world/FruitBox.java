package it.unibo.ninjafrog.world;

import com.badlogic.gdx.maps.MapObject;

import it.unibo.ninjafrog.screens.PlayScreen;

/**
 * FruitBox class definition.
 * A FruitBox is an {@link it.unibo.ninjafrog.world.InteractiveObject InteractiveObject}
 * which spawns a fruit once you hit it with your head.
 * Defines a {@link it.unibo.ninjafrog.world.Collidable#collide() collide()} method.
 */
public class FruitBox extends InteractiveObject implements Collidable {

    public FruitBox(PlayScreen screen, MapObject object) {
        super(screen, object);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void collide() {
        // TODO Auto-generated method stub

    }

}
