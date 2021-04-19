package it.unibo.ninjafrog.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import it.unibo.ninjafrog.screens.levels.Level;
import it.unibo.ninjafrog.screens.levels.LevelOne;
import it.unibo.ninjafrog.screens.levels.LevelTwo;

@RunWith(GdxTestRunner.class)
public class WorldLevelTests {
	private static final int GRAPHICS_LAYER = 1;
	private static final int GROUND_LAYER = 2;
    private static final int FINISH_TROPHY_LAYER = 6;
    private static final int NOT_A_LAYER = 9;

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
	
	@Test
	public void graphicLayerExist() {
		final TiledMap map1 = new TmxMapLoader().load(new LevelOne().getMap());
		final TiledMap map2 = new TmxMapLoader().load(new LevelTwo().getMap());
		assertNotNull(map1.getLayers().get(GRAPHICS_LAYER));
		assertNotNull(map2.getLayers().get(GRAPHICS_LAYER));
	}
	
	@Test
	public void layersExistLevels() {
		final TiledMap map1 = new TmxMapLoader().load(new LevelOne().getMap());
		final TiledMap map2 = new TmxMapLoader().load(new LevelTwo().getMap());
		System.out.println(map1.getLayers().getCount());
		for (int layer = GROUND_LAYER; layer <= FINISH_TROPHY_LAYER; layer++) {
			assertTrue(layer < map1.getLayers().getCount());
			assertTrue(layer < map2.getLayers().getCount());
			assertNotNull(map1.getLayers().get(layer).getObjects().getByType(RectangleMapObject.class));
			assertNotNull(map2.getLayers().get(layer).getObjects().getByType(RectangleMapObject.class));
			assertFalse(map1.getLayers().get(layer).getObjects().getByType(RectangleMapObject.class).isEmpty());
			assertFalse(map2.getLayers().get(layer).getObjects().getByType(RectangleMapObject.class).isEmpty());
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void indexLayersExceptionLevOne() {
		final TiledMap map = new TmxMapLoader().load(new LevelOne().getMap());
		map.getLayers().get(NOT_A_LAYER);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void indexLayersExceptionLevTwo() {
		final TiledMap map = new TmxMapLoader().load(new LevelTwo().getMap());
		map.getLayers().get(NOT_A_LAYER);
	}
}
