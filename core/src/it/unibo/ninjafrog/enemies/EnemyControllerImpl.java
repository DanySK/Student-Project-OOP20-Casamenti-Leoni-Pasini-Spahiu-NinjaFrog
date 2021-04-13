package it.unibo.ninjafrog.enemies;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;

import it.unibo.ninjafrog.screens.PlayScreen;
import it.unibo.ninjafrog.utilities.GameConst;

public class EnemyControllerImpl implements EnemyController {
    
    private HashMap<RinoModel, RinoView > rinos; 
    
    private PlayScreen screen;
    
    private boolean runningLeft;

    private boolean isDestroyed;
    
    private float stateTime;
    

    public EnemyControllerImpl(PlayScreen screen ) {
        this.screen = screen;
        this.spawnEnemies();
    }
    private void spawnEnemies() {
        TiledMap map = this.screen.getMap();
        rinos = new HashMap<RinoModel, RinoView>();
        for(MapObject object : map.getLayers().get(GameConst.RINO_LAYER).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject)object).getRectangle();
            rinos.put(new RinoModelImpl(screen,this),
                      new RinoViewImpl(screen ,rect.getX()/GameConst.PPM, rect.getY()/GameConst.PPM,this));
        }
        rinos.keySet().forEach(r-> r.defineEnemy());
        }
    @Override
    public void update(float dt) {
       rinos.forEach((r,v)->r.update(dt)); 
        
    }

    @Override
    public void draw(SpriteBatch batch) {
        rinos.forEach((r,v)->v.draw(batch));
    }

    @Override
    public void collide(RinoModel rino) {
        if(!this.rinos.keySet().contains(rino)) {
            throw new IllegalArgumentException();
        }
        rino.collide();
    }

    @Override
    public boolean isSetToDestroy(RinoModel rino) {
        if(!this.rinos.keySet().contains(rino)) {
            throw new IllegalArgumentException();
        }

        return rino.isSetToDestroy();

    }

    @Override
    public void reverseVelocity(RinoModel rinoModel) {
        checkModel(rinoModel);
        rinoModel.reverseVelocity(true, false);
    }

    @Override
    public float getX(RinoModel rinoModel) {
        checkModel(rinoModel);
        return this.rinos.get(rinoModel).getX();
    }

    @Override
    public float getY(RinoModel rinoModel) {
       checkModel(rinoModel);
        return this.rinos.get(rinoModel).getY();
    }

    @Override
    public boolean isDestroyed(RinoView rinoView) {
        checkView(rinoView);
        this.rinos.forEach((m,v)->{
            if(v.equals(rinoView)) {
                this.isDestroyed = m.isDestroyed();
            }
        });
        return false;
    }

    @Override
    public float getStateTime(RinoView rinoView) {
        checkView(rinoView);
        this.rinos.forEach((m,v)->{
            if(v.equals(rinoView)) {
                this.stateTime = m.getStateTime();
            }
            });
        return this.stateTime;
    }

    @Override
    public void setDeathRegion(RinoModel rinoModel) {
           checkModel(rinoModel);
           this.rinos.get(rinoModel).setDeathRegion();
    }

    @Override
    public void upadeView(RinoModel rinoModel, Body b2body, float dt) {
         checkModel(rinoModel);
         this.rinos.get(rinoModel).update(b2body, dt);
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
        checkView(rinoView);
        this.rinos.forEach((m,v)->{
            if(v.equals(rinoView)) {
                this.runningLeft = m.isRunningLeft();
            }
        });
        return this.runningLeft;
    }

    @Override
    public void setRunningLeft(RinoView rinoView, boolean b) {
        checkView (rinoView);
        this.rinos.forEach((m,v)->{
            if(v.equals(rinoView)) {
                m.setRunningLeft(b);
            }
        });
    }
    
    private void checkModel (RinoModel rinoModel) {
        if(!this.rinos.keySet().contains(rinoModel)) {
            throw new IllegalArgumentException();
        }
    }
        
     private void checkView (RinoView rinoView) {
         if(!this.rinos.values().contains(rinoView)) {
             throw new IllegalArgumentException();
         }
         
     }
}




