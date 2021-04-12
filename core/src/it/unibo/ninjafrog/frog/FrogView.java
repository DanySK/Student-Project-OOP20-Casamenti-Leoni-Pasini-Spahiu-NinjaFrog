package it.unibo.ninjafrog.frog;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface FrogView {

    /**
     * set the frog to the screen.
     * @param frog model;
     */
    void setFrog(FrogModel frog);
    /**
     * update the view.
     * @param dt delta of time;
     */
    void update(float dt);
    /**
     * draw the frog in the Playscreen.
     * @param batch the batch.
     */
    void draw(Batch batch);

}
