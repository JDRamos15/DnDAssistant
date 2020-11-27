package com.gui.main;

import java.awt.*;

public abstract class ProgramObject {

    protected int x, y;

    public ProgramObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
