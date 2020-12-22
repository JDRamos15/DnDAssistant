package com.gui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HealthManager extends KeyAdapter implements MouseListener {
    private final HealthBar health;
    public String modifier = "";

    public HealthManager() {
        health = new HealthBar();
    }

    public void mouseClicked(MouseEvent e) {
        // Not using
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx, my, 600)) {
            if (modifier.isEmpty()) {
                System.out.println("No modifier to add to health");
            } else {
                int i = Integer.parseInt(modifier);
                health.reduceHealth(i);
            }
        }

        if (mouseOver(mx, my, 700)) {
            if (modifier.isEmpty()) {
                System.out.println("No modifier to add to health");
            } else {
                int i = Integer.parseInt(modifier);
                health.addHealth(i);
            }
        }
    }

    private boolean mouseOver(int mx, int my, int x) {
        if (mx > x && mx < x + 30)
            return my > 18 && my < 18 + 30;
        else
            return false;
    }

    public void mouseReleased(MouseEvent e) {
        // Not using
    }

    public void mouseEntered(MouseEvent e) {
        // Not using
    }

    public void mouseExited(MouseEvent e) {
        // Not using
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (Character.isDigit(e.getKeyChar()) && modifier.length() < 2) {
            modifier += e.getKeyChar();
        }
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && !modifier.isEmpty()) {
            modifier = modifier.substring(0, modifier.length() - 1);
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            modifier = "0";
        }
    }
    
    public void tick() {
    }

    public void render(Graphics g) {
        Font fnt1 = new Font("arial", Font.BOLD, 25);

        g.setColor(Color.red);
        g.fillRect(600, 18, 30, 30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        g.drawString("-", 610, 42);

        g.setColor(Color.white);
        g.drawString(modifier, 658, 42);

        g.setColor(Color.green);
        g.fillRect(700, 18, 30, 30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        g.drawString("+", 707, 45);
    }
}
