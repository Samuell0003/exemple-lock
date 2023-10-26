package org.example;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int i =0;
        while (i<20) {
            Thread requestThread = new Thread(() -> {
                createRequestSaveItemPedido();
            });
            requestThread.start();
            i++;
        }
    }

    public static void createRequestSaveItemPedido() {

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String urlOtimista = "http://localhost:8080/account/sacar";
            String urlPessimista = "http://localhost:8000/account/sacar";

            HttpPost postRequest = new HttpPost( /*url*/ );
            String jsonRequest = "{" +
                    "\"numeroConta\":\""+1234+
                    "\",\"valor\":\""+100+"\"}";

            StringEntity entity = new StringEntity(jsonRequest);
            postRequest.setEntity(entity);
            postRequest.setHeader("Content-type", "application/json");

            CloseableHttpResponse response = httpClient.execute(postRequest);
            String responseBody = EntityUtils.toString(response.getEntity());

            System.out.println("Resposta: " + responseBody + "\nJson enviado: " + jsonRequest);

            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}