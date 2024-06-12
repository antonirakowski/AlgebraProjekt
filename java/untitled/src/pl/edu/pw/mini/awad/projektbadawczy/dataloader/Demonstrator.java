package pl.edu.pw.mini.awad.projektbadawczy.dataloader;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Demonstrator {

    public static void main(String[] args) {
        try {
            InputStream in = Demonstrator.class.getResourceAsStream("/train-labels-idx1-ubyte.gz");
            ArrayList<Integer> labels = DataLoader.readLabels(in);
            System.out.println(labels.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream in = Demonstrator.class.getResourceAsStream("/train-images-idx3-ubyte.gz");
            ArrayList<Vector> vectors = DataLoader.readNumbers(in);
            System.out.println(vectors.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
