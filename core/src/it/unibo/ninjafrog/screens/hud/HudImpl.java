package it.unibo.ninjafrog.screens.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import it.unibo.ninjafrog.utilities.GameConst;

public final class HudImpl implements Hud {
    private static final int BONUSTIMER = 10;
    private Stage stage;
    private Viewport viewport;

    private Integer score;
    private Integer life = 1;
    private Integer bonusTimer;
    private float timeCount;
    private boolean canInit;
    private boolean timerOn;

    private final Label countdownLabel;
    private final Label pointLabel;
    private final Label bonusLabel;
    private final Label lifeCounterLabel;
    private final Label lifeLabel;
    private final Label scoreLabel;


    public HudImpl(final SpriteBatch sb) {

        this.timeCount = 0;
        this.score = 0;
        this.canInit = true;
        this.timerOn = false;
        this.bonusTimer = BONUSTIMER;
        this.viewport = new FitViewport(GameConst.WIDTH, GameConst.HEIGHT, new OrthographicCamera());
        this.stage = new Stage(this.viewport, sb);

        final Table table = new Table();
        table.top();
        table.setFillParent(true);
        this.countdownLabel = new Label(String.format("%02d", 00), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.pointLabel = new Label(String.format("%06d", this.score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.lifeCounterLabel = new Label(String.format("%02d", life), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.bonusLabel = new Label("BONUS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.scoreLabel = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.lifeLabel = new Label("LIFE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(this.scoreLabel).padTop(10);
        table.add(this.lifeLabel).expandX().padTop(10);
        table.add(this.bonusLabel).expandX().padTop(10);
        table.row();
        table.add(this.pointLabel).expandX();
        table.add(this.lifeCounterLabel).expandX();
        table.add(this.countdownLabel).expandX();

        stage.addActor(table);
    }

    @Override
    public void addScore(final int value) {
        score += value;
        pointLabel.setText(String.format("%06d", this.score));
    }
    @Override
    public Integer getScore() {
        return this.score;
    }
    @Override
    public void addLife() {
        life += 1;
        lifeCounterLabel.setText(String.format("%02d", life));
    }

    @Override
    public void removeLife() {
        life -= 1;
        lifeCounterLabel.setText(String.format("%02d", life));
    }

    @Override
    public Stage getStage() {
        return this.stage;
    }
    @Override
    public boolean isTimerOn() {
        return this.timerOn;
    }
    @Override
    public void update(final float dt) {
        if (this.canInit) {
            this.countdownLabel.setText(String.format("%02d", this.bonusTimer));
            this.canInit = false;
        }
        this.timeCount += dt;
        if (this.timeCount >= 1) {
            this.bonusTimer--;
            this.countdownLabel.setText(String.format("%02d", this.bonusTimer));
            this.timeCount = 0;
            if (this.bonusTimer == 0) {
                this.bonusTimer = BONUSTIMER;
                this.canInit = true;
                this.timerOn = false;
                return;
            }
        }
        this.timerOn = true;
    }


}
