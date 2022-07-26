package com.main;

import java.awt.*;

public class Line {
    int x, y, x2, y2;
    int r = 0, g = 0, b = 0;
    int speed = Game.r.nextInt(250) + 1;

    Line(int x, int y, int x2, int y2){
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    Line(int x, int y, int x2, int y2, int r, int g, int b){
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    void update(){
        speed = (y > 10000 || y2 > 10000) ? -speed : speed;
        y += speed;
        x += speed / 10;
        y2 -= speed;
        x2 -= speed / 10;
    }

    void draw(Graphics g){
        g.setColor(new Color(r, this.g, b));
        g.drawLine(x, y, x2, y2);
    }
}
