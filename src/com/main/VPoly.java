package com.main;

import java.awt.*;

public class VPoly {
    float x, y, s, a, d, r, xs, ys;
    // x, y -> coordinates
    // s -> speed, a -> angle, d -> direction, r -> rotation, t -> turn speed
    Polygon poly, draw_poly;

    VPoly(int x, int y){
        this.x = x;
        this.y = y;
    }

    void update(){
        a += r;
        xs = (float)Math.cos(a) * s;
        ys = (float)Math.sin(a) * s;
        x +=  xs * d;
        y +=  ys * d;
        for(int i = 0; i < poly.npoints; i++){
            int new_x = (int)Math.round(poly.xpoints[i] * Math.cos(a) - poly.ypoints[i] * Math.sin(a));
            int new_y = (int)Math.round(poly.xpoints[i] * Math.sin(a) + poly.ypoints[i] * Math.cos(a));
            draw_poly.xpoints[i] = new_x;
            draw_poly.ypoints[i] = new_y;
        }
        draw_poly.translate((int)x, (int)y);
    }

    void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.drawPolygon(draw_poly);
    }
}
