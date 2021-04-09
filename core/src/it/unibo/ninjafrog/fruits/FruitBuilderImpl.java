package it.unibo.ninjafrog.fruits;

import it.unibo.ninjafrog.screens.PlayScreen;
/**
 * Definition of FruitBuillder implementation.
 *
 */
public final class FruitBuilderImpl implements FruitBuilder {
    private PlayScreen screen;
    private float x; 
    private float y;
    private FruitType type;
    /**
     * private constructor of a FruitBuilderImpl. 
     * 
     */
    private FruitBuilderImpl() {
    }
    /**
     * public static newBuilder that use FruitBuilderImpl.
     * @return FruitBuilderImpl new FruitBuilder object.
     */
    public static FruitBuilderImpl newBuilder() {
        return new FruitBuilderImpl();
    }
    @Override
    public FruitBuilder selectScreen(final PlayScreen screen) {
        this.screen = screen;
        return this;
    }

    @Override
    public FruitBuilder chooseXPosition(final float x) {
        this.x = x;
        return this;
    }

    @Override
    public FruitBuilder chooseYPosition(final float y) {
        this.y = y;
        return this;
    }

    @Override
    public FruitBuilder selectFruitType(final FruitType type) {
        this.type = type;
        return this;
    }

    @Override
    public FruitPowerUp build() {
        return new FruitPowerUpImpl(screen, x, y, type);
    }

}
