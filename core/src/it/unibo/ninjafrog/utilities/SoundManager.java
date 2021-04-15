package it.unibo.ninjafrog.utilities;

public interface SoundManager {
    /**
     * load the mp3 file in the game.
     */
    void loadSong();
    /**
     * change the state of the music.
     */
    void changeState();
    /**
     * play the menu song.
     */
    void playMenuSong();
    /**
     * play the game song.
     */
    void playGameSong();
}

