package it.unibo.ninjafrog.hud;

public interface Hud {
    /**
     *  add points to the hud.
     *  @param i , the points to add
     */
    void addScore(int i);

    /**
     * add one life to the hud.
     */
    void addLife();

    /**
     * remove one life from the hud.
     */
    void removeLife();

}
