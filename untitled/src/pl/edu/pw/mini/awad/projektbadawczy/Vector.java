package pl.edu.pw.mini.awad.projektbadawczy;

import java.util.ArrayList;
import java.lang.Integer;

public class Vector {
    public ArrayList<Double> values;
    public Integer length;

    public Vector(ArrayList<Double> values) {
        this.values = values;
        this.length = values.size();
    }

    public static Vector add(Vector v1, Vector v2) {
        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Vectors must have the same length");
        }
        ArrayList<Double> result = new ArrayList<>();
        for (int i = 0; i < v1.length; i++) {
            result.add(v1.values.get(i) + v2.values.get(i));
        }
        return new Vector(result);
    }
}
