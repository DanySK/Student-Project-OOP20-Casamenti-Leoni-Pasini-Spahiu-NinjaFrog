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
    private static final float VEL_MAX = 2.5f;
    private static final int RADIUS = 7;
    private static final int X_INIT_POS = 240;
    private static final int Y_INIT_POS = 240;
    private static final int HEAD = 2;

    private Integer life = 1;
    private boolean isDoubleJump;
    private final PlayScreen screen;
    private FrogState currentState;
    private final FrogState prevState;
    private Body body;
    private final World world;
    private final FrogController frogController;

    public FrogModelImpl(final PlayScreen screen, final FrogController frogController) {
        this.frogController = frogController;
        this.screen = screen;
        this.world = screen.getWorld();
        this.prevState = FrogState.STANDING;
        this.currentState = FrogState.STANDING;
        this.isDoubleJump = false;
        defineFrog();
    }
    @Override
    public final Body getBody() {
        return this.body;
    }

    @Override
    public final Vector2 getPos() {
        return body.getPosition();
    }

    @Override
    public final FrogState getState() {
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
    public final void jump() {
        if (getState() == FrogState.DOUBLEJUMPING) {

    } else if (getState() != FrogState.JUMPING && getState() != FrogState.FALLING) {
            body.applyLinearImpulse(new Vector2(0, 4f), body.getWorldCenter(), true);
        } else if (isDoubleJumpActive() && !isDoubleJump) {
            isDoubleJump = true;
            if (body.getLinearVelocity().y < 0) {
                if (getState() != FrogState.FALLING && this.prevState != FrogState.FALLING) {
                    body.applyLinearImpulse(new Vector2(0, -body.getLinearVelocity().y + 4f), body.getWorldCenter(), true);
                }
            } else {
                body.applyLinearImpulse(new Vector2(0, 4f - body.getLinearVelocity().y), body.getWorldCenter(), true);
            }
        }
    }
    @Override
    public final void move(final float direction) {
        if (direction > 0) {
            if (body.getLinearVelocity().x <= 2) {
                body.applyLinearImpulse(new Vector2(direction, 0), body.getWorldCenter(), true);
            }
        } else {
            if (body.getLinearVelocity().x >= -2) {
                body.applyLinearImpulse(new Vector2(direction, 0), body.getWorldCenter(), true);
                }
            }
    }

    @Override
    public final boolean isDoubleJumpActive() {
        return this.isDoubleJump;
    }

    @Override
    public final void setDoubleJump(final boolean isDoubleJump) {
        this.isDoubleJump = isDoubleJump;
    }
    @Override
    public final void addLife() {
        this.life++;
    }

    @Override
    public final void removeLife() {
        this.life -= 1;
        if (this.life == 0) {
            this.screen.setGameOverScreen();
        }
    }
    @Override
    public final void defineFrog() {
        final BodyDef bdef = new BodyDef();
        bdef.position.set(X_INIT_POS / GameConst.PPM, Y_INIT_POS / GameConst.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        this.body = world.createBody(bdef);

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
        head.set(new Vector2(-HEAD / GameConst.PPM, RADIUS / GameConst.PPM), new Vector2(HEAD / GameConst.PPM, RADIUS / GameConst.PPM));
        fdef.shape = head;
        fdef.isSensor = true;
        fdef.filter.categoryBits = GameConst.NINJA_HEAD;
        body.createFixture(fdef).setUserData(this);
    }

    @Override
    public final void update(final float dt) {

        if (this.body.getLinearVelocity().y < -VEL_MAX) {
           body.setLinearVelocity(body.getLinearVelocity().x, -VEL_MAX);
        }
        if (body.getPosition().y < 0) {
            if (this.life > 0) {
                this.screen.removeLife();
                this.world.destroyBody(this.body);
                this.defineFrog();
            } else {
                this.screen.setGameOverScreen();
            }
        }

    }
}
