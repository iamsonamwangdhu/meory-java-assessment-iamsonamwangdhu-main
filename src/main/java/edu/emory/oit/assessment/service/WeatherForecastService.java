package edu.emory.oit.assessment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.emory.oit.assessment.dto.forecast.WeatherForecastSummary;
import edu.emory.oit.assessment.dto.geocode.GeocodeResponse;
import edu.emory.oit.assessment.exception.WhetherProcessorException;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public final class WeatherForecastService {
    private WeatherForecastSummary weatherForecastSummary;

    public WeatherForecastSummary getDayForecastSummary(String postalCode, LocalDate startDate, LocalDate endDate) {
        weatherForecastSummary = new WeatherForecastSummary();
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            ObjectMapper objectMapper = new ObjectMapper();

            // Find the latitude and longitude for the given zipCode
            URI geocodeUri = URI.create(String.format("https://api.zippopotam.us/us/%s", postalCode));
            HttpRequest geocodeRequest = HttpRequest.newBuilder().GET().uri(geocodeUri).build();
            HttpResponse<String> geocodeHttpResponse = httpClient.send(geocodeRequest, HttpResponse.BodyHandlers.ofString());
            GeocodeResponse geocodeResponse = objectMapper.readValue(geocodeHttpResponse.body(), GeocodeResponse.class);
            String latitude = geocodeResponse.getPlaces()[0].getLatitude();
            String longitude = geocodeResponse.getPlaces()[0].getLongitude();

            // Get the weather forecast for the next ten days
            URI forecastUri = URI.create(String.format(
                    "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&" + startDate + "=%s&" + endDate + "=%s&hourly=temperature_2m,precipitation_probability,relativehumidity_2m,windspeed_10m&temperature_unit=fahrenheit&windspeed_unit=mph",
                    latitude,
                    longitude,
                    LocalDate.now(),
                    LocalDate.now().plusDays(10)
            ));
            HttpRequest forecastRequest = HttpRequest.newBuilder().GET().uri(forecastUri).build();
            HttpResponse<String> forecaseHttpResponse = httpClient.send(forecastRequest, HttpResponse.BodyHandlers.ofString());
            weatherForecastSummary = objectMapper.readValue(forecaseHttpResponse.body(), WeatherForecastSummary.class);

        } catch (Exception ex) {
            throw new WhetherProcessorException("Exception while fetching whether information");
        }
        return weatherForecastSummary;
    }

    private LocalDateTime getCreationTime() {
        LocalDateTime now = weatherForecastSummary.getCreationTime();
        return now;
    }

    private LocalDate getStartDate() {
        LocalDate date = weatherForecastSummary.getStartDate();
        return date;
    }

    private LocalDate getEndDate() {
        LocalDate date = weatherForecastSummary.getEndDate();
        return date;
    }

    private List<WeatherForecastSummary> getForecasts() {
        List<WeatherForecastSummary> weatherForecastSummaries = new ArrayList<>();
        weatherForecastSummaries.add(weatherForecastSummary);
        return weatherForecastSummaries;
    }
}
