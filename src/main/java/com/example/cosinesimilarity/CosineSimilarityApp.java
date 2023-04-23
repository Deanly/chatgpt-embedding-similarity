package com.example.cosinesimilarity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.math3.linear.RealVector;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CosineSimilarityApp {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar my-cosine-similarity-project-1.0-SNAPSHOT.jar <path_to_page_embeddings.json> <path_to_input_embedding.json>");
            return;
        }

        String pageEmbeddingsPath = args[0];
        String inputEmbeddingPath = args[1];

        System.out.println(pageEmbeddingsPath);
        System.out.println(inputEmbeddingPath);

        Gson gson = new Gson();
        Type mapType = new TypeToken<ChatGptResponse>() {}.getType();

        try {
            // Read page_embeddings.json and input_embedding.json files
            ChatGptResponse resPages = gson.fromJson(new FileReader(pageEmbeddingsPath), mapType);
            ChatGptResponse resInput = gson.fromJson(new FileReader(inputEmbeddingPath), mapType);

            // Assuming there is only one entry in input_embedding.json
            double[] inputEmbeddings = resInput.data.get(0).embedding;
            RealVector inputVector = CosineSimilarityCalculator.createRealVector(inputEmbeddings);

            CosineSimilarityCalculator calculator = new CosineSimilarityCalculator();

            for (EmbeddingData pageEmbeddingData : resPages.data) {
                RealVector pageVector = CosineSimilarityCalculator.createRealVector(pageEmbeddingData.embedding);
                double similarity = calculator.computeCosineSimilarity(inputVector, pageVector);

                System.out.println("Cosine similarity between input and page" + (pageEmbeddingData.index + 1) + ".txt: " + similarity);
            }

        } catch (IOException e) {
            System.out.println("Error reading input files: " + e.getMessage());
        }
    }

    static class ChatGptResponse {
        String object;
        List<EmbeddingData> data;
        String model;
    }

    static class EmbeddingData {
        String object;
        Long index;
        double[] embedding;
    }
}
