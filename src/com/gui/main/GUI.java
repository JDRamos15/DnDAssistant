package com.gui.main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class GUI  extends Canvas implements Runnable {
    private Thread thread;
    private boolean isRunning = false;
    private Handler handler;
    private HealthBar health;
    private KeyInput input1;
    private Dice dice;
    String text = " ";

    public enum STATE {
        skillCheck,
        general
    }

    public STATE programState = STATE.general;
    public GUI(){
        handler = new Handler();
        new Window(800, 300, "DnD assistant!", this);

        this.addKeyListener(new KeyInput(){
            public void keyPressed(KeyEvent e){
                text+=e.getKeyChar();

                System.out.println(text); //Te falta hacer que el input que pongas sea un num y se pase
                

                //you might not need this is you are rendering constantly
            }
        });
        health = new HealthBar();
        input1 = new KeyInput();
        dice = new Dice();
    }



    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    public synchronized void stop() {
        try{
            thread.join();
            isRunning = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000/ amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(isRunning){
                render();
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();

        if(programState == STATE.general){
            health.tick();
        }


    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0, 800, 300);

        handler.render(g);

        if(programState == STATE.general){
            health.render(g);
            dice.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static int clamp( int var, int min, int max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else
            return var;

    }

    public static void main(String args[]){
        new GUI();
    }



}
