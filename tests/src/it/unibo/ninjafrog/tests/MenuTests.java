package it.unibo.ninjafrog.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.Gdx;

/**
 * Automated tests for all menu in the game.
 * MenuTests includes WinScreen and GameOverScreen.
 */
@RunWith(GdxTestRunner.class)
public class MenuTests {
	/**
	 * Test for the MainMenu background files.
	 */
	@Test
	public void FirstMenuExists() {
		assertTrue("This test will only pass if the jpg/png files of the backgrounds exist in the assets folder.",
				Gdx.files.internal("../core/assets/Menu1background.png").exists());
	}
	/**
	 * Test for the SecondaryMenu background files.
	 * Secondary menu includes SettingsMenu and LevelsMenu.
	 */
	@Test
	public void SecondaryMenuExists() {
		assertTrue("This test will only pass if the jpg/png files of the backgrounds exist in the assets folder.",
				Gdx.files.internal("../core/assets/Menu2background.png").exists());
	}
	/**
	 * Tests for the WinScreen background files.
	 */
	@Test
	public void WinScreenExists() {
		assertTrue("This test will only pass if the jpg/png files of the backgrounds exist in the assets folder.",
				Gdx.files.internal("../core/assets/Win_Screen.png").exists());
	}
	/**
	 * Tests for the GameOverScreen background files.
	 */
	@Test
	public void GameOverExists() {
		assertTrue("This test will only pass if the jpg/png files of the backgrounds exist in the assets folder.",
				Gdx.files.internal("../core/assets/GameOver_Screen.png").exists());
	}
}
