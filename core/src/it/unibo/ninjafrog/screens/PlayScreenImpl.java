package it.unibo.ninjafrog.screens;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.World;

import it.unibo.ninjafrog.fruits.FruitType;
import it.unibo.ninjafrog.game.NinjaFrogGame;
import it.unibo.ninjafrog.hud.Hud;
import it.unibo.ninjafrog.utilities.Pair;
import it.unibo.ninjafrog.world.Collidable;
/**
 * Implementation of the {@link it.unibo.ninjafrog.screens.PlayScreen PlayScreen}.
 */
public final class PlayScreenImpl implements PlayScreen {
    private final TextureAtlas atlas;
    private final NinjaFrogGame game;
    private Hud hud;
    private final TiledMap map;
    /**
     * Public constructor of the PlayScreenImpl.
     * @param game The {@link it.unibo.ninjafrog.game.NinjaFrogGame game} class.
     * @param level The {@link it.unibo.ninjafrog.screens.Level level} selected.
     */
    public PlayScreenImpl(final NinjaFrogGame game, final Level level) {
        this.game = game;
        this.atlas = new TextureAtlas("ninjaAndEnemies.pack");
        this.map = new TmxMapLoader().load(level.getMap());
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(final float delta) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resize(final int width, final int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public void spawnFruit(final Pair<Float, Float> position, final FruitType fruit) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setDoubleJumpAbility(final boolean b) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addLife() {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeLife() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setWinScreen() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setGameOverScreen() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setMenuScreen() {
        // TODO Auto-generated method stub

    }

    @Override
    public float getNinjaXPosition() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TiledMap getMap() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public World getWorld() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TextureAtlas getAtlas() {
        return this.atlas;
    }

    @Override
    public void addScore(final Collidable entity) {
        //this.hud.addScore(entity.getScore());
    }

}
