package it.unibo.ninjafrog.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.Gdx;

import it.unibo.ninjafrog.screens.levels.Level;
import it.unibo.ninjafrog.screens.levels.LevelOne;
import it.unibo.ninjafrog.screens.levels.LevelTwo;

@RunWith(GdxTestRunner.class)
public class WorldLevelTests {

	@Test
	public void levelOneExists() {
		final Level level = new LevelOne();
		assertTrue("This test will only pass if the tmx file of the Map exists in the assets folder.", Gdx.files
				.internal("../core/assets/" + level.getMap()).exists());
	}

	@Test
	public void levelTwoExists() {
		final Level level = new LevelTwo();
		assertTrue("This test will only pass if the tmx file of the Map exists in the assets folder.", Gdx.files
				.internal("../core/assets/" + level.getMap()).exists());
	}

	@Test
	public void backgroundsExist() {
		assertTrue("This test will only pass if the jpg/png and tsx files of the backgrounds exist in the assets folder.", Gdx.files
				.internal("../core/assets/Level1background.jpg").exists());
		assertTrue(Gdx.files.internal("../core/assets/Level2background.png").exists());
		assertTrue(Gdx.files.internal("../core/assets/Level1background.tsx").exists());
		assertTrue(Gdx.files.internal("../core/assets/Level2background.tsx").exists());
	}

	@Test
	public void assetExists() {
		assertTrue("This test will only pass if the png and tsx files of the asset exist in the assets folder.", Gdx.files
				.internal("../core/assets/NinjaFrogAsset.png").exists());
		assertTrue(Gdx.files.internal("../core/assets/NinjaFrogAsset.tsx").exists());
	}
}
