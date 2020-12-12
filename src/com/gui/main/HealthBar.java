package com.gui.main;

import java.awt.*;


public class HealthBar {

    public static int maxHealth = 12;
    public static int currentHealth = 1;

    public static int Health = (currentHealth * 100)/maxHealth;



    public void tick() {
        Health = GUI.clamp(Health, 0, 100);
    }


    public void render(Graphics g){
        Font fnt1 = new Font("arial", 1, 35);

        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, Health * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);

        g.drawString("Health: " + currentHealth, 220, 35);

        g.setColor(Color.red);
        g.fillRect(300, 18, 30, 30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        g.drawString("-" , 308, 42);

        g.setColor(Color.green);
        g.fillRect(350, 18, 30, 30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        g.drawString("+" , 355, 45);

    }
}
