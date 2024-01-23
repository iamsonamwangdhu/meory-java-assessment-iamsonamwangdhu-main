package edu.emory.oit.assessment.dto.forecast;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public final class WeatherForecastSummary {

    private LocalDateTime creationTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<DayForecastSummary> dayForecastSummaries;

    public LocalDateTime getCreationTime() {
        return creationTime;
    }


    public LocalDate getStartDate() {
        return startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }


    public List<DayForecastSummary> getDayForecastSummaries() {
        return dayForecastSummaries;
    }


}
