package it.unibo.ninjafrog.world;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import it.unibo.ninjafrog.enemies.EnemyController;
import it.unibo.ninjafrog.enemies.RinoModel;
import it.unibo.ninjafrog.fruits.FruitPowerUp;
import it.unibo.ninjafrog.screens.PlayScreen;
import it.unibo.ninjafrog.utilities.GameConst;
/**
 * Definition of the WorldCollisionListener class,
 * it detects all collisions in the game and handles all the different cases.
 * Implementation of the {@link com.badlogic.gdx.physics.box2d.ContactListener ContactListener} interface.
 */
public final class WorldCollisionListener implements ContactListener {
    private final EnemyController enemies;
    private final PlayScreen screen;
    /**
     * Public constructor of the {@link it.unibo.ninjafrog.world.WorldCollisionListener listener}.
     * @param enemies The {@link it.unibo.ninjafrog.enemies.EnemyController enemies controller}.
     * @param screen The {@link it.unibo.ninjafrog.screens.PlayScreen PlayScreen} where the world is defined.
     */
    public WorldCollisionListener(final EnemyController enemies, final PlayScreen screen) {
        this.enemies = enemies;
        this.screen = screen;
    }
    @Override
    public void beginContact(final Contact contact) {
        final Fixture fixtureA = contact.getFixtureA();
        final Fixture fixtureB = contact.getFixtureB();
        final int collisionBit = bitOf(fixtureA) | bitOf(fixtureB);
        switch (collisionBit) {
            case GameConst.NINJA_HEAD | GameConst.BRICK:
            case GameConst.NINJA_HEAD | GameConst.FRUITBOX:
            case GameConst.NINJA | GameConst.FRUIT:
                if (bitOf(fixtureA) == GameConst.NINJA_HEAD
                || bitOf(fixtureA) == GameConst.NINJA) {
                    ((Collidable) fixtureB.getUserData()).collide();
                } else {
                    ((Collidable) fixtureA.getUserData()).collide();
                }
                break;
            case GameConst.NINJA | GameConst.RINO_HEAD:
            case GameConst.NINJA | GameConst.TURTLE_HEAD:
                break;
            case GameConst.NINJA | GameConst.RINO:
            case GameConst.NINJA | GameConst.TURTLE:
                break;
            case GameConst.RINO | GameConst.TURTLE:
            case GameConst.RINO | GameConst.GROUND_OBJECT:
                if (bitOf(fixtureA) == GameConst.RINO) {
                    enemies.reverseVelocity((RinoModel) fixtureA.getUserData());
                } else {
                    enemies.reverseVelocity((RinoModel) fixtureB.getUserData());
                }
                break;
            case GameConst.RINO | GameConst.RINO:
                enemies.reverseVelocity((RinoModel) fixtureA.getUserData());
                enemies.reverseVelocity((RinoModel) fixtureB.getUserData());
                break;
            case GameConst.FRUIT | GameConst.GROUND_OBJECT:
                if (bitOf(fixtureA) == GameConst.FRUIT) {
                    ((FruitPowerUp) fixtureA.getUserData()).reverseVelocity();
                } else {
                    ((FruitPowerUp) fixtureB.getUserData()).reverseVelocity();
                }
                break;
            case GameConst.FRUIT | GameConst.FRUIT:
                ((FruitPowerUp) fixtureA.getUserData()).reverseVelocity();
                ((FruitPowerUp) fixtureB.getUserData()).reverseVelocity();
                break;
            case GameConst.NINJA | GameConst.FINISH:
                this.screen.setWinScreen();
                break;
            default:
                //unused
                break;
        }
    }

    private short bitOf(final Fixture fixture) {
        return fixture.getFilterData().categoryBits;
    }

    @Override
    public void endContact(final Contact contact) {
    }

    @Override
    public void preSolve(final Contact contact, final Manifold oldManifold) {
    }

    @Override
    public void postSolve(final Contact contact, final ContactImpulse impulse) {
    }

}
