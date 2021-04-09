package it.unibo.ninjafrog.fruits;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import it.unibo.ninjafrog.screens.PlayScreen;
import it.unibo.ninjafrog.utilities.GameConst;
/**
 * Definition of FruitPowerUp implementation.
 *
 */
public class FruitPowerUpImpl extends Sprite implements FruitPowerUp {
    private static final float FRUIT_RADIUS = 6 / GameConst.PPM;
    private static final float BOUNDS_WIDTH = 16 / GameConst.PPM;
    private static final float BOUNDS_HEIGHT = 12 / GameConst.PPM;
    private PlayScreen screen;
    private World world;
    private Body body;
    private boolean toDestroy;
    private boolean destroyed;
    private Vector2 velocity;
    private FruitType type;
    /**
     * Public constructor of a FruitPowerUpImpl object.
     * @param screen PlayScreen of the game. 
     * @param x float position. 
     * @param y float position. 
     * @param type FruitType of fruit.
     */
    public FruitPowerUpImpl(final PlayScreen screen, final float x, final float y, final FruitType type) {
       this.screen = screen;
       this.world = screen.getWorld();
       this.type = type;
       toDestroy = false;
       destroyed = false;
       velocity = new Vector2(0.8f,  -1.5f);
       setPosition(x, y);
       setBounds(getX(), getY(), BOUNDS_WIDTH, BOUNDS_HEIGHT);
       defineItem(this.type);
    }
    private void defineItem(final FruitType type) {
       switch (type) {
       case MELON:
           defineMelon();
           break;
       case ORANGE:
           defineOrange();
           break;
       case CHERRY:
           defineCherry();
           break;
       default:
            break;
       }
    }
    private void defineCherry() {
        // TODO Auto-generated method stub
        
    }
    private void defineOrange() {
        // TODO Auto-generated method stub
        
    }
    private void defineMelon() {
        // TODO Auto-generated method stub
        
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
