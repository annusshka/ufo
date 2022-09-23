package com.company;

import java.awt.*;
import java.awt.geom.Path2D;

public class Star {

    private double x;
    private double y;
    private double innerRadius;
    private double outerRadius;
    private int numRays;

    public Star(double x, double y, double innerRadius, double outerRadius, int numRays) {
        this.x = x;
        this.y = y;
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
        this.numRays = numRays;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX(Star star) {
        return star.x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY(Star star) {
        return star.y;
    }

    public void setInnerRadius(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    public double getInnerRadius(Star star) {
        return star.innerRadius;
    }

    public void setOuterRadius(double outerRadius) {
        this.outerRadius = outerRadius;
    }

    public double getOuterRadius(Star star) {
        return star.outerRadius;
    }

    public void setNumRays(int numRays) {
        this.numRays = numRays;
    }

    public int getNumRays(Star star) {
        return star.numRays;
    }

    private static Shape drawStar(double x, double y, double innerRadius, double outerRadius, int numRays) {
        Path2D p = new Path2D.Double();
        double deltaAngleR = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++) {
            double angleR = i * deltaAngleR;
            double relX = Math.cos(angleR);
            double relY = Math.sin(angleR);
            if ((i & 1) == 0) {
                relX *= outerRadius;
                relY *= outerRadius;
            } else {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0) {
                p.moveTo(x + relX, y + relY);
            } else {
                p.lineTo(x + relX, y + relY);
            }
        }
        p.closePath();
        return p;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        g.setColor(Color.ORANGE);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//сглаживание фигур

        g.fill(drawStar(this.x, this.y, this.innerRadius, this.outerRadius, this.numRays));
    }
}
