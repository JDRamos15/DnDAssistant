package com.gui.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<ProgramObject> object = new LinkedList<>();

    public void tick() {
        for (ProgramObject tempObject : object) {
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (ProgramObject tempObject : object) {
            tempObject.render(g);
        }
    }

    public void addObject(ProgramObject object) {
        this.object.add(object);
    }

    public void deleteObject(ProgramObject object) {
        this.object.remove(object);
    }
}
