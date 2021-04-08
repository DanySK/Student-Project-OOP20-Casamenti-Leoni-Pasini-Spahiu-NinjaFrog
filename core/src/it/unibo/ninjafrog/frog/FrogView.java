package it.unibo.ninjafrog.frog;

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
     */
    void draw();

}
