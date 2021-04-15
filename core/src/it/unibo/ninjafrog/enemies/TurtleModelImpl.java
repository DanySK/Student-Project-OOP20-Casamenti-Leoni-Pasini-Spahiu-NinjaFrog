package it.unibo.ninjafrog.enemies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import it.unibo.ninjafrog.screens.PlayScreen;
import it.unibo.ninjafrog.utilities.GameConst;

public class TurtleModelImpl implements TurtleModel{
    
    private World world;
    private PlayScreen screen;
    public Body body;
    public Vector2 velocity;
    private static final int CIRCLE_RADIUS = 7;
    private static final int TURTLE_SCORE = 200;
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
        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        PolygonShape head = new PolygonShape();
        Vector2[] vertice = new Vector2[4];
        createBody(bdef);
        fixtureBodyDefinition(fdef,shape);
        createFixture(fdef);
        fixtureHeadDefinition(fdef,head,shape,vertice);
        createFixture(fdef);

    }

    private void fixtureHeadDefinition(FixtureDef fdef, PolygonShape head, CircleShape shape, Vector2[] vertice) {
        vertice[0] = new Vector2(-7,10).scl(1/GameConst.PPM);
        vertice[1] = new Vector2(7,10).scl(1/GameConst.PPM);
        vertice[2] = new Vector2(-5,7).scl(1/GameConst.PPM);
        vertice[3] = new Vector2(5,7).scl(1/GameConst.PPM);
        head.set(vertice);
        fdef.shape = head;
        fdef.restitution = 1f;
        fdef.filter.categoryBits = GameConst.TURTLE_HEAD;
    }

    private void createFixture(FixtureDef fdef) {
        body.createFixture(fdef).setUserData(this);
    }

    private void fixtureBodyDefinition(FixtureDef fdef, CircleShape shape) {
        shape.setRadius(TurtleModelImpl.CIRCLE_RADIUS/GameConst.PPM);
        fdef.filter.categoryBits = GameConst.TURTLE;
        fdef.filter.maskBits = GameConst.GROUND
                                | GameConst.BRICK
                                | GameConst.RINO
                                | GameConst.TURTLE
                                | GameConst.GROUND_OBJECT
                                | GameConst.NINJA
                                | GameConst.FRUITBOX;
        fdef.shape = shape;
    }

    private void createBody(BodyDef bdef) {
        bdef.position.set(controller.getX(this), controller.getY(this));
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);
        body.setActive(true);
    }

    @Override
    public void update(float dt) {
        stateTime += dt;
        if(setToDestroy && !this.destroyed) {
            this.destroyed = true;
            world.destroyBody(body);
            controller.setDeathRegion(this);
            stateTime = 0;
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
        screen.addScore(this);
        setToDestroy = true;
    }

    @Override
    public int getScore() {
        return TURTLE_SCORE;
    }
   


}
