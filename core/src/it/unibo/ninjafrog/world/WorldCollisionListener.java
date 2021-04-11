package it.unibo.ninjafrog.world;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import it.unibo.ninjafrog.utilities.GameConst;
/**
 * Definition of the WorldCollisionListener class,
 * it detects all collisions in the game and handles all the different cases.
 * Implementation of the {@link com.badlogic.gdx.physics.box2d.ContactListener ContactListener} interface.
 */
public final class WorldCollisionListener implements ContactListener {

    @Override
    public void beginContact(final Contact contact) {
        final Fixture fixtureA = contact.getFixtureA();
        final Fixture fixtureB = contact.getFixtureB();
        final int collisionBit = bitOf(fixtureA) | bitOf(fixtureB);
        switch (collisionBit) {
            case GameConst.NINJA_HEAD | GameConst.BRICK:
                break;
            case GameConst.NINJA_HEAD | GameConst.FRUITBOX:
                break;
            case GameConst.NINJA | GameConst.RINO_HEAD:
            case GameConst.NINJA | GameConst.TURTLE_HEAD:
                break;
            case GameConst.NINJA | GameConst.FRUIT:
                break;
            case GameConst.NINJA | GameConst.RINO:
            case GameConst.NINJA | GameConst.TURTLE:
                break;
            case GameConst.RINO | GameConst.TURTLE:
                break;
            case GameConst.RINO | GameConst.GROUND_OBJECT:
                break;
            case GameConst.RINO | GameConst.RINO:
                break;
            case GameConst.FRUIT | GameConst.GROUND_OBJECT:
                break;
            case GameConst.FRUIT | GameConst.FRUIT:
                break;
            case GameConst.NINJA | GameConst.FINISH:
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
