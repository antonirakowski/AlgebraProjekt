package pl.edu.pw.mini.awad.projektbadawczy.MichalS;

import java.awt.geom.NoninvertibleTransformException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class SGD {
    public static void SGD(ArrayList<Objects> TrainingData, int epochs , int miniBatchSize, double eta, ArrayList<Objects> TestData ) {
        int n = TrainingData.size();
        for (int j = 0; j < epochs; j++) {
            Collections.shuffle(TrainingData);
            ArrayList<ArrayList<Objects>> miniBatches = new ArrayList<>();
            for (int k = 0; k < n; k += miniBatchSize) {
                miniBatches.add(new ArrayList<>(TrainingData.subList(k, k + miniBatchSize)));
            }
            for (ArrayList<Objects> miniBatch : miniBatches) {
                UpdateMiniBatch.updateMiniBatch(miniBatch, eta);
            }
            if (TestData != null) {
                System.out.println("Epoch " + j + ": " + Evaluate.evaluate(TestData) + " / " + TestData.size());
            } else {
                System.out.println("Epoch " + j + " complete");
            }
        }
    }
}
