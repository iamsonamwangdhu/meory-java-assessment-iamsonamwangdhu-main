package edu.emory.oit.assessment.dto.forecast;

import edu.emory.oit.assessment.dto.forecast.ForecastResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public final class DayForecastSummary {
    private LocalDate date;
    private String highestTemperature;
    private String lowestTemperature;
    private String averagePrecipitationProbability;
    private String averageRelativeHumidity;
    private String averageWindspeed;

    public LocalDate getDate() {
        return date;
    }


    public String getHighestTemperature() {
        return highestTemperature;
    }


    public String getLowestTemperature() {
        return lowestTemperature;
    }


    public String getAveragePrecipitationProbability() {
        return averagePrecipitationProbability;
    }


    public String getAverageRelativeHumidity() {
        return averageRelativeHumidity;
    }


    public String getAverageWindspeed() {
        return averageWindspeed;
    }


}
