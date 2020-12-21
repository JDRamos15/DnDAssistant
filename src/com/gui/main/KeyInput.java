package com.gui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    String maxHealth1 = "";
    private final HealthBar health;
    private final GUI gui;

    public KeyInput(GUI gui) {
        this.gui = gui;
        health = new HealthBar();
    }

    public void keyPressed(KeyEvent e) {
        if (Character.isDigit(e.getKeyChar()) && maxHealth1.length() < 3) {
            maxHealth1 += e.getKeyChar();
        }
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && !maxHealth1.isEmpty()) {
            maxHealth1 = maxHealth1.substring(0, maxHealth1.length() - 1);
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (maxHealth1.isEmpty()) {
                System.out.println("Health cant be null");
            } else {
                int i = Integer.parseInt(maxHealth1);
                health.setMaxHealth(i);

                gui.programState = GUI.STATE.general;
            }
        }
    }

    public void render(Graphics g) {
        // All that's missing is to fix the starting here and mvp will be "done"

        Font fnt1 = new Font("arial", Font.BOLD, 35);

        g.setFont(fnt1);
        g.setColor(Color.white);
        g.drawString("Please put your max health: ", 0, 45);

        g.drawString(maxHealth1, 500, 45);
    }
}
