package edu.emory.oit.assessment.dto.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HourlyUnits {
  private String time;
  @JsonProperty("temperature_2m")
  private String temperature;
  @JsonProperty("precipitation_probability")
  private String precipitationProbability;
  @JsonProperty("relativehumidity_2m")
  private String relativeHumidity;
  @JsonProperty("windspeed_10m")
  private String windspeed;

  public String getTime() {
    return time;
  }

  public String getTemperature() {
    return temperature;
  }

  public String getPrecipitationProbability() {
    return precipitationProbability;
  }

  public String getRelativeHumidity() {
    return relativeHumidity;
  }

  public String getWindspeed() {
    return windspeed;
  }

  @Override
  public String toString() {
    return "HourlyUnits{" +
        "time='" + time + '\'' +
        ", temperature='" + temperature + '\'' +
        ", precipitationProbability='" + precipitationProbability + '\'' +
        ", relativeHumidity='" + relativeHumidity + '\'' +
        ", windspeed='" + windspeed + '\'' +
        '}';
  }
}
