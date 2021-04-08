package it.unibo.ninjafrog.fruits;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import it.unibo.ninjafrog.screens.PlayScreen;
/**
 * Definition of FruitPowerUp implementation.
 *
 */
public class FruitPowerUpImpl implements FruitPowerUp {
    private PlayScreen playscreen;
    private World world;
    private Body body;
    private boolean toDestroy;
    private boolean destroyed;
    private Vector2 velocity;
    private FruitType fruitType;
    /**
     * Public constructor of a FruitPowerUpImpl object.
     * @param screen PlayScreen of the game. 
     * @param x float position. 
     * @param y float position. 
     * @param type FruitType of fruit.
     */
    public FruitPowerUpImpl(final PlayScreen screen, final float x, final float y, final FruitType type) {
       
    }
    @Override
    public void collide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw(final Batch batch) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(final float dt) {
        // TODO Auto-generated method stub

    }

    @Override
    public void reverseVelocity() {
        // TODO Auto-generated method stub

    }

}
