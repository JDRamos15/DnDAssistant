package com.gui.main;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class Dice extends MouseAdapter {
    public int d4 = 4;
    public int d6 = 6;
    public int d8 = 8;
    public int d10 = 10;
    public int d12 = 12;
    public int d20 = 20;
    public int d100 = 100;

    public void tick() {

    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", 1, 25);
        Font fnt1 = new Font("arial", 1, 50);


        //d4
        g.setFont(fnt);
        g.drawRect(50, 85, 70, 70);
        g.drawString("d4", 72, 128);

        //d10
        g.drawRect(50, 170, 70, 70);
        g.drawString("d10", 63, 215);

        g.drawRect(150, 85, 70, 70);
        g.drawString("d6", 171, 128);

        g.drawRect(150, 170, 70, 70);
        g.drawString("d12", 163, 215);

        g.drawRect(250, 85, 70, 70);
        g.drawString("d8", 271, 128);

        g.drawRect(250, 170, 70, 70);
        g.drawString("d100", 257, 215);

        g.setFont(fnt1);
        g.drawRect(350, 85, 155, 155);
        g.drawString("d20", 385, 180);
    }
}
