package com.gui.main;

import java.awt.*;

public class HealthBar {
    public static int maxHealth;
    public static int currentHealth;
    public static int Health;

    public void setMaxHealth(int MaxHealth) {
        maxHealth = MaxHealth;
        currentHealth = MaxHealth;
        Health = (currentHealth * 100) / maxHealth;
    }

    public void reduceHealth(int modifier) {
        if (currentHealth - modifier > 0) {
            currentHealth = currentHealth - modifier;
        } else if (currentHealth - modifier <= 0) {
            currentHealth = 0;
        }
        Health = (currentHealth * 100) / maxHealth;
    }

    public void addHealth(int modifier) {
        if (currentHealth < maxHealth && modifier + currentHealth <= maxHealth) {
            currentHealth = currentHealth + modifier;
        } else if (modifier + currentHealth >= maxHealth) {
            currentHealth = maxHealth;
        }
        Health = (currentHealth * 100) / maxHealth;
    }

    public void tick() {
        Health = GUI.clamp(Health, 0, 100);
    }

    public void render(Graphics g) {
        Font fnt1 = new Font("arial", Font.BOLD, 25);

        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, Health * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        g.setFont(fnt1);
        g.drawString("Health: " + currentHealth, 220, 40);
    }
}
