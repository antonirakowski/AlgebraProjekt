package pl.edu.pw.mini.awad.projektbadawczy.MichalS;

import pl.edu.pw.mini.awad.projektbadawczy.Vector;

import java.util.ArrayList;
import java.util.Arrays;

public class Demonstrator {
    public static void main(String[] args) {
        Vector one = new Vector(new ArrayList<>(Arrays.asList(2.0,3.0,4.0)));
        Vector two = new Vector(new ArrayList<>(Arrays.asList(5.0,5.0,6.0)));
        System.out.println(Sigmoid.sigmoid(5));

    }
}
