package pl.edu.pw.mini.awad.projektbadawczy;

import pl.edu.pw.mini.awad.projektbadawczy.MichalS.SGD;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;
import pl.edu.pw.mini.awad.projektbadawczy.dataloader.DataLoader;
import pl.edu.pw.mini.awad.projektbadawczy.dataloader.TrainingItem;
import pl.edu.pw.mini.awad.projektbadawczy.network.NeuralNetwork;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Demonstrator {
    public static void main(String[] args) {
        ArrayList<Integer> sizes = new ArrayList<>();
        sizes.add(784);
        sizes.add(100);
        sizes.add(10);
        NeuralNetwork network = new NeuralNetwork(sizes);
        try {
            InputStream in = pl.edu.pw.mini.awad.projektbadawczy.dataloader.Demonstrator.class.getResourceAsStream("/train-labels-idx1-ubyte.gz");
            ArrayList<Integer> labels = DataLoader.readLabels(in);
            System.out.println(labels.size());


            InputStream in1 = pl.edu.pw.mini.awad.projektbadawczy.dataloader.Demonstrator.class.getResourceAsStream("/train-images-idx3-ubyte.gz");
            ArrayList<Vector> vectors = DataLoader.readNumbers(in1);
            System.out.println(vectors.size());

        ArrayList<TrainingItem> trainingItems = new ArrayList<>();
        for (int i = 0; i<vectors.size(); i++){
           trainingItems.add(new TrainingItem(vectors.get(i), labels.get(i)));
        }
        SGD.SGD(network, trainingItems, 30, 10, 3.0, trainingItems);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
