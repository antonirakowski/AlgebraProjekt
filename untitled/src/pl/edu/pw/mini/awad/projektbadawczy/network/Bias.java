package pl.edu.pw.mini.awad.projektbadawczy.network;
import java.util.*;

public class Bias {
    int size;
    ArrayList<Double> values;

    public Bias(int size) {
        this.size = size;
        ArrayList<Double> values = new ArrayList<Double>();
        Random random = new Random();
        for (int j = 0; j < size; j++ ) {
            values.add(random.nextDouble());
        }
        this.values = values;
    }
}
