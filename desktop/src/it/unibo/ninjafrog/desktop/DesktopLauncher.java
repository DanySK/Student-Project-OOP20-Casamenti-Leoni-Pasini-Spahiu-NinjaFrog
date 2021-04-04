package it.unibo.ninjafrog.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import it.unibo.ninjafrog.game.NinjaFrogGame;

/**
 * DesktopLauncher of the game, which contains the main method.
 */
public final class DesktopLauncher {
    private static final int GAME_WIDTH = 1200;
    private static final int GAME_HEIGHT = 624;
    private DesktopLauncher() {
    }

    /**
     * Main method of the application.
     * @param arg Command line parameters.
     */
    public static void main(final String[] arg) {
        final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = DesktopLauncher.GAME_WIDTH;
        config.height = DesktopLauncher.GAME_HEIGHT;
        new LwjglApplication(new NinjaFrogGame(), config);
    }
}
