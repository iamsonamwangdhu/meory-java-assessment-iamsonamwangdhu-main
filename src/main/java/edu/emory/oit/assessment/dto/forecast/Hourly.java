package edu.emory.oit.assessment.dto.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

public class Hourly {
  private String[] time;
  @JsonProperty("temperature_2m")
  private double[] temperature;
  @JsonProperty("precipitation_probability")
  private int[] precipitationProbability;
  @JsonProperty("relativehumidity_2m")
  private int[] relativeHumidity;
  @JsonProperty("windspeed_10m")
  private double[] windspeed;

  public String[] getTime() {
    return time;
  }

  public double[] getTemperature() {
    return temperature;
  }

  public int[] getPrecipitationProbability() {
    return precipitationProbability;
  }

  public int[] getRelativeHumidity() {
    return relativeHumidity;
  }

  public double[] getWindspeed() {
    return windspeed;
  }

  @Override
  public String toString() {
    return "Hourly{" +
        "time=" + Arrays.toString(time) +
        ", temperature=" + Arrays.toString(temperature) +
        ", precipitationProbability=" + Arrays.toString(precipitationProbability) +
        ", relativeHumidity=" + Arrays.toString(relativeHumidity) +
        ", windspeed=" + Arrays.toString(windspeed) +
        '}';
  }
}
