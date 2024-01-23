package edu.emory.oit.assessment;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.emory.oit.assessment.dto.geocode.GeocodeResponse;
import edu.emory.oit.assessment.dto.forecast.ForecastResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

public class Application {
  public static void main(String[] args) throws Exception {
    String zipCode = "33135";

    // Notice that this example implementation uses the Java HttpClient. For your tasks, we would
    // like to see you use a reactive or asynchronous client such as:
    //   * Spring's WebClient (https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/reactive/function/client/WebClient.html)
    //   * Apache HttpComponents's HttpClient (https://hc.apache.org/httpcomponents-client-5.2.x/index.html)
    //   * any reactive/asynchronous client of your choice
    HttpClient httpClient = HttpClient.newHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    // Find the latitude and longitude for the given zipCode
    URI geocodeUri = URI.create(String.format("https://api.zippopotam.us/us/%s", zipCode));
    HttpRequest geocodeRequest = HttpRequest.newBuilder().GET().uri(geocodeUri).build();
    HttpResponse<String> geocodeHttpResponse = httpClient.send(geocodeRequest, HttpResponse.BodyHandlers.ofString());
    GeocodeResponse geocodeResponse = objectMapper.readValue(geocodeHttpResponse.body(), GeocodeResponse.class);
    String latitude = geocodeResponse.getPlaces()[0].getLatitude();
    String longitude = geocodeResponse.getPlaces()[0].getLongitude();

    // Get the weather forecast for the next ten days
    URI forecastUri = URI.create(String.format(
        "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&start_date=%s&end_date=%s&hourly=temperature_2m,precipitation_probability,relativehumidity_2m,windspeed_10m&temperature_unit=fahrenheit&windspeed_unit=mph",
        latitude,
        longitude,
        LocalDate.now(),
        LocalDate.now().plusDays(10)
    ));
    HttpRequest forecastRequest = HttpRequest.newBuilder().GET().uri(forecastUri).build();
    HttpResponse<String> forecaseHttpResponse = httpClient.send(forecastRequest, HttpResponse.BodyHandlers.ofString());
    ForecastResponse forecastResponse = objectMapper.readValue(forecaseHttpResponse.body(), ForecastResponse.class);

    System.out.println(forecastResponse);
  }
}
