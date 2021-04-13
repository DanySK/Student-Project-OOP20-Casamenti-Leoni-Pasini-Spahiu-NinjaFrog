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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import it.unibo.ninjafrog.game.NinjaFrogGame;
import it.unibo.ninjafrog.utilities.GameConst;
/**
 * Definition of a MainMenu, which is an implementation of Screen.
 * MapsMenu is a menu where you can choose the level.
 */
public class LevelsMenu implements Screen {
    private final Stage stage;
    private NinjaFrogGame game;
    private final Label level1;
    private final Label level2;
    private final Label exit;
    private final Viewport viewport;
    private int currentLabel;
    private Texture background;
    private Texture selector;
    /**
     * Public constructor of a LevelsMenu object.
     * @param game NinjaFrogame
     */
    public LevelsMenu(final NinjaFrogGame game) {
        this.game = game;
        viewport = new FitViewport(GameConst.WIDTH, GameConst.HEIGHT, new OrthographicCamera());
        viewport.apply();
        stage = new Stage(viewport, game.getBatch());
        Gdx.input.setInputProcessor(stage);
        final Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        selector = new Texture("Selector.png");
        background = new Texture("Menu2backgorund");
        level1 = new Label("Level 1", font);
        level2 = new Label("Level 2", font);
        exit = new Label("Back", font);
        currentLabel = 1;
        final Table table = new Table();
        table.center();
        table.setFillParent(true);
        table.add(level1);
        table.row();
        table.add(level2);
        table.row();
        table.add(exit);
        stage.addActor(table);
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
