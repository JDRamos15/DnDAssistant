package com.gui.main;

import javax.swing.*;
import java.awt.*;

//Here we create the window that will hold the GUI of the XP bars

public class Window extends Canvas {
    private static final long serialVersionUID = 5858919276472914433L;

    public Window(int width, int height, String title, GUI gui) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(gui);
        frame.setVisible(true);
        gui.start();
    }
}
