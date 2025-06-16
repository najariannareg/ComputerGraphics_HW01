package homework1;

import library.Transformation2D;

import library.Matrix;

public class Point {

    private int[][] point = new int[3][1];


    public Point(int x, int y){
        setI(0, x);
        setI(1, y);
        setI(2, 1);
    }


    public int getX() {
        return getI(0);
    }

    public void setX(int x) {
        setI(0, x);
    }

    public int getY() {
        return getI(1);
    }

    public void setY(int y) {
        setI(1, y);
    }

    public int getW() {
        return getI(2);
    }

    private void setW(int w){
        setI(2, w);
    }

    private int getI(int i){
        return point[i][0];
    }

    private void setI(int i, int num){
        point[i][0] = num;
    }


    public void translate(int tx, int ty) {
        float[][] p1 = {{getI(0)}, {getI(1)}, {getI(2)}};
        float[][] t = Transformation2D.getTranslationMatrix(tx, ty);
        float[][] p2 = Matrix.matrixMultiplication(t, p1);
        for (int i = 0; i < 3; i++) {
            setI(i, Math.round(p2[i][0]));
        }
    }

    public void rotate(int cx, int cy, float angle) {
        float[][] p1 = {{getI(0)}, {getI(1)}, {getI(2)}};
        float[][] t = Transformation2D.getRotationMatrixT(cx, cy, angle);
        float[][] p2 = Matrix.matrixMultiplication(t, p1);
        for (int i = 0; i < 3; i++) {
            setI(i, Math.round(p2[i][0]));
        }
    }

    public void scale(int cx, int cy, float sx, float sy) {
        float[][] p1 = {{getI(0)}, {getI(1)}, {getI(2)}};
        float[][] t = Transformation2D.getScalingMatrixT(cx, cy, sx, sy);
        float[][] p2 = Matrix.matrixMultiplication(t, p1);
        for (int i = 0; i < 3; i++) {
            setI(i, Math.round(p2[i][0]));
        }
    }

    public void printPoint(){
        System.out.print("{" + getX() + ", " + getY() + "}");
    }
}
