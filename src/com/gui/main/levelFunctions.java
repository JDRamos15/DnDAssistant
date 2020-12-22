package com.gui.main;

public class levelFunctions {
    int baseCap = 1000;
    int previousCap = 0;

    public int getNewLevelCap(int level, int levelCap) {
        if (level == 0) {
            return baseCap;
        }
        int experienceCap = (int) (baseCap + levelCap * 0.10);
        previousCap = experienceCap;
        return (experienceCap + getNewLevelCap(level - 1, previousCap));
    }

    public int getLevel(int level, int levelCap) {
        if (level == 0) {
            return baseCap;
        }
        int experienceCap = (int) (baseCap + levelCap * 0.10);
        previousCap = experienceCap;
        return (experienceCap + getLevel(level - 1, previousCap));
    }
}
