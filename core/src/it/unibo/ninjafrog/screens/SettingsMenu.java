package it.unibo.ninjafrog.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import it.unibo.ninjafrog.game.NinjaFrogGame;
import it.unibo.ninjafrog.utilities.GameConst;
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
    private final Texture selector;
    private final Texture background;
    /**
     * Public constructor of a SettingsMenu object.
     * @param game NinjaFroggame
     */
    public SettingsMenu(final NinjaFrogGame game) {
        this.game = game;
        viewport = new FitViewport(GameConst.WIDTH, GameConst.WIDTH, new OrthographicCamera());
        viewport.apply();
        stage = new Stage(viewport, game.getBatch());
        Gdx.input.setInputProcessor(stage);
        final Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        selector = new Texture("Selector.png");
        background = new Texture("Menu2background.png");
        musicLabel = new Label("Music: ON", font);
        exit = new Label("Back", font);
        currentLabel = 1;
        final Table table = new Table();
        table.center();
        table.setFillParent(true);
        table.add(musicLabel);
        table.row();
        table.add(exit);
        stage.addActor(table);
    }

    @Override
    public void render(final float delta) {
    }

    @Override
    public void show() {
    }

    @Override
    public void resize(final int width, final int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

}
