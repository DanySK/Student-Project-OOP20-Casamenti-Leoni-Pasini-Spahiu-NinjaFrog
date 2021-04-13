package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import it.unibo.ninjafrog.screens.PlayScreen;

public class TurtleModelImpl implements TurtleModel{
    
    private World world;
    private PlayScreen screen;
    public Body body;
    public Vector2 velocity;
    private static final int CIRCLE_RADIUS = 7;
    private float stateTime;
    private boolean setToDestroy;
    private boolean destroyed;
    private EnemyController controller;
    
    public TurtleModelImpl(PlayScreen screen, EnemyControllerImpl enemyControllerImpl) {
        this.world = screen.getWorld();
        this.screen = screen;
        this.controller = enemyControllerImpl;
        velocity = new Vector2(0,0);
        stateTime = 0;
        this.destroyed = false;
        this.setToDestroy = false;           
    }

    @Override
    public void defineEnemy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(float dt) {
        stateTime += dt;
        if(setToDestroy && !this.destroyed) {
            this.destroyed = true;
            world.destroyBody(body);
            controller.setDeathRegion(this);
            stateTime=0;
        }else if(!this.destroyed) {
            body.setLinearVelocity(velocity);
            controller.upadeView(this, this.body, dt);
        }
        
    }

    @Override
    public float getSatateTime() {
        return this.stateTime;
    }

    @Override
    public boolean isSetToDestroy() {
        return this.setToDestroy;
    }

    @Override
    public boolean isDestroyed() {
        return this.destroyed;
    }

    @Override
    public void collide() {
       // screen.hud.addScore(333);
        setToDestroy = true;
    }

    @Override
    public int getScore() {
        return 0;
    }
   


}
