package it.unibo.ninjafrog.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.Gdx;

import it.unibo.ninjafrog.fruits.FruitBuilderImpl;
import it.unibo.ninjafrog.fruits.FruitPowerUp;
import it.unibo.ninjafrog.fruits.FruitPowerUpImpl;

/**
 * Automated tests for the FruitPowerUp: cherry, melon, orange. 
 */
@RunWith(GdxTestRunner.class)
public class FruitPowerUpTest {
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final String ASSETS_PATH = ".." + FILE_SEPARATOR + "core" + FILE_SEPARATOR + "assets" + FILE_SEPARATOR;
	/**
	 * Test for the asset file
	 * Asset file includes cherry, melon and orange Texture.
	 */
	@Test
	public void assetExists() {
		assertTrue("This test will only pass if the png and tsx files of the asset exist in the assets folder.", 
				Gdx.files.internal(ASSETS_PATH + "ninjaAndEnemies").exists());
	}
	/**
	 * {@link it.unibo.ninjafrog.fruits.FruitBuilderImpl FruitBuilderImpl} test.
	 */
	@Test (expected = IllegalStateException.class)
	public void buildThrowsException() {
		@SuppressWarnings("unused")
		final FruitPowerUp fruit = FruitBuilderImpl.newBuilder()
				.chooseXPosition(0)
				.chooseYPosition(0)
				.selectScreen(null)
				.selectFruitType(null)
				.build();
	}
	
}
