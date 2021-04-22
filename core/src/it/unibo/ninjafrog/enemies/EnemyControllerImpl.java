package it.unibo.ninjafrog.enemies;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;

import it.unibo.ninjafrog.game.utilities.GameConst;
import it.unibo.ninjafrog.screens.PlayScreen;

public class EnemyControllerImpl implements EnemyController {
    private static final int RINO_LAYER = 7;
    private static final int TURTLE_LAYER = 8;
    private Map<RinoModel, RinoView> rinos;
    private Map<TurtleModel, TurtleView> turtles;
    private final PlayScreen screen;
    private boolean runningLeft;
    private boolean destroyed;
    private float stateTime;

    /**
     * public constructor of the EnemyController.
     * 
     * @param screen the playscreen
     */

    public EnemyControllerImpl(final PlayScreen screen) {
        if (screen == null) {
            throw new IllegalStateException("Screen can't be null.");
        }
        this.screen = screen;
        this.spawnEnemies();
    }

    private void spawnEnemies() {
        final TiledMap map = this.screen.getMap();
        rinos = new HashMap<>();
        for (final MapObject object : map.getLayers().get(RINO_LAYER).getObjects()
                .getByType(RectangleMapObject.class)) {
            final Rectangle rect = ((RectangleMapObject) object).getRectangle();
            rinos.put(new RinoModelImpl(screen, this),
                    new RinoViewImpl(screen, rect.getX() / GameConst.PPM, rect.getY() / GameConst.PPM, this));
        }
        rinos.keySet().forEach(m -> m.defineEnemy());
        turtles = new HashMap<>();
        for (final MapObject object : map.getLayers().get(TURTLE_LAYER).getObjects()
                .getByType(RectangleMapObject.class)) {
            final Rectangle rect = ((RectangleMapObject) object).getRectangle();
            turtles.put(new TurtleModelImpl(screen, this),
                    new TurtleViewImpl(screen, rect.getX() / GameConst.PPM, rect.getY() / GameConst.PPM, this));
        }
        turtles.keySet().forEach(m -> m.defineEnemy());
    }

    @Override
    public final void update(final float dt) {
        rinos.forEach((m, v) -> m.update(dt));
        turtles.forEach((m, v) -> m.update(dt));
    }

    @Override
    public final void draw(final SpriteBatch batch) {
        rinos.forEach((m, v) -> v.draw(batch));
        turtles.forEach((m, v) -> v.draw(batch));
    }

    @Override
    public final void collide(final RinoModel rinoModel) {
        checkRinoModel(rinoModel);
        rinoModel.collide();
    }

    @Override
    public final boolean isSetToDestroy(final RinoModel rinoModel) {
        checkRinoModel(rinoModel);
        return rinoModel.isSetToDestroy();

    }

    @Override
    public final void reverseVelocity(final RinoModel rinoModel) {
        checkRinoModel(rinoModel);
        rinoModel.reverseVelocity(true, false);
    }

    @Override
    public final float getX(final RinoModel rinoModel) {
        checkRinoModel(rinoModel);
        return this.rinos.get(rinoModel).getX();
    }

    @Override
    public final float getY(final RinoModel rinoModel) {
        checkRinoModel(rinoModel);
        return this.rinos.get(rinoModel).getY();
    }

    @Override
    public final boolean isDestroyed(final RinoView rinoView) {
        checkRinoView(rinoView);
        this.rinos.forEach((m, v) -> {
            if (v.equals(rinoView)) {
                this.destroyed = m.isDestroyed();
            }
        });
        return this.destroyed;
    }

    @Override
    public final float getStateTime(final RinoView rinoView) {
        checkRinoView(rinoView);
        this.rinos.forEach((m, v) -> {
            if (v.equals(rinoView)) {
                this.stateTime = m.getStateTime();
            }
        });
        return this.stateTime;
    }

    @Override
    public final void setDeathRegion(final RinoModel rinoModel) {
        checkRinoModel(rinoModel);
        this.rinos.get(rinoModel).setDeathRegion();
    }

    @Override
    public final void upadeView(final RinoModel rinoModel, final Body body, final float dt) {
        checkRinoModel(rinoModel);
        this.rinos.get(rinoModel).update(body, dt);
    }

    @Override
    public final boolean isRunningLeft(final RinoView rinoView) {
        checkRinoView(rinoView);
        this.rinos.forEach((m, v) -> {
            if (v.equals(rinoView)) {
                this.runningLeft = m.isRunningLeft();
            }
        });
        return this.runningLeft;
    }

    @Override
    public final void setRunningLeft(final RinoView rinoView, final boolean b) {
        checkRinoView(rinoView);
        this.rinos.forEach((m, v) -> {
            if (v.equals(rinoView)) {
                m.setRunningLeft(b);
            }
        });
    }

    private void checkRinoModel(final RinoModel rinoModel) {
        if (!this.rinos.keySet().contains(rinoModel)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRinoView(final RinoView rinoView) {
        if (!this.rinos.values().contains(rinoView)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public final float getX(final TurtleModel turtleModel) {
        checkTurtleModel(turtleModel);
        return this.turtles.get(turtleModel).getX();
    }

    @Override
    public final float getY(final TurtleModel turtleModel) {
        checkTurtleModel(turtleModel);
        return this.turtles.get(turtleModel).getY();
    }

    @Override
    public final void setDeathRegion(final TurtleModel turtleModel) {
        checkTurtleModel(turtleModel);
        this.turtles.get(turtleModel).setDesthRegion();
    }

    @Override
    public final void upadeView(final TurtleModel turtleModel, final Body body, final float dt) {
        checkTurtleModel(turtleModel);
        this.turtles.get(turtleModel).update(body, dt);
    }

    @Override
    public final boolean isDestroyed(final TurtleView turtleView) {
        checkTurtleView(turtleView);
        this.turtles.forEach((m, v) -> {
            if (v.equals(turtleView)) {
                this.destroyed = m.isDestroyed();
            }
        });
        return this.destroyed;
    }

    @Override
    public final double getStateTime(final TurtleView turtleView) {
        checkTurtleView(turtleView);
        this.turtles.forEach((m, v) -> {
            if (v.equals(turtleView)) {
                this.stateTime = m.getSatateTime();
            }
        });
        return this.stateTime;
    }

    @Override
    public final void collide(final TurtleModel turtleModel, final Short bit) {
        checkTurtleModel(turtleModel);
        if (this.turtles.get(turtleModel).isKillable()) {
            this.screen.removeLife();
        } else if (bit == GameConst.TURTLE) {
            this.screen.removeLife();
            turtleModel.collide();
        } else {
            turtleModel.collide();
        }
    }

    @Override
    public final boolean isSetToDestroy(final TurtleModel turtleModel) {
        checkTurtleModel(turtleModel);
        return turtleModel.isSetToDestroy();
    }

    private void checkTurtleModel(final TurtleModel turtleModel) {
        if (!this.turtles.keySet().contains(turtleModel)) {
            throw new IllegalStateException();
        }
    }

    private void checkTurtleView(final TurtleView turtleView) {
        if (!this.turtles.values().contains(turtleView)) {
            throw new IllegalStateException();
        }
    }
}
