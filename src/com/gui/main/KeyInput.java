package com.gui.main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {


    public void render(Graphics g){
        Rectangle r = new Rectangle(35,60,250,30);

        g.setColor(Color.blue);
        g.fillRect(r.x, r.y, r.width, r.height);
        g.setColor(Color.black);

//        g.drawString(key, r.x, r.y+r.height);
    }

}
