package pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures;

import java.util.ArrayList;

public class Matrix {

    public ArrayList<Vector> values;
    public int rows;
    public int columns;

    public Matrix(ArrayList<Vector> values) {
        this.values = values;
        this.rows = values.size();
        this.columns = values.get(0).length;
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        if (m1.rows != m2.rows || m1.columns != m2.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        System.out.println("m1.rows: " + m1.rows);
        System.out.println("m1.columns: " + m1.columns);
        System.out.println("m2.rows: " + m2.rows);
        System.out.println("m2.columns: " + m2.columns);
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
    public static Matrix exp(Matrix m) {
        ArrayList<Vector> result = new ArrayList<>();
        for (int i = 0; i < m.rows; i++) {
            result.add(Vector.exp(m.values.get(i)));
        }
        return new Matrix(result);
    }
    public static Matrix multiplyScalar(Matrix m, Double a) {
        ArrayList<Vector> result = new ArrayList<>();
        for (int i = 0; i < m.rows; i++) {
            result.add(Vector.multiply(a, m.values.get(i)));
        }
        return new Matrix(result);
    }
    public static Matrix divideScalar(Matrix m, Double a) {
        ArrayList<Vector> result = new ArrayList<>();
        for (int i = 0; i < m.rows; i++) {
            result.add(Vector.divideScalar(a, m.values.get(i)));
        }
        return new Matrix(result);
    }
    public static Matrix addScalar(Matrix m, Double a) {
        ArrayList<Vector> result = new ArrayList<>();
        for (int i = 0; i < m.rows; i++) {
            result.add(Vector.addScalar(a, m.values.get(i)));
        }
        return new Matrix(result);
    }

    public static Matrix substractScalarLeft(Double a, Matrix m) {
        ArrayList<Vector> result = new ArrayList<>();
        for (int i = 0; i < m.rows; i++) {
            result.add(Vector.substractScalarLeft(a, m.values.get(i)));
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

    public static Matrix dot(Double a, Matrix m) {
        ArrayList<Vector> result = new ArrayList<>();
        for (int i = 0; i < m.rows; i++) {
            result.add(Vector.multiply(a, m.values.get(i)));
        }
        return new Matrix(result);
    }

    public static Matrix addVector(Matrix matrix, Vector v) {
        Matrix m = Matrix.transpose(matrix);
        ArrayList<Vector> result = new ArrayList<>();
        int vectorIndex = 0;
        for (int i = 0; i < m.rows; i++) {
            ArrayList<Double> row = new ArrayList<>();
            for (int j = 0; j < m.columns; j++) {
                Double value = m.values.get(i).values.get(j);
                value += v.values.get(vectorIndex);
                row.add(value);
                vectorIndex = (vectorIndex + 1) % v.length;
            }
            result.add(new Vector(row));
        }
        return Matrix.transpose(new Matrix(result));
    }

    public static Matrix transpose (Matrix m) {
        ArrayList<Vector> result = new ArrayList<>();
        for (int i = 0; i < m.columns; i++) {
            ArrayList<Double> row = new ArrayList<>();
            for (int j = 0; j < m.rows; j++) {
                row.add(m.values.get(j).values.get(i));
            }
            result.add(new Vector(row));
        }
        return new Matrix(result);
    }

    @Override
    public String toString() {
        String s = "";
        for (Vector v : values) {
            s += v.toString() + "\n";
        }
        return s;

    }

    public static Vector matrixToVector(Matrix m) {
        return m.values.get(0);
    }
}
