package it.unibo.ninjafrog.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/**
 * Definition of the NinjaFrogGame class.
 * Main {@link com.badlogic.gdx.Game Game} class of the application.
 */
public final class NinjaFrogGame extends Game {
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.batch.begin();
        this.batch.end();
    }

    @Override
    public void dispose() {
        this.batch.dispose();
    }
    /**
     * Getter of the batch.
     * @return The {@link com.badlogic.gdx.graphics.g2d.SpriteBatch batch} of the {@link NinjaFrogGame}.
     */
    public SpriteBatch getBatch() {
        return this.batch;
    }
}
