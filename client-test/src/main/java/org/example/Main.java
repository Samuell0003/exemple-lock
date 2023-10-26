package org.example;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String servidorURLpessimista = "http://localhost:8000/account/sacar"; // pessimista
        String servidorURLotimista = "http://localhost:8080/account/sacar"; // otimista
        int numeroContas = 1000;

        ExecutorService executor = Executors.newFixedThreadPool(numeroContas);

        for (int i = 1; i <= numeroContas; i++) {
            final int contaIndex = i;
            executor.execute(() -> {

                double valor = 100.0;

                try {
                    URL url = new URL( servidorURLpessimista );
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setDoOutput(true);

                    String requestBody = "{\"numeroConta\":\"" + "1234" + "\", \"valor\":" + valor + "}";

                    try (DataOutputStream out = new DataOutputStream(connection.getOutputStream())) {
                        out.write(requestBody.getBytes("UTF-8"));
                    }

                    int responseCode = connection.getResponseCode();
                    System.out.println("Requisição para enviada. Código de resposta: " + responseCode);

                    connection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}