package it.unibo.ninjafrog.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import it.unibo.ninjafrog.utilities.GameConst;

public class HudImpl implements Hud {

    private Stage stage;
    private Viewport viewport;

    private Integer score;
    private Integer life;
    private Integer bonusTimer;
    private float timeCount;

    private Label countdownLabel;
    private Label pointLabel;
    private Label bonusLabel;
    private Label levelLabel;
    private Label lifeLabel;
    private Label scoreLabel;


    public HudImpl(final SpriteBatch sb) {

        this.timeCount = 0;
        this.score = 0;
        this.bonusTimer = GameConst.BONUSTIMER;
        this.viewport = new FitViewport(GameConst.WIDTH, GameConst.HEIGHT, new OrthographicCamera());
        this.stage = new Stage(this.viewport, sb);

        final Table table = new Table();
        table.top();
        table.setFillParent(true);
        this.countdownLabel = new Label(String.format("%02d", 00), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.pointLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.levelLabel = new Label(String.format("%02d", getLife()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.bonusLabel = new Label("BONUS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.scoreLabel = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.lifeLabel = new Label("LIFE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(this.scoreLabel).padTop(10);
        table.add(this.lifeLabel).expandX().padTop(10);
        table.add(this.bonusLabel).expandX().padTop(10);
        table.row();
        table.add(this.pointLabel).expandX();
        table.add(this.levelLabel).expandX();
        table.add(this.countdownLabel).expandX();

        stage.addActor(table);
    }

    @Override
    public void addScore(final int value) {
        score += value;
        scoreLabel.setText(String.format("%06d", score));
    }

    @Override
    public void addLife() {

    }

    @Override
    public void removeLife() {

    }

    @Override
    public Stage getStage() {
        return this.stage;
    }

    @Override
    public void resetTimer() {
        if(this.isTimerOver()) {
            this.countdownLabel.setText(String.format("%02d", this.bonusTimer));
        }
    }

    @Override
    public Integer getLife() {
        return null;
    }

    @Override
    public boolean isTimerOver() {
        return false;
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean update(float dt) {
        // TODO Auto-generated method stub
        return false;
    }

}
