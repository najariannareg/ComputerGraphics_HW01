package library;


public class Transformation2D {

    public static float[][] getTranslationMatrix(int tx, int ty){
        return new float[][]{
                {1, 0, tx},
                {0, 1, ty},
                {0, 0, 1}
        };
    }

    public static float[][] getRotationMatrix(float angle){
        return new float[][] {
                {(float)Math.cos(Math.toRadians(angle)), (float)((-1)*Math.sin(Math.toRadians(angle))), 0},
                {(float)Math.sin(Math.toRadians(angle)), (float)Math.cos(Math.toRadians(angle)), 0},
                {0, 0, 1}
        };
    }

    public static float[][] getScalingMatrix(float sx, float sy){
        return new float[][] {
                {sx, 0, 0},
                {0, sy, 0},
                {0, 0, 1}
        };
    }


    public static float[][] getRotationMatrixT(int cx, int cy, float angle) {
        float[][] translationMatrix1 = getTranslationMatrix(-cx, -cy);
        float[][] rotationMatrix = getRotationMatrix(angle);
        float[][] translationMatrix2 = getTranslationMatrix(cx, cy);

        float[][] t1 = Matrix.matrixMultiplication(translationMatrix2, rotationMatrix);
        float[][] T = Matrix.matrixMultiplication(t1, translationMatrix1);

        return T;
    }

    public static float[][] getScalingMatrixT(int cx, int cy, float sx, float sy) {
        float[][] translationMatrix1 = getTranslationMatrix(-cx, -cy);
        float[][] scalingMatrix = getScalingMatrix(sx, sy);
        float[][] translationMatrix2 = getTranslationMatrix(cx, cy);

        float[][] t1 = Matrix.matrixMultiplication(translationMatrix2, scalingMatrix);
        float[][] T = Matrix.matrixMultiplication(t1, translationMatrix1);

        return T;
    }




//    public static void main(String[] args){
//        float[][] m1 = getTranslationMatrix(-17, -23);
//        float[][] m2 = getRotationMatrix(30);
//        float[][] m3 = getTranslationMatrix(17, 23);
//        float[][] t1 = matrixMultiplication(m1, m2);
//        float[][] T = matrixMultiplication(t1, m3);
//
//        float[][] p1 = {{10}, {10}, {10}};
//        float[][] p2 = matrixMultiplication(m1, p1);
//
//        printMatrix(m1);
//        printMatrix(m2);
//        printMatrix(m3);
//        printMatrix(t1);
//        printMatrix(T);
//
//        printMatrix(p2);
//
//        float[][] m1t = matrixTranspose(m1);
//        printMatrix(m1);
//        printMatrix(m1t);
//    }

}
