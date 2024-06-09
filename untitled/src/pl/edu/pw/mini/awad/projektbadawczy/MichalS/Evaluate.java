package pl.edu.pw.mini.awad.projektbadawczy.MichalS;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Matrix;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;
import pl.edu.pw.mini.awad.projektbadawczy.dataloader.TrainingItem;
import pl.edu.pw.mini.awad.projektbadawczy.network.NeuralNetwork;

import java.util.ArrayList;
import java.util.Objects;

public class Evaluate {
    public static Integer evaluate(NeuralNetwork network, ArrayList<TrainingItem> testData){
        int sum = 0;
        for (var testItem : testData) {
            ArrayList<Vector> input = new ArrayList<Vector>();
            input.add(testItem.input);
            Matrix myOutput = FeedForward.feedForward(network, new Matrix(input));
            if (Vector.argMax(Matrix.matrixToVector(myOutput)).doubleValue() == testItem.output.values.getFirst()) {
                sum += 1;
            }
        }
        return sum;
    }
}
