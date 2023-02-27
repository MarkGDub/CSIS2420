package a03;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Triangles draws lines in the shape of a triangle recursively
 * 
 * @author Princeton H-Tree Starter Code + Mark GW
 *
 */
public class Triangles {

    // plot a triangle, centered on (x, y) of the given side length
    public static void drawTriangle(double x, double y, double size) {

        // compute the coordinates of the 4 tips of the triangle
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;

        // draw the 3 line segments of the triangle
        StdDraw.line(x0, y0, x0, y1);    // left  vertical segment of the triangle
        StdDraw.line(x1, y0, x0, y1);    // top segment of the H
        StdDraw.line(x0,  y0, x1,  y0);    // connect the bottom segment of the triangle
    }

    // plot an order n triangle, centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;
        drawTriangle(x, y, size);

        // compute x- and y-coordinates of the 4 half-size triangles
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;

        // recursively draw 4 half-size triangles of order n-1
        draw(n-1, x0, y0, size/2);    // lower left  H-tree
        draw(n-1, x0, y1, size/2);    // upper left  H-tree
        draw(n-1, x1, y0, size/2);    // lower right H-tree
    }

    // reads an integer command-line argument n and plots an order n triangle
    public static void main(String[] args) {
//        int n = 1;
        int n = 3;

        double x = 0.5, y = 0.5;   // center of triangle
        double size = 0.5;         // side length of triangle
        draw(n, x, y, size);
    }
}