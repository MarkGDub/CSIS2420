package a03;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Chairs draws lines in the shape of a chair recursively
 * 
 * @author Princeton H-Tree Starter Code + Mark GW
 *
 */
public class Chairs {

    // plot a Chair, centered on (x, y) of the given side length
    public static void drawChair(double x, double y, double size) {

        // compute the coordinates of the 4 tips of the H
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;

        // draw the 3 line segments of the Chair
        StdDraw.line(x0, y0, x0, y1);    // left  vertical segment of the Chair
        StdDraw.line(x1, y0, x1, y);    // right half vertical segment of the Chair
        StdDraw.line(x0,  y, x1,  y);    // connect the two vertical segments of the Chair
    }

    // plot an order n Chair, centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;
        drawChair(x, y, size);

        // compute x- and y-coordinates of the 4 half-size Chairs
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;

        // recursively draw 4 half-size H-trees of order n-1
        draw(n-1, x0, y0, size/2);    // lower left Chair
        draw(n-1, x0, y1, size/2);    // upper left Chair
        draw(n-1, x1, y0, size/2);    // lower right Chair
    }

    public static void main(String[] args) {
//        int n = 1;
        int n = 3;

        double x = 0.5, y = 0.5;   // center of Chair
        double size = 0.5;         // side length of Chair
        draw(n, x, y, size);
    }
}
