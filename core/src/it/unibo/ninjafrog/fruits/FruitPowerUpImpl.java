package it.unibo.ninjafrog.fruits;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
    private static final String REGION = "NinjaAndEnemies";
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
    /**
     * Implements collide method that is part of Collidable interface.
     */
    @Override
    public void collide() {
        switch (type) {
        case MELON:
            destroy();
            //ninja.setdoublejump();
            //Hud.addScore(GameConst.MELON_SCORE)
            break;
        case ORANGE:
            destroy();
            defineOrange();
            //Hud.addScore(GameConst.ORANGE_SCORE);
            break;
        case CHERRY:
            destroy();
            defineCherry();
            //ninja.addlife();
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
         setRegion(screen.getAtlas().findRegion("NinjaAndEnemies"), 455, 9, 19, 16);
         BodyDef cherryBody = new BodyDef();
         cherryBody.position.set(getX(), getY());
         cherryBody.type = BodyDef.BodyType.DynamicBody;
         body = world.createBody(cherryBody);
         FixtureDef cherryFixture = new FixtureDef();
         CircleShape cherryShape = new CircleShape();
         cherryShape.setRadius(FRUIT_RADIUS);
         cherryFixture.shape = cherryShape;
         maskBits(cherryFixture);
         body.createFixture(cherryFixture).setUserData(this);
     }
     private void defineOrange() {
         setRegion(screen.getAtlas().findRegion(REGION), 520, 9, 19, 16);
         BodyDef orangeBody = new BodyDef();
         orangeBody.position.set(getX(), getY());
         orangeBody.type = BodyDef.BodyType.StaticBody;
         body = world.createBody(orangeBody);
         FixtureDef orangeFixture = new FixtureDef();
         CircleShape orangeShape = new CircleShape();
         orangeShape.setRadius(FRUIT_RADIUS);
         orangeFixture.shape = orangeShape;
         maskBits(orangeFixture);
         body.createFixture(orangeFixture).setUserData(this);
     }
     private void defineMelon() {
         setRegion(screen.getAtlas().findRegion(REGION), 486, 9, 19, 16);
         BodyDef melonBody = new BodyDef();
         melonBody.position.set(getX(), getY());
         melonBody.type = BodyDef.BodyType.DynamicBody;
         body = world.createBody(melonBody);
         FixtureDef melonFixture = new FixtureDef();
         CircleShape melonShape = new CircleShape();
         melonShape.setRadius(FRUIT_RADIUS);
         melonFixture.shape = melonShape;
         maskBits(melonFixture);
         body.createFixture(melonFixture).setUserData(this);
     }
     private void maskBits(final FixtureDef fruitFixture) {
         fruitFixture.filter.categoryBits = GameConst.FRUIT;
         fruitFixture.filter.maskBits = GameConst.NINJA_BIT
                         | GameConst.GROUND_BIT
                         | GameConst.GROUNDOBJECT_BIT
                         | GameConst.BRICK_BIT
                         | GameConst.COIN_BIT;
     }
     private void destroy() {
        toDestroy = true;
     }

}
