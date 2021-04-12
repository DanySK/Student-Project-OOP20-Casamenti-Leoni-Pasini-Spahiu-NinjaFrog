package it.unibo.ninjafrog.screens;

import com.badlogic.gdx.Gdx;
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
 *
 */
public class MainMenu implements Menu {
    private NinjaFrogGame game;
    private final Stage stage;
    private final Viewport viewport;
    private final Label playLabel;
    private final Label settingsLabel;
    private final Label quitLabel;
    private int currentLabel;
    private final Texture background;
    private final Texture selector;
    private Label.LabelStyle font;
   /**
    * 
    * @param game
    */
    public MainMenu(final NinjaFrogGame game) {
        this.game = game;
        viewport = new FitViewport(GameConst.WIDTH, GameConst.HEIGHT, new OrthographicCamera());
        viewport.apply();
        stage = new Stage(viewport, game.getBatch());
        Gdx.input.setInputProcessor(stage);
        background = new Texture("Menu1background.png");
        selector = new Texture("Selector.png");
        font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        currentLabel = 1;
        playLabel = new Label("Play", font);
        settingsLabel = new Label("Setting", font);
        quitLabel = new Label("Exit", font);
        final Table table = new Table();
        table.center();
        table.setFillParent(true);
        table.row();
        table.add(playLabel);
        table.row();
        table.add(settingsLabel);
        table.row();
        table.add(quitLabel);
        stage.addActor(table);
    }
@Override
public void show() {
    // TODO Auto-generated method stub
    
}
@Override
public void render(float delta) {
    // TODO Auto-generated method stub
    
}
@Override
public void resize(int width, int height) {
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
@Override
public void handleInput() {
    // TODO Auto-generated method stub
    
}
@Override
public void setMenu() {
    // TODO Auto-generated method stub
    
}
  
}
