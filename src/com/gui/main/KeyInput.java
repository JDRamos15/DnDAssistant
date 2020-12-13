package com.gui.main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyInput extends KeyAdapter {
    String maxHealth1 = "";
    private HealthBar health;
    private GUI gui;
    private Handler handler;

    public KeyInput(GUI gui, Handler handler){
        this.gui = gui;
        this.handler = handler;
        health = new HealthBar();
    }
    public void keyPressed(KeyEvent e){
        if(Character.isDigit(e.getKeyChar()) && maxHealth1.length() < 3){
            maxHealth1+=e.getKeyChar();
        }
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && !maxHealth1.isEmpty()){
            maxHealth1 = maxHealth1.substring(0, maxHealth1.length() - 1);
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(maxHealth1.isEmpty()){
                System.out.println("Health cant be null");
            } else {
                int i = Integer.parseInt(maxHealth1);
                health.setMaxHealth(i);
                gui.programState = GUI.STATE.general;
            }
        }
        //Te falta hacer que el input que pongas sea un num y se pase


        //you might not need this is you are rendering constantly
    }

    public void render(Graphics g){
        Rectangle r = new Rectangle(35,60,250,30);

        Font fnt1 = new Font("arial", 1, 35);

        g.setFont(fnt1);
        g.setColor(Color.blue);
        g.fillRect(r.x, r.y, r.width, r.height);
        g.setColor(Color.black);

        g.drawString(maxHealth1, r.x, r.y+r.height);
    }
}
