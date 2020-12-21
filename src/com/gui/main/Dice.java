package com.gui.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Dice extends MouseAdapter {
    String key = "";

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx, my, 50, 85, 70, 70)) {
            Random random = new Random();
            int num = random.nextInt(5 - 1) + 1;
            key = "d4: " + num;
        } else if (mouseOver(mx, my, 150, 85, 70, 70)) {
            Random random = new Random();
            int num = random.nextInt(7 - 1) + 1;
            key = "d6: " + num;
        } else if (mouseOver(mx, my, 250, 85, 70, 70)) {
            Random random = new Random();
            int num = random.nextInt(9 - 1) + 1;
            key = "d8: " + num;
        } else if (mouseOver(mx, my, 50, 170, 70, 70)) {
            Random random = new Random();
            int num = random.nextInt(11 - 1) + 1;
            key = "d10: " + num;
        } else if (mouseOver(mx, my, 150, 170, 70, 70)) {
            Random random = new Random();
            int num = random.nextInt(13 - 1) + 1;
            key = "d12: " + num;
        } else if (mouseOver(mx, my, 350, 85, 155, 155)) {
            Random random = new Random();
            int num = random.nextInt(21 - 1) + 1;
            key = "d20: " + num;
        } else if (mouseOver(mx, my, 250, 170, 70, 70)) {
            Random random = new Random();
            int num = random.nextInt(101 - 1) + 1;
            key = "d100: " + num;
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            return my > y && my < y + height;
        } else
            return false;
    }

    public void tick() {
    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 25);
        Font fnt1 = new Font("arial", Font.BOLD, 50);

        // d4
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawRect(50, 85, 70, 70);
        g.drawString("d4", 72, 128);

        // d10
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

        g.drawString("Output " + key, 525, 180);

        g.setFont(fnt1);
        g.drawRect(350, 85, 155, 155);
        g.drawString("d20", 385, 180);
    }
}
