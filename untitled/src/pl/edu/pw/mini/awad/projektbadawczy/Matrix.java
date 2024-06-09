package pl.edu.pw.mini.awad.projektbadawczy;

import java.util.ArrayList;

public class Matrix {

    public ArrayList<Vector> values;
    public Integer rows;
    public Integer columns;

    public Matrix(ArrayList<Vector> values) {
        this.values = values;
        this.rows = values.size();
        this.columns = values.get(0).length;
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        if (m1.rows != m2.rows || m1.columns != m2.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        ArrayList<Vector> result = new ArrayList<>();
        for (int i = 0; i < m1.rows; i++) {
            result.add(Vector.add(m1.values.get(i), m2.values.get(i)));
        }
        return new Matrix(result);
    }

    public static Matrix subtract(Matrix m1, Matrix m2) {
        if (m1.rows != m2.rows || m1.columns != m2.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        ArrayList<Vector> result = new ArrayList<>();
        for (int i = 0; i < m1.rows; i++) {
            result.add(Vector.subtract(m1.values.get(i), m2.values.get(i)));
        }
        return new Matrix(result);
    }

    public static Matrix multiply(Matrix m1, Matrix m2) {
        if (m1.columns != m2.rows) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }
        ArrayList<Vector> result = new ArrayList<>();
        for (int i = 0; i < m1.rows; i++) {
            ArrayList<Double> row = new ArrayList<>();
            for (int j = 0; j < m2.columns; j++) {
                Double sum = 0.0;
                for (int k = 0; k < m1.columns; k++) {
                    sum += m1.values.get(i).values.get(k) * m2.values.get(k).values.get(j);
                }
                row.add(sum);
            }
            result.add(new Vector(row));
        }
        return new Matrix(result);
    }
}
