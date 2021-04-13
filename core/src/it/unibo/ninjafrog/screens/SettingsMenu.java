package it.unibo.ninjafrog.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;

import it.unibo.ninjafrog.game.NinjaFrogGame;
/**
 *  Definition of a SettingsMenu, which is an implementation of Screen.
 *  SettingsMenu is a menu where you can set the game music. 
 */
public class SettingsMenu implements Screen {
    private final Stage stage;
    private final NinjaFrogGame game;
    private final Label musicLabel;
    private final Label exit;
    private final Viewport viewport;
    private int currentLabel;
    private Texture selector;
    private Texture background;
    /**
     * Public constructor of a SettingsMenu object.
     * @param game NinjaFroggame
     */
    public SettingsMenu(final NinjaFrogGame game) {
        this.game = game;
        
        
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(final float delta) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resize(final int width, final int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

}
