package edu.emory.oit.assessment.dto.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ForecastResponse {
    private String latitude;
    private LocalDate date;
    private String highestTemperature;
    private String lowestTemperature;
    private String averagePrecipitationProbability;
    private String averageRelativeHumidity;
    private String averageWindspeed;
    private String longitude;
    @JsonProperty("generationtime_ms")
    private double generationTimeMillis;
    @JsonProperty("utc_offset_seconds")
    private double utcOffsetSeconds;
    private String timezone;
    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;
    private double elevation;
    @JsonProperty("hourly_units")
    private HourlyUnits hourlyUnits;
    private Hourly hourly;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHighestTemperature() {
        return highestTemperature;
    }

    public void setHighestTemperature(String highestTemperature) {
        this.highestTemperature = highestTemperature;
    }

    public String getLowestTemperature() {
        return lowestTemperature;
    }

    public void setLowestTemperature(String lowestTemperature) {
        this.lowestTemperature = lowestTemperature;
    }

    public String getAveragePrecipitationProbability() {
        return averagePrecipitationProbability;
    }

    public void setAveragePrecipitationProbability(String averagePrecipitationProbability) {
        this.averagePrecipitationProbability = averagePrecipitationProbability;
    }

    public String getAverageRelativeHumidity() {
        return averageRelativeHumidity;
    }

    public void setAverageRelativeHumidity(String averageRelativeHumidity) {
        this.averageRelativeHumidity = averageRelativeHumidity;
    }

    public String getAverageWindspeed() {
        return averageWindspeed;
    }

    public void setAverageWindspeed(String averageWindspeed) {
        this.averageWindspeed = averageWindspeed;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public double getGenerationTimeMillis() {
        return generationTimeMillis;
    }

    public void setGenerationTimeMillis(double generationTimeMillis) {
        this.generationTimeMillis = generationTimeMillis;
    }

    public double getUtcOffsetSeconds() {
        return utcOffsetSeconds;
    }

    public void setUtcOffsetSeconds(double utcOffsetSeconds) {
        this.utcOffsetSeconds = utcOffsetSeconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.timezoneAbbreviation = timezoneAbbreviation;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public HourlyUnits getHourlyUnits() {
        return hourlyUnits;
    }

    public void setHourlyUnits(HourlyUnits hourlyUnits) {
        this.hourlyUnits = hourlyUnits;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }
}
