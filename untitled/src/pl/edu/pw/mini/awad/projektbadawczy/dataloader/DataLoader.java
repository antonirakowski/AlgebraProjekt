package pl.edu.pw.mini.awad.projektbadawczy.dataloader;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

public class DataLoader {

    public static ArrayList<Vector> readNumbers(InputStream in) throws IOException {
        InputStream gzipStream = new GZIPInputStream(in);
        DataInputStream dataStream = new DataInputStream(gzipStream);

        int magicNumber = dataStream.readInt();
        int numberOfImages = dataStream.readInt();
        int numberOfRows = dataStream.readInt();
        int numberOfColumns = dataStream.readInt();

        ArrayList<Vector> imageVectors = new ArrayList<>();

        for (int i = 0; i < numberOfImages; i++) {
            ArrayList<Double> imagePixels = new ArrayList<>();
            for (int r = 0; r < numberOfRows; r++) {
                for (int c = 0; c < numberOfColumns; c++) {
                    imagePixels.add((double) dataStream.readUnsignedByte());
                }
            }
            imageVectors.add(new Vector(imagePixels));
        }

        return imageVectors;
    }

    public static ArrayList<Integer> readLabels(InputStream in) throws IOException {
        InputStream gzipStream = new GZIPInputStream(in);
        DataInputStream dataStream = new DataInputStream(gzipStream);

        int magicNumber = dataStream.readInt();
        int numberOfLabels = dataStream.readInt();

        ArrayList<Integer> labels = new ArrayList<>();

        for (int i = 0; i < numberOfLabels; i++) {
            labels.add((int) dataStream.readUnsignedByte());
        }

        return labels;
    }
}
