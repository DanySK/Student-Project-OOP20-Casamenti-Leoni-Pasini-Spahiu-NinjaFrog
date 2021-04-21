package it.unibo.ninjafrog.game.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Disposable;


public final class SoundManagerImpl implements SoundManager, Disposable {

    private final AssetManager assetManager;
    private Music musicMenu;
    private Music musicGame;
    private boolean state;

    public SoundManagerImpl() {
        this.state = true;
        assetManager = new AssetManager();
        loadSong();
    }

    @Override
    public void loadSong() {
        musicMenu = (Music) Gdx.audio.newMusic(Gdx.files.internal("introSong.mp3")); // menu song
        musicGame = (Music) Gdx.audio.newMusic(Gdx.files.internal("playSong.mp3")); // play song
       // assetManager.load(fileName, Sound.class);
        assetManager.finishLoading();
    }

    @Override
    public void changeState() {
        if (state) {
            this.state = false;
            musicGame.stop();
            musicMenu.stop();
        } else {
            this.state = true;
            playMenuSong();
        }
    }
    @Override
    public void playMenuSong() {
        if (state) {
            musicGame.stop();
            musicMenu.play();
            musicMenu.setLooping(true);
        }
    }

    @Override
    public void playGameSong() {
        if (state) {
            musicMenu.stop();
            musicGame.play();
            musicGame.setLooping(true);
        }
    }

    @Override
    public void dispose() {
        musicMenu.dispose();
        musicGame.dispose();
    }

    @Override
    public boolean isState() {
        return this.state;
    }

    @Override
    public void pauseGameSong() {
        this.musicGame.pause();
    }
}
