package it.unibo.ninjafrog.frog;

import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import it.unibo.ninjafrog.screens.PlayScreen;
import it.unibo.ninjafrog.utilities.GameConst;

public class FrogModelImpl implements FrogModel {
    private static final int RADIUS = 7;

    private Integer life = 1;
    private boolean isDoubleJump;
    private boolean runningRight;
    private boolean paused;
    private PlayScreen screen;

    private final FrogState currentState;
    private final FrogState prevState;
    private Body body;
    private final  World world;

    public FrogModelImpl(final PlayScreen screen) {
        this.screen = screen;
        this.world = screen.getWorld();
        this.prevState = FrogState.STANDING;
        this.currentState = FrogState.STANDING;
        this.isDoubleJump = false;
        this.runningRight = true;
        this.paused = false;

    }
    @Override
    public Body getBody() {
        return this.body;
    }

    @Override
    public Vector2 getPos() {
        return body.getPosition();
    }

    @Override
    public FrogState getState() {
        if (body.getLinearVelocity().y > 0 || (body.getLinearVelocity().y < 0 && prevState == FrogState.DOUBLEJUMPING) && this.isDoubleJump) {
            return FrogState.DOUBLEJUMPING;
        } else if (body.getLinearVelocity().y > 0 || (body.getLinearVelocity().y < 0 && prevState == FrogState.JUMPING) && !this.isDoubleJump) {
            return FrogState.JUMPING;
        } else if (body.getLinearVelocity().y < 0) {
            return FrogState.FALLING;
        } else if (body.getLinearVelocity().x != 0) {
            return FrogState.RUNNING;
        } else {
            return FrogState.STANDING;
        }
    }

    @Override
    public void setState() {
    }

    @Override
    public void jump() {
        if (this.currentState != FrogState.JUMPING && this.currentState != FrogState.FALLING) {
            body.applyLinearImpulse(new Vector2(0, 4f), body.getWorldCenter(), true);
        }
    }

    @Override
    public void doubleJump() {
        
    }

    @Override
    public void move(final float direction) {
    }

    @Override
    public boolean isDoubleJumpActive() {
        return this.isDoubleJump;
    }

    @Override
    public void setDoubleJump(final boolean isDoubleJump) {
        this.isDoubleJump = isDoubleJump;
    }

    @Override
    public boolean isRunningRight() {
        return this.runningRight;
    }
    @Override
    public void addLife() {
        this.life++;
    }

    @Override
    public void removeLife() {
        this.life -= 1;
        if (this.life == 0) {
            screen.setGameOverScreen();
        }
    }

    @Override
    public boolean isPaused() {
        return this.paused;
    }

    @Override
    public void defineFrog() {
        final BodyDef bdef = new BodyDef();
        bdef.position.set(220 / GameConst.PPM, 220 / GameConst.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        final FixtureDef fdef = new FixtureDef();
        final CircleShape  shape = new CircleShape();
        shape.setRadius(RADIUS / GameConst.PPM);

        fdef.filter.categoryBits = GameConst.NINJA;
        fdef.filter.maskBits = GameConst.GROUND
                | GameConst.FRUITBOX
                | GameConst.BRICK
                | GameConst.RINO
                | GameConst.RINO_HEAD
                | GameConst.TURTLE
                | GameConst.TURTLE_HEAD
                | GameConst.GROUND_OBJECT
                | GameConst.FRUIT
                | GameConst.FINISH;
        fdef.shape = shape;
        body.createFixture(fdef).setUserData(this);

        /*
         * define frog head
         */
        final EdgeShape head = new EdgeShape();
        head.set(new Vector2(-2 / GameConst.PPM, RADIUS / GameConst.PPM), new Vector2(+2 / GameConst.PPM, RADIUS / GameConst.PPM));
        fdef.shape = head;
        fdef.isSensor = true;
        fdef.filter.categoryBits = GameConst.NINJA_HEAD;
        body.createFixture(fdef).setUserData(this);
    }

    @Override
    public void update(final float dt) {
    }

}
