package it.unibo.ninjafrog.hud;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;

public interface Hud extends Disposable{
    /**
     *  add points to the hud.
     *  @param value ,the points to add
     */
    void addScore(int value);

    /**
     * add one life to the hud.
     */
    void addLife();

    /**
     * @return the remaining life.
     */
    Integer getLife();

    /**
     * remove one life from the hud.
     */
    void removeLife();

    /**
     * @return the stage.
     */
    Stage getStage();

    /**
     * reset the doublejump's timer.
     */
    void resetTimer();

    /**
     * @return true if the timer is over
     */
    boolean isTimerOver();
    /**
     * @param dt, delta of time.
     * @return true if the hud is to update.
     */
    boolean update(float dt);
}
