package com.example.cosinesimilarity;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class CosineSimilarityCalculator {

    /**
     * Create a RealVector from a double array.
     *
     * @param array the input double array
     * @return a RealVector representing the input array
     */
    public static RealVector createRealVector(double[] array) {
        return new ArrayRealVector(array);
    }

    /**
     * Compute the cosine similarity between two RealVectors.
     *
     * @param vector1 the first RealVector
     * @param vector2 the second RealVector
     * @return the cosine similarity between the two input RealVectors
     */
    public double computeCosineSimilarity(RealVector vector1, RealVector vector2) {
        double dotProduct = vector1.dotProduct(vector2);
        double normA = vector1.getNorm();
        double normB = vector2.getNorm();

        if (normA == 0 || normB == 0) {
            return 0;
        } else {
            return dotProduct / (normA * normB);
        }
    }

}
