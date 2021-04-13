package it.unibo.ninjafrog.enemies;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public class EnemyControllerImpl implements EnemyController {
    
    private HashMap<RinoModel, RinoView > rinos; 
    
    private boolean runningLeft;

    private boolean isDestroyed;
    
    private float stateTime;

    @Override
    public void update(float dt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void draw(SpriteBatch batch) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void collide(RinoModel rino) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isSetToDestroy(RinoModel rino) {
        // TODO Auto-generated method stub
        return false;

    }

    @Override
    public void reverseVelocity(RinoModel rino) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public float getX(RinoModel rinoModel) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getY(RinoModel rinoModel) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isDestroyed(RinoView rinoView) {
        if(!this.rinos.values().contains(rinoView)) {
            throw new IllegalArgumentException();
        }
        this.rinos.forEach((m,v)->{
            if(v.equals(rinoView)) {
                this.isDestroyed = m.isDestroyed();
            }
        });
        return false;
    }

    @Override
    public float getStateTime(RinoView rinoView) {
        if(!this.rinos.values().contains(rinoView)) {
            throw new IllegalArgumentException();
        }
        this.rinos.forEach((m,v)->{
            if(v.equals(rinoView)) {
                this.stateTime = m.getStateTime();
            }
            });
        return this.stateTime;
    }

    @Override
    public void setDeathRegion(RinoModel rinoModel) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void upadeView(RinoModel rinoModel, Body b2body, float dt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void collide(TurtleModel turtleModel) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isSetToDestroy(TurtleModel turtleModel) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isRunningLeft(RinoView rinoView) {
        if(!this.rinos.values().contains(rinoView)) {
            throw new IllegalArgumentException();
        }
        this.rinos.forEach((m,v)->{
            if(v.equals(rinoView)) {
                this.runningLeft = m.isRunningLeft();
            }
        });
        return this.runningLeft;
    }

    @Override
    public void setRunningLeft(RinoView rinoView, boolean b) {
        
        if(!this.rinos.values().contains(rinoView)) {
            throw new IllegalArgumentException();
        }
        this.rinos.forEach((m,v)->{
            if(v.equals(rinoView)) {
                m.setRunningLeft(b);
            }
        });
    }



}
