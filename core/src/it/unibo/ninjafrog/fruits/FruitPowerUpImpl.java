package it.unibo.ninjafrog.fruits;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
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
    private BodyDef fruitBody;
    private FixtureDef fruitFixture;
    private CircleShape fruitShape;
    private TextureRegion region;
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
       region = new TextureRegion(screen.getAtlas().findRegion("NinjaAndEnemies"));
       setPosition(x, y);
       setBounds(getX(), getY(), BOUNDS_WIDTH, BOUNDS_HEIGHT);
       fruitBody = new BodyDef();
       fruitBody.position.set(getX(), getY());
       defineItem(this.type);
       body = world.createBody(fruitBody);
       fruitFixture = new FixtureDef();
       fruitShape = new CircleShape();
       fruitShape.setRadius(FRUIT_RADIUS);
       maskBits(fruitFixture);
       body.createFixture(fruitFixture).setUserData(type);
    }
    /**
     * Implements collide method that is part of Collidable interface.
     */
    @Override
    public void collide() {
        switch (type) {
        case MELON:
            destroy();
            screen.setDoubleJumpAbility(true);
            //Hud.addScore(GameConst.MELON_SCORE)
            break;
        case ORANGE:
            destroy();
            //Hud.addScore(GameConst.ORANGE_SCORE);
            break;
        case CHERRY:
            destroy();
            screen.addLife();
            //Hud.addScore(GameConst.CHERRY_SCORE);
            break;
        default:
             break;
        }

    }
    /**
     * Implements draw method that is part of FruitPowerUp interface.
     */
    @Override
    public void draw(final Batch batch) {
        if (!destroyed) {
            super.draw(batch);
        }
    }
    /**
     * Implements update method that is part of FruitPowerUp interface.
     */
    @Override
    public void update(final float dt) {
        if (toDestroy && !destroyed) {
            world.destroyBody(body);
            destroyed = true;
        }
        setPosition(body.getPosition().x - getWidth() / 2, body.getPosition().y - getHeight() / 2);
        body.setLinearVelocity(velocity);
    }
    /**
     * Implements reverseVelocity method that is part of FruitPowerUp interface.
     */
    @Override
    public void reverseVelocity() {
        velocity.x = velocity.x * (-1);
    }
    private void defineItem(final FruitType type) {
        switch (type) {
        case MELON:
            velocity = new Vector2(0.8f, -1.5f);
            setRegion(region, 486, 9, 19, 16);
            fruitBody.type = BodyDef.BodyType.DynamicBody;
            break;
        case ORANGE:
            velocity = new Vector2(0, -1.5f);
            setRegion(region, 520, 9, 19, 16);
            fruitBody.type = BodyDef.BodyType.StaticBody;
            break;
        case CHERRY:
            velocity = new Vector2(-0.8f, -1.5f);
            setRegion(region, 455, 9, 19, 16);
            fruitBody.type = BodyDef.BodyType.DynamicBody;
            break;
        default:
             break;
        }
     }
     private void maskBits(final FixtureDef fruitFixture) {
         fruitFixture.filter.categoryBits = GameConst.FRUIT;
         fruitFixture.filter.maskBits = GameConst.NINJA
                 | GameConst.GROUND
                 | GameConst.GROUND_OBJECT
                 | GameConst.BRICK
                 | GameConst.FRUITBOX;
     }
     private void destroy() {
        toDestroy = true;
     }

}
