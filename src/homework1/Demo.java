package homework1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Demo {

    public static BufferedImage solidSetRaster(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();

        int[] pixel = {0,0,0}; //RGB

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.getRaster().setPixel(x, y, pixel);
            }
        }

        return img;
    }

    public static void main(String... args) {
        Frame w = new Frame("homework1");  //window
        final int imageWidth = 980;
        final int imageHeight = 1050;

        w.setSize(imageWidth,imageHeight);
        w.setLocation(950,0);
        w.setVisible(true);

        Graphics g = w.getGraphics();

        BufferedImage img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        solidSetRaster(img);
        g.drawImage(img, 0, 0, (img1, infoflags, x, y, width, height) -> false);  //draw the image. You can think of this as the display method.

        Polygon polygon = new Polygon();

        w.addMouseListener(new MouseAdapter() {
            boolean clear = true;
            @Override
            public void mouseClicked(MouseEvent e) {
                if(clear){
                    polygon.clearPoints();
                }
                if(e.getButton() == MouseEvent.BUTTON1) {
                    polygon.addPoint(new Point(e.getX(), e.getY()));
                    solidSetRaster(img);
                    polygon.drawOpen(img);
                    clear = false;
                }
                else if(e.getButton() == MouseEvent.BUTTON3){
                    solidSetRaster(img);
                    polygon.drawClosed(img);
                    clear = true;
                }
                g.drawImage(img, 0, 0, (img1, infoflags, x, y, width, height) -> false);
            }
        });

        w.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_R){
                    polygon.rotate(-5);
                }
                if(e.getKeyCode() == KeyEvent.VK_T){
                    polygon.rotate(5);
                }
                if(e.getKeyCode() == KeyEvent.VK_F){
                    polygon.scale(1.1f, 1.1f);
                }
                if(e.getKeyCode() == KeyEvent.VK_G){
                    polygon.scale(0.9f, 0.9f);
                }
                if(e.getKeyCode() == KeyEvent.VK_W){
                    polygon.translate(0, -5);
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    polygon.translate(0, 5);
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    polygon.translate(-5, 0);
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    polygon.translate(5, 0);
                }
                solidSetRaster(img);
                polygon.drawClosed(img);
                g.drawImage(img, 0, 0, (img1, infoflags, x, y, width, height) -> false);
            }

        });

        w.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                w.dispose();
                g.dispose();
                System.exit(0);
            }
        });
    }
}


