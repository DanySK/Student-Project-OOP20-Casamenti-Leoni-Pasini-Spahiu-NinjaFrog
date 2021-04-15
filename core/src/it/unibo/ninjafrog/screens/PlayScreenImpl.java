package it.unibo.ninjafrog.screens;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import it.unibo.ninjafrog.enemies.EnemyController;
import it.unibo.ninjafrog.enemies.EnemyControllerImpl;
import it.unibo.ninjafrog.frog.FrogController;
import it.unibo.ninjafrog.frog.FrogControllerImpl;
import it.unibo.ninjafrog.fruits.FruitPowerUp;
import it.unibo.ninjafrog.fruits.FruitType;
import it.unibo.ninjafrog.game.NinjaFrogGame;
import it.unibo.ninjafrog.hud.Hud;
import it.unibo.ninjafrog.hud.HudImpl;
import it.unibo.ninjafrog.screens.levels.Level;
import it.unibo.ninjafrog.utilities.GameConst;
import it.unibo.ninjafrog.utilities.Pair;
import it.unibo.ninjafrog.utilities.SoundManager;
import it.unibo.ninjafrog.world.Collidable;
import it.unibo.ninjafrog.world.WorldCollisionListener;
import it.unibo.ninjafrog.world.WorldCreator;
import it.unibo.ninjafrog.world.WorldCreatorImpl;
/**
 * Implementation of the {@link it.unibo.ninjafrog.screens.PlayScreen PlayScreen}.
 */
public final class PlayScreenImpl implements PlayScreen {
    private static final int WORLD_X_GRAVITY = 0;
    private static final int WORLD_Y_GRAVITY = -10;
    private static final int UNIT = 1;
    private static final int CAM_Z_COMPONENT = 0;
    private static final int HALF = 2;
    private final TextureAtlas atlas;
    private final NinjaFrogGame game;
    private final SoundManager sound;
    private final Hud hud;
    private final TiledMap map;
    private final OrthographicCamera cam;
    private final Viewport viewport;
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final World world;
    private final FrogController playerController; 
    private final EnemyController enemies;
    private final ArrayList<FruitPowerUp> fruits;
    private final LinkedList<Pair<Pair<Float, Float>, FruitType>> fruitsToSpawn;
    /**
     * Public constructor of the PlayScreenImpl.
     * @param game The {@link it.unibo.ninjafrog.game.NinjaFrogGame game} class.
     * @param level The {@link it.unibo.ninjafrog.screens.levels.Level level} selected.
     * @param sound The {@link it.unibo.ninjafrog.utilities.SoundManager SoundManager}.
     */
    public PlayScreenImpl(final NinjaFrogGame game, final Level level, final SoundManager sound) {
        this.game = game;
        this.sound = sound;
        this.sound.playGameSong();
        this.atlas = new TextureAtlas("ninjaAndEnemies.pack");
        this.map = new TmxMapLoader().load(level.getMap());
        this.cam = new OrthographicCamera();
        this.viewport = new FitViewport(this.scale(GameConst.WIDTH),
                this.scale(GameConst.HEIGHT),
                this.cam);
        this.cam.position.set(this.halfOf(this.viewport.getWorldWidth()),
                this.halfOf(this.viewport.getWorldHeight()),
                CAM_Z_COMPONENT);
        this.mapRenderer = new OrthogonalTiledMapRenderer(this.map, this.scale(UNIT));
        this.world = new World(new Vector2(WORLD_X_GRAVITY, WORLD_Y_GRAVITY), true);
        /*
         * BOX DEBUGGER IN CASE OF DEBUG.
         * this.b2debug = new Box2DDebugRenderer();
         */
        this.hud = new HudImpl(this.game.getBatch());
        final WorldCreator worldCreator = new WorldCreatorImpl(this);
        worldCreator.createWorld();
        /*
         * CREATE ENEMIES
         */
        this.enemies = new EnemyControllerImpl(this);
        /*
         * SET COLLISION LISTENER
         */
        this.world.setContactListener(new WorldCollisionListener(this.enemies, this));
        /*
         * CREATE NINJA CONTROLLER
         */
        this.playerController = new FrogControllerImpl(this);
        this.fruits = new ArrayList<>();
        this.fruitsToSpawn = new LinkedList<>();
    }

    private float halfOf(final float value) {
        return value / HALF;
    }

    private float scale(final int value) {
        return value / GameConst.PPM;
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
        this.map.dispose();
        this.mapRenderer.dispose();
        this.world.dispose();
        this.hud.getStage().dispose();
        //this.b2debug.dispose();
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
        this.game.setScreen(new WinScreen(this.game, this.hud.getScore(), this.sound));
    }

    @Override
    public void setGameOverScreen() {
        this.game.setScreen(new GameOverScreen(this.game, this.hud.getScore(), this.sound));
    }

    @Override
    public void setMenuScreen() {
        this.game.setScreen(new MainMenu(this.game, this.sound));
    }

    @Override
    public float getNinjaXPosition() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TiledMap getMap() {
        return this.map;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public TextureAtlas getAtlas() {
        return this.atlas;
    }

    @Override
    public void addScore(final Collidable entity) {
        this.hud.addScore(entity.getScore());
    }

}
