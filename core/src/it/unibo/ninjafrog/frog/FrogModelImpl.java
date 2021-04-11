package it.unibo.ninjafrog.frog;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import it.unibo.ninjafrog.enemies.EnemyModel;
import it.unibo.ninjafrog.hud.HudImpl;
import it.unibo.ninjafrog.screens.PlayScreen;

public class FrogModelImpl implements FrogModel {

    private Integer life = 1;
    private boolean isDoubleJump;
    private boolean runningRight;
    private PlayScreen screen;

    private final FrogState currentState;
    private final FrogState prevState;
    private Body body;
    private World world;

    public FrogModelImpl(final PlayScreen screen) {
        this.screen = screen;
        this.world = screen.getWorld();
        this.prevState = FrogState.STANDING;
        this.currentState = FrogState.STANDING;
        this.isDoubleJump = false;
        this.runningRight = true;
        
        

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
        if (body.getLinearVelocity().y > 0 || (body.getLinearVelocity().y < 0 && prevState == FrogState.DOUBLEJUMPING) && this.isDoubleJump){
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
        return this.isPaused();
    }

    @Override
    public void defineFrog() {
    }

    @Override
    public void defineDoubleJumpFrog() {
    }

    @Override
    public void setFrogHead() {
    }

    @Override
    public void update(final float dt) {
    }

    @Override
    public void hit(final EnemyModel enemy) {
    }

}
