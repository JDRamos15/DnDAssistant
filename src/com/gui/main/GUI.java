package com.gui.main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class GUI extends Canvas implements Runnable {
    private Thread thread;
    private boolean isRunning = false;
    private Handler handler;
    private HealthBar health;
    private KeyInput input1;
    private HealthManager manager;
    private Dice dice;

    public enum STATE {
        skillCheck, general, inputs
    }

    public STATE programState = STATE.inputs;

    public GUI() {
        handler = new Handler();
        new Window(800, 300, "DnD assistant!", this);

        health = new HealthBar();
        input1 = new KeyInput(this, handler);
        manager = new HealthManager();
        dice = new Dice();

        this.addMouseListener(dice);
        this.addMouseListener(manager);
        this.addKeyListener(input1);

        this.addKeyListener(manager);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            isRunning = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (isRunning) {
                render();
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();

        if (programState == STATE.general) {
            health.tick();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 300);

        handler.render(g);

        if (programState == STATE.general) {
            health.render(g);
            dice.render(g);
            manager.render(g);
        }
        if (programState == STATE.inputs) {
            input1.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;
    }

    public static void main(String args[]) {
        new GUI();
    }
}
