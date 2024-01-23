package edu.emory.oit.assessment.controller;

import edu.emory.oit.assessment.dto.forecast.DayForecastSummary;
import edu.emory.oit.assessment.dto.forecast.WeatherForecastSummary;
import edu.emory.oit.assessment.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class WeatherController {

    @Autowired
    private WeatherForecastService weatherForecastService;

    @GetMapping("/v1/weather-summary")
    public ResponseEntity<DayForecastSummary> getDayForecastSummaryResponseEntity(@RequestParam String postalCode, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        WeatherForecastSummary weatherForecastSummary = weatherForecastService.getDayForecastSummary(postalCode, startDate, endDate);
        return new ResponseEntity(weatherForecastSummary, HttpStatus.OK);

    }
}
