package it.unibo.ninjafrog.world;

import com.badlogic.gdx.maps.MapObject;

import it.unibo.ninjafrog.screens.PlayScreen;

/**
 * Brick class definition.
 * A Brick is an {@link it.unibo.ninjafrog.world.InteractiveObject InteractiveObject}
 * which is destroyed after you hit it with your head.
 * Defines a {@link it.unibo.ninjafrog.world.Collidable#collide() collide()} method.
 */
public class Brick extends InteractiveObject implements Collidable {

    public Brick(PlayScreen screen, MapObject object) {
        super(screen, object);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void collide() {
        // TODO Auto-generated method stub

    }

}
