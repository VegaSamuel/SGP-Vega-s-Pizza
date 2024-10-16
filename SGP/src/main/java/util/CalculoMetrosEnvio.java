package util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 * Establece conexión con RoutesAPI y recopila los metros
 * @author Samuel Vega
 */
public class CalculoMetrosEnvio {
    // Clave de API necesaria para usar el servicio
    private static final String API_KEY = "AIzaSyAd7Dz8i4pztaRb6z1ExagrwSgDDFnwGNI";
    
    /**
     * Realiza una petición HTTP para saber la distancia entre dos puntos y la regresa en metros
     * @param destino Lugar a dónde debe llegar
     * @return Distancia en metros de un lugar A a un lugar B
     * @throws IOException Si pasa algo de entrada/salida
     * @throws InterruptedException Si se interrumpe
     */
    public int getDistanciaMetros(String destino) throws IOException, InterruptedException {
        double[] coorOrigen = obtenerCoordenadas("C. Manuel Acuña 1721, 85098 Cdad. Obregón, Son.");
        double[] coorDestino = obtenerCoordenadas(destino);
        
        String url = String.format("https://routes.googleapis.com/directions/v2:computeRoutes?key=%s", API_KEY);
        
        String jsonBody = String.format("{"
                + "\"origin\": {"
                    + "\"location\": {"
                        + "\"latLng\": {"
                            + "\"latitude\": %f,"
                            + "\"longitude\": %f"
                        + "}"
                    + "}"
                + "},"
                + "\"destination\": {"
                    + "\"location\": {"
                        + "\"latLng\": {"
                            + "\"latitude\": %f,"
                            + "\"longitude\": %f"
                        + "}"
                    + "}"
                + "},"
                + "\"travelMode\": \"DRIVE\","
                + "\"routingPreference\": \"TRAFFIC_UNAWARE\""
                + "}"
                , coorOrigen[0], coorOrigen[1], coorDestino[0], coorDestino[1]);
        
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").header("X-Goog-FieldMask", "routes.distanceMeters,routes.duration").POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();
        
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        
        if(response.statusCode() == 200) {
            System.out.println(this.parseDistanciaResponse(response.body()));
            return this.parseDistanciaResponse(response.body());
        }else {
            throw new IOException("Error en la solicitud http: " + response.statusCode());
        }
    }
    
    /**
     * Obtiene la distancia en metros desde el resultado de la petición HTTP
     * @param json Respuesta del HTTP
     * @return La distancia en metros
     */
    private int parseDistanciaResponse(String json) {
        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject jsonResponse = jsonElement.getAsJsonObject();

        System.out.println("Respuesta JSON completa: " + jsonResponse);

        JsonArray routes = jsonResponse.getAsJsonArray("routes");
        if (routes == null || routes.size() == 0) {
            throw new IllegalArgumentException("No se encontraron rutas en la respuesta.");
        }

        JsonObject firstRoute = routes.get(0).getAsJsonObject();

        if (!firstRoute.has("distanceMeters")) {
            throw new IllegalArgumentException("No se encontró la distancia en la respuesta.");
        }
        
        return firstRoute.get("distanceMeters").getAsInt();
    }
    
    /**
     * Obtiene las coordenadas de una dirección
     * @param direccion Dirección de la que se quiere saber sus coordenadas
     * @return Coordenadas de la dirección
     * @throws IOException 
     * @throws InterruptedException 
     */
    public double[] obtenerCoordenadas(String direccion) throws IOException, InterruptedException {
        String url = String.format(
            "https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s",
            URLEncoder.encode(direccion, StandardCharsets.UTF_8), 
            API_KEY
        );

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return parseCoordenadas(response.body());
        } else {
            throw new IOException("Error en la solicitud: " + response.statusCode());
        }
    }

    /**
     * Obtiene un arreglo de dobles donde se guardan la latitud y la longitud de la dirección
     * @param jsonResponse Respuesta de una petición HTTP
     * @return Un arreglo de dobles con la latitud y longitud
     */
    private double[] parseCoordenadas(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject location = jsonObject
                .getAsJsonArray("results")
                .get(0).getAsJsonObject()
                .getAsJsonObject("geometry")
                .getAsJsonObject("location");

        double latitud = location.get("lat").getAsDouble();
        double longitud = location.get("lng").getAsDouble();
        return new double[]{latitud, longitud};
    }

}
