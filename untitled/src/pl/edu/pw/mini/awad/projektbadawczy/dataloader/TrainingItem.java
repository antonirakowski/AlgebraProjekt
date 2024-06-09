package pl.edu.pw.mini.awad.projektbadawczy.dataloader;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;

public class TrainingItem {
    public Vector input;
    public Vector output;

    public TrainingItem(Vector input, Vector output) {
        this.input = input;
        this.output = output;
    }
}
