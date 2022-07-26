package com.main;

import java.awt.*;

public class Ship extends VPoly{
    boolean firing = false;
    int counter = 0, delay;

    Ship(int x, int y){
        super(x, y);
        poly = new Polygon();
        poly.addPoint(40, 0);
        poly.addPoint(-10, 15);
        poly.addPoint(0, 30);
        poly.addPoint(15, 40);
        poly.addPoint(0,40);
        poly.addPoint(-30,10);
        poly.addPoint(-36,5);
        poly.addPoint(-40,0);
        poly.addPoint(-36,-5);
        poly.addPoint(-30, -10);
        poly.addPoint(0, -40);
        poly.addPoint(15, -40);
        poly.addPoint(0, -30);
        poly.addPoint(-10, -15);
        draw_poly = new Polygon();
        draw_poly.addPoint(40, 0);
        draw_poly.addPoint(-10, 15);
        draw_poly.addPoint(0, 30);
        draw_poly.addPoint(15, 40);
        draw_poly.addPoint(0,40);
        draw_poly.addPoint(-30,10);
        draw_poly.addPoint(-36,5);
        draw_poly.addPoint(-40,0);
        draw_poly.addPoint(-36,-5);
        draw_poly.addPoint(-30, -10);
        draw_poly.addPoint(0, -40);
        draw_poly.addPoint(15, -40);
        draw_poly.addPoint(0, -30);
        draw_poly.addPoint(-10, -15);
        s = 1.5f;
        delay = 60;
    }

    void update(){
        super.update();
        if(firing){
            if(counter++ >= delay) { fire(); counter = 0; }
        } else counter = delay;
    }

    void fire(){
        Game.bullets.add(new Bullet(draw_poly.xpoints[0], draw_poly.ypoints[0], a));
        Game.bullets.add(new Bullet(draw_poly.xpoints[3], draw_poly.ypoints[3], a));
        Game.bullets.add(new Bullet(draw_poly.xpoints[11], draw_poly.ypoints[11], a));
    }

}
