package pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures;

import java.util.ArrayList;
import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        Vector vector1 = new Vector(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0)));
        Matrix matrix1 = new Matrix(new ArrayList<>(Arrays.asList(vector1, vector1, vector1)));
        System.out.println(matrix1);
    }
}
