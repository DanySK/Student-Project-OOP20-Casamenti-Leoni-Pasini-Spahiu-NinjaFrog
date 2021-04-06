package it.unibo.ninjafrog.world;

import com.badlogic.gdx.maps.MapObject;

public interface NonInteractiveBuilder {

    NonInteractiveBuilder selectObject(MapObject object);
    NonInteractiveBuilder chooseCategoryBit(short bit);
    NonInteractiveObject build();
}
