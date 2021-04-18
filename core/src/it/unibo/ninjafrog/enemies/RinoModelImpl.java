package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import it.unibo.ninjafrog.game.utilities.GameConst;
import it.unibo.ninjafrog.screens.PlayScreen;

public class RinoModelImpl implements RinoModel{

    private World world;
    private PlayScreen screen;
    public Body body;
    public Vector2 velocity;
    private static final int CIRCCLE_RADIUS = 7;
    private static final int RINO_SCORE = 150;
    private float stateTime;
    private boolean setToDestroy;
    private boolean destroyed;
    private boolean runningLeft;
    private EnemyController controller;
    public RinoModelImpl(PlayScreen screen,EnemyControllerImpl controller) {
        this.world = screen.getWorld();
        this.screen = screen;
        this.controller = controller;
        velocity = new Vector2(-1,-2);
        stateTime = 0;
        this.setToDestroy = false;
        this.destroyed = false;
        this.runningLeft = true;
    }
    
    @Override
    public void defineEnemy() {
     BodyDef bdef = new BodyDef();
     FixtureDef fdef = new FixtureDef();
     CircleShape shape = new CircleShape();
     PolygonShape head = new PolygonShape();
     Vector2[] vertice = new Vector2[4];
     createBody(bdef);
     fixtureBodyDefinition(fdef, shape);
     createFixture(fdef);
    fixtureHeadDefinition(vertice, shape, head, fdef);
    createFixture(fdef);
    }
    

    @Override
    public void update(float dt) {
        stateTime += dt;
        if(!this.destroyed && controller.getX(this) < this.screen.getNinjaXPosition() + 224/GameConst.PPM) {
            body.setActive(true);
        }
        if(setToDestroy && !this.destroyed) {
            this.destroyed = true;
            world.destroyBody(body);
            controller.setDeathRegion(this);
            stateTime = 0;
        }
        else if(!this.destroyed) {
            body.setLinearVelocity(velocity);
            controller.upadeView(this, this.body, dt);
        }
    }
    
    @Override
    public void reverseVelocity(boolean x, boolean y) {
        if(x) {
                velocity.x = -velocity.x;
        }
        if(y) {
                velocity.y = -velocity.y;
        }      
    }

    @Override
    public boolean isSetToDestroy() {
        return this.setToDestroy;
    }

    @Override
    public void collide() {
        screen.addScore(this);
        setToDestroy = true;
    }

    @Override
    public boolean isDestroyed() {
        return this.destroyed;
    }

    @Override
    public float getStateTime() {
        return this.stateTime;
    }

    @Override
    public boolean isRunningLeft() {
        return this.runningLeft;
    }

    @Override
    public void setRunningLeft(boolean b) {
            this.runningLeft = b;
    }

    @Override
    public int getScore() {
        return RINO_SCORE;
    }
    
    private void createBody(BodyDef bdef) {
        bdef.position.set(controller.getX(this),controller.getY(this));
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);
        body.setActive(false);
    }
    
    private void fixtureBodyDefinition(FixtureDef fdef, CircleShape shape) {
        shape.setRadius(RinoModelImpl.CIRCCLE_RADIUS/GameConst.PPM);
        fdef.filter.categoryBits = GameConst.RINO;
        fdef.filter.maskBits = GameConst.GROUND
                                 | GameConst.BRICK
                                 | GameConst.NINJA
                                 | GameConst.RINO
                                 | GameConst.TURTLE
                                 | GameConst.GROUND_OBJECT
                                 | GameConst.FRUITBOX;
        fdef.shape = shape;
    }
    
    private void createFixture(FixtureDef fdef) {
        body.createFixture(fdef).setUserData(this);
    }
    
    private void fixtureHeadDefinition(Vector2[] vertice, CircleShape shape, PolygonShape head, FixtureDef fdef) {
        vertice[0] = new Vector2(-6,10).scl(1/GameConst.PPM);
        vertice[1] = new Vector2(+6,10).scl(1/GameConst.PPM);
        vertice[2] = new Vector2(-5,7).scl(1/GameConst.PPM);
        vertice[3] = new Vector2(+5,7).scl(1/GameConst.PPM);
        head.set(vertice);
        fdef.shape = head;
        fdef.restitution = 1f;
        fdef.filter.categoryBits = GameConst.RINO_HEAD;
    }
    
}