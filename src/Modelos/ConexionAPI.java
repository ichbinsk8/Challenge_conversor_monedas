package Modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;


public class ConexionAPI {

    public Filtro crearConexion(String moneda, double valor, String monedaConverir) {
        // Validar que el valor sea positivo
        if (valor <= 0) {
            System.err.println("El valor de conversión debe ser mayor que cero.");
            return null;
        }
        String apiKey = "0ce27fd4e7db6d6d544fbe24";

        // Construir la URI con la moneda base y destino
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/" + moneda + "/" + monedaConverir + "/" + valor);

        // Crear el cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Crear la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        //System.out.println("URL de la API: " + direccion);

        try {
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Comprobar si la respuesta fue exitosa
            Filtro filtro = new Gson().fromJson(response.body(), Filtro.class);

            // Mostrar la tasa de conversión y el resultado
            System.out.println("Tasa de conversión de " + moneda + " a " + monedaConverir + ": " + filtro.conversion_rate());
            System.out.println("Resultado de la conversión: " + filtro.conversion_result());

            return filtro;
        } catch (IOException | InterruptedException e) {
            // Manejar las excepciones adecuadamente
            System.err.println("Error al realizar la conexión: " + e.getMessage());
        }

        return null;  // Retornar null si ocurre un error
    }
}




