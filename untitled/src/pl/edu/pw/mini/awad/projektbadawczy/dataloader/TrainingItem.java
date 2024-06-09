package pl.edu.pw.mini.awad.projektbadawczy.dataloader;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;

public class TrainingItem {
    public Vector input;
    public int output;

    public TrainingItem(Vector input, int output) {
        this.input = input;
        this.output = output;
    }
}
