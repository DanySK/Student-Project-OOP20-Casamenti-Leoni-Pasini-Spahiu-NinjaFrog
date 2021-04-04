package it.unibo.ninjafrog.fruits;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import it.unibo.ninjafrog.utilities.GameConst;

/**
 * Definition of Entity class.
 * Every general entity with a physics in the game world.
 **/
public class Entity extends Sprite {
    
    /**
     * object's Entity view
     */
    protected PlayScreen playscreen; //or set with a new name 
    protected World world;
    
    /**
     * object's Entity
     */
    protected Body body;
    private boolean toDestroy;
    private boolean destroyed;
    
    public Entity(final PlayScreen screen, final float x, final float y) {
        this.playscreen = playscreen;
        this.world = world;
        setPosition(x, y);
        setBounds(getX(), getY(), 16 / GameConst.PPM, 12 / GameConst.PPM); //remove magic number
        toDestroy = false;
        destroyed = false;
    }
    public void update(final float dt) {
       // to complete
    }
    public void draw(final Batch batch) {
        //to complete
    }
}
