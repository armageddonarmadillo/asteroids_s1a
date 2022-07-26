package com.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel implements KeyListener, MouseListener {
    public static final int gw = 900, gh = 600;
    public static Random r = new Random();
    ArrayList<Line> lines = new ArrayList<>();
    ArrayList<VPoly> polys = new ArrayList<>();
    static ArrayList<Bullet> bullets = new ArrayList<>();
    int x = 0, y = 0;
    Ship ship;

    Game(){
        init();
    }

    void init(){
        ship = new Ship(gw / 2, gh / 2);
        //make_lines();
        //make_polys();
    }

    void update() {
        for(Line l : lines) l.update();
        for(VPoly v : polys) v.update();
        for(Bullet b : bullets) b.update();
        ship.update();
        house_keeping();
    }

    void house_keeping(){
        for (Bullet b : bullets) if(!b.active) { bullets.remove(b); break; }
    }

    public void paint(Graphics g){
        update();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, gw, gh);
        for(Line l : lines) l.draw(g);
        for(VPoly v : polys) v.draw(g);
        for(Bullet b : bullets) b.draw(g);
        ship.draw(g);
        repaint();
    }

    void make_lines(){
        for(int i = 0; i < 250; i++) lines.add(new Line(0 , 0, gw, gh, r.nextInt(255), r.nextInt(255), r.nextInt(255)));
    }

    void make_polys(){
        for(int i = 0; i < 250; i++) polys.add(new VPoly(x + (i * 60), y + (x + i * 60 >= 900 ? i * 60 : 0)));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D) ship.r = .009f;
        if(e.getKeyCode() == KeyEvent.VK_A) ship.r = -.009f;
        if(e.getKeyCode() == KeyEvent.VK_W) ship.d = 1;
        if(e.getKeyCode() == KeyEvent.VK_S) ship.d = -1;
        if(e.getKeyCode() == KeyEvent.VK_SPACE) ship.firing = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D) ship.r = 0;
        if(e.getKeyCode() == KeyEvent.VK_A) ship.r = 0;
        if(e.getKeyCode() == KeyEvent.VK_W) ship.d = 0;
        if(e.getKeyCode() == KeyEvent.VK_S) ship.d = 0;
        if(e.getKeyCode() == KeyEvent.VK_SPACE) ship.firing = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
