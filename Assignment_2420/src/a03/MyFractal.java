package a03;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;

/**
 * MyFractal draws lines in the shape of a reflective arcs recursively
 * 
 * @author Princeton H-Tree Starter Code + Mark GW
 *
 */
public class MyFractal {

    /**
     *  plot a reflective arc, centered on (x, y) of the given side length
     *  
     * @param x - where the center of the arc is on the x axis
     * @param y - where the center of the arc is on the y axis
     * @param size - size of arcs
     * @param color - the color to draw the arcs in
     */
    public static void drawReflectiveArc(double x, double y, double size, Color color) {

        double y0 = y - size;
        double y1 = y + size;
        
        StdDraw.setPenColor(color);
        StdDraw.setPenRadius(0.005);
        StdDraw.arc(x, y0, size, 0, 180);
        StdDraw.arc(x, y1, size, 180, 0);
    }

    /**
     *  plot an order n reflective arc, centered on (x, y) of the given side length
     * @param n - amount to recursively call draw
     * @param x - where the center should be for the arcs on the x axis
     * @param y - where the center should be for the arcs on the y axis
     * @param size - size of the arcs
     * @param colors - array of colors to loop through as more arcs get drawn
     * @param i - what color to start on in the colors array
     */
    public static void draw(int n, double x, double y, double size, Color[] colors, int i) {
        if (n == 0) return;
        
        Color color = colors[i % colors.length];
        
        drawReflectiveArc(x, y, size, color);

        // compute x- and y-coordinates of the 4 half-size reflective arcs
        double x0 = x - size;
        double x1 = x + size;
        double y0 = y - size;
        double y1 = y + size;

        // recursively draw 4 half-size reflective arcs of order n-1
        draw(n-1, x0, y0, size/2, colors, i + 1);
        draw(n-1, x0, y1, size/2, colors, i + 1);
        draw(n-1, x1, y0, size/2, colors, i + 1);
        draw(n-1, x1, y1, size/2, colors, i + 1);
    }

    /* Test Client */
    public static void main(String[] args) {
        int n = 5;
        
        Color[] colors = {StdDraw.RED, StdDraw.ORANGE, StdDraw.CYAN, StdDraw.GREEN, StdDraw.BLUE, StdDraw.PINK};

        double x = 0.5, y = 0.5;
        double size = 0.25; 
        draw(n, x, y, size, colors, 0);
    }
}
