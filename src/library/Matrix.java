package library;

public class Matrix {

    public static float[][] matrixMultiplication(float[][] m1, float[][] m2) {
        if(m1[0].length != m2.length) throw new AssertionError("matrix size mismatch");
        int row = m1.length;
        int col = m2[0].length;
        float[][] m = new float[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                float dot = 0;
                for(int k=0; k<m2.length; k++){
                    dot += m1[i][k] * m2[k][j];
                }
                m[i][j] = dot;
            }
        }
        return m;
    }

    public static float[][] matrixTranspose(float[][] m){
        int row = m.length;
        int col = m[0].length;
        float[][] t = new float[col][row];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                t[j][i] = m[i][j];
            }
        }
        return t;
    }


    public static void printMatrix(float[][] m){
        System.out.print("{");
        for(int i=0; i<m.length; i++){
            System.out.print("{");
            for(int j=0; j<m[i].length; j++){
                System.out.print(m[i][j]);
                System.out.print(j<m[i].length-1? ", ": "}");
            }
            System.out.println(i<m.length-1? ",": "}");
        }
        System.out.println();
    }

}
