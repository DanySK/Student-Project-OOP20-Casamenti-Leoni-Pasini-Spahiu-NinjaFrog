package it.unibo.ninjafrog.fruits;

import it.unibo.ninjafrog.screens.PlayScreen;

/**
 * Definition of the FruitBulder interface.
 */
public interface FruitBuilder {
    /**
     * Select the screen to use the object.
     * @param screen 
     * @return The builder object itself
     */
    FruitBuilder selectScreen(PlayScreen screen);
    /**
     * Choose the spawn x position.
     * @param x float value
     * @return The builder object itself
     */
    FruitBuilder chooseXPosition(float x);
    /**
     * Choose the spawn y position. 
     * @param y float value
     * @return The builder object itself
     */
    FruitBuilder chooseYPosition(float y);
    /**
     * Select the type of the fruit.
     * @param type enum of fruit type
     * @return The builder object itself
     */
    FruitBuilder selectFruitType(FruitType type);
    /**
     * Build method to be called when you have set the parameters.
     * @return A new FruitPowerUp
     */
    FruitPowerUp build();
}
