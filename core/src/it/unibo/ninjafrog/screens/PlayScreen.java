package it.unibo.ninjafrog.screens;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;

import it.unibo.ninjafrog.hud.Hud;
import it.unibo.ninjafrog.utilities.Pair;

public interface PlayScreen {
    void spawnMelon(Pair<Float, Float> position);
    void spawnOrange(Pair<Float, Float> position);
    void spawnCherries(Pair<Float, Float> position);
    void setDoubleJumpAbility(boolean b);
    void addLife();
    void setWinScreen();
    void setGameOverScreen();
    TiledMap getMap();
    World getWorld();
    TextureAtlas getAtlas();
    Hud getHud();
}
