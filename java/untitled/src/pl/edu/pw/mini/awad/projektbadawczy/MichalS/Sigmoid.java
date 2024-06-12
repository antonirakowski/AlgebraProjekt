package pl.edu.pw.mini.awad.projektbadawczy.MichalS;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Matrix;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;

public class Sigmoid {
    public static Vector sigmoidVector(Vector v) {
        return Vector.divideScalar(1.0,Vector.addScalar(1.0,Vector.exp(Vector.multiply(-1.0,v))));
    }

    public static Vector sigmoidDerivativeVector(Vector v) {
        return Vector.multiplyVector( Sigmoid.sigmoidVector(v),Vector.substractScalarLeft(1.0, Sigmoid.sigmoidVector(v)));
    }
    public static double sigmoid(double d) {
        return 1.0 / (1.0 + Math.exp(-d));
    }

    public static double sigmoidDerivative(double d) {
        return sigmoid(d) * (1-sigmoid(d));
    }
    public static Matrix sigmoidMatrix(Matrix m) {
        return Matrix.divideScalar(Matrix.addScalar(Matrix.exp(Matrix.multiplyScalar(m,-1.0)),1.0),1.0);
    }
    public static Matrix sigmoidDerivativeMatrix(Matrix m) {
        return Matrix.multiply(Sigmoid.sigmoidMatrix(m),Matrix.substractScalarLeft(1.0,Sigmoid.sigmoidMatrix(m)));
    }
}

