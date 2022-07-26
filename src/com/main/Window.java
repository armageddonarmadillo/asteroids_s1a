package com.main;

import javax.swing.*;

public class Window extends JFrame {
    Window(Game g){
        this.add(g);
        this.pack();
        this.setVisible(true);
        this.setSize(900, 600);
        this.setTitle("Asteroids");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(g);
        addMouseListener(g);
    }
}
