package pl.edu.pw.mini.awad.projektbadawczy.MichalS;

import pl.edu.pw.mini.awad.projektbadawczy.dataloader.TrainingItem;
import pl.edu.pw.mini.awad.projektbadawczy.network.NeuralNetwork;

import java.awt.geom.NoninvertibleTransformException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class SGD {
    public static void SGD(NeuralNetwork network, ArrayList<TrainingItem> TrainingData, int epochs , int miniBatchSize, double eta, ArrayList<TrainingItem> TestData ) {
        int n = TrainingData.size();
        for (int j = 0; j < epochs; j++) {
            Collections.shuffle(TrainingData);
            ArrayList<ArrayList<TrainingItem>> miniBatches = new ArrayList<>();
            for (int k = 0; k < n; k += miniBatchSize) {
                miniBatches.add(new ArrayList<>(TrainingData.subList(k, k + miniBatchSize)));
            }
            for (ArrayList<TrainingItem> miniBatch : miniBatches) {
                network.updateMiniBatch(miniBatch, eta);
            }
            if (TestData != null) {
                System.out.println("Epoch " + j + ": " + Evaluate.evaluate(network, TestData).toString() + " / " + TestData.size());
            } else {
                System.out.println("Epoch " + j + " complete");
            }
        }
    }
}
