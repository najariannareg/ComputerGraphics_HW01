package library;

import java.awt.image.BufferedImage;

public class ScanConversion {

    public static void bresenhamLine(int x1, int y1, int x2, int y2, BufferedImage img, int[] pixel) {
        int xStart = x1, yStart = y1, xEnd = x2, yEnd = y2;
        if (x1 > x2) {
            xStart = x2;
            yStart = y2;
            xEnd = x1;
            yEnd = y1;
        }

        int sign = yEnd - yStart < 0 ? -1 : 1;

        int dx = xEnd - xStart;
        int dy = sign * (yEnd - yStart);

        if (dx > dy) {
            int d = 2 * dy - dx;
            int dE = 2 * dy;
            int dNE = 2 * (dy - dx);

            int i = xStart, j = yStart;
            img.getRaster().setPixel(i, j, pixel);

            while (i != xEnd) {
                if (d <= 0) {
                    d += dE;
                } else {
                    d += dNE;
                    j += sign;
                }
                i++;
                img.getRaster().setPixel(i, j, pixel);
            }
        } else {
            int d = dy - 2 * dx;
            int dN = 2 * (-dx);
            int dNE = 2 * (dy - dx);

            int i = yStart, j = xStart;
            img.getRaster().setPixel(j, i, pixel);

            while (i != yEnd) {
                if (d > 0) {
                    d += dN;
                } else {
                    d += dNE;
                    j++;
                }
                i += sign;
                img.getRaster().setPixel(j, i, pixel);
            }
        }
    }
}
