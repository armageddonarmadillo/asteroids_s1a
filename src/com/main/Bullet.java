package com.main;

import java.awt.*;

public class Bullet extends VPoly{
    float distance, max_distance = 999;
    boolean active = true;

    Bullet(float x, float y, float a){
        super((int)x, (int)y);
        poly = new Polygon();
        poly.addPoint(1,1);
        poly.addPoint(-1,1);
        poly.addPoint(-1,-1);
        poly.addPoint(-1,-1);
        draw_poly = new Polygon();
        draw_poly.addPoint(1,1);
        draw_poly.addPoint(-1,1);
        draw_poly.addPoint(-1,-1);
        draw_poly.addPoint(-1,-1);

        this.a = a;
        this.s = 3f;
        this.d = 1;
    }

    void update(){
        super.update();
        distance += Math.abs(xs) + Math.abs(ys);
        active = !(distance >= max_distance);
    }
}
