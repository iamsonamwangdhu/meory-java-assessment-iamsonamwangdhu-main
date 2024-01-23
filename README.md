# emory-java-assessment

## Instructions

Given two endpoints (described in more details in the [Endpoints](#endpoints) section):
* [Get Location Info By Postal Code](#get-location-info-by-postal-code)
* [Get Weather Forecast](#get-weather-forecast)

Perform the three tasks outlined in the [Tasks](#tasks) section.

In the main method of the `Application.java` file, you will see an example of how to invoke the two endpoints to get the raw forecast for the next ten days.

You have been provided the DTOs necessary to invoke the two endpoints.

For these tasks, feel free to make update the existing code, create new classes, create new packages, etc.

It is not required, but it would be nice to see you leverage [Spring Boot](https://spring.io/projects/spring-boot) for these tasks.

Good luck!

## Tasks

### Task 1
Create a new class called `WeatherForecastSummary` from `ForecastResponse` with the following requirements:

* implements the following methods:
    * `LocalDateTime getCreationTime()`: the date and time the `WeatherForecastSummary` was created
    * `LocalDate getStartDate()`: the first date in the `WeatherForecastSummary`
    * `LocalDate getEndDate()`: the last date in the `WeatherForecastSummary`
    * `List<DayForecastSummary> getForecasts()`: a list of `DayForecastSummary` objects sorted by the date
* should be immutable
* if multiple `WeatherForecastSummary` objects are placed into a `HashSet` with the same `getCreationTime()`, only 1 should be retained regardless of the other field values

### Task 2
Create a new class called `DayForecastSummary` with the following requirements:

* implements the following methods:
    * `LocalDate getDate()`: the date of the forecast summary
    * `String getHighestTemperature()`: the highest temperature with units for the given date
    * `String getLowestTemperature()`: the lowest temperature with units for the given date
    * `String getAveragePrecipitationProbability()`: the average precipitation probability with units for the given date
    * `String getAverageRelativeHumidity()`: the average relativeHumidity with units for the given date
    * `String getAverageWindspeed()`: the average windspeed with units for the given date
* should be immutable
* when `Collections.sort()` is applied to a list of `DayForecastSummary` instances, the list should be sorted by `getDate()` in chronological order

### Task 3
Expose a REST endpoint that accepts a postal code, a start date, and an end date and returns the `WeatherForecastSummary` in JSON format

For example, if the following cURL call was made:
```
curl -X GET "http://localhost:8080/api/v1/weather-summary?postalCode=33135&startDate=2023-06-12&endDate=2023-06-22"
```
the response should look like the following:
```json
{
  "creationTime": "2023-06-12T17:54:48.257346",
  "startDate": "2023-06-12",
  "endDate": "2023-06-16",
  "forecasts": [
    {
      "date": "2023-06-12",
      "highestTemperature": "87.8°F",
      "lowestTemperature": "78.1°F",
      "averagePrecipitationProbability": "72.9%",
      "averageRelativeHumidity": "82.5%",
      "averageWindspeed": "6.9mp/h"
    },
    {
      "date": "2023-06-13",
      "highestTemperature": "85.8°F",
      "lowestTemperature": "75.2°F",
      "averagePrecipitationProbability": "38.2%",
      "averageRelativeHumidity": "83.2%",
      "averageWindspeed": "5.1mp/h"
    },
    ...
  ]
}
```
This example response above has been truncated. You can find the full response in the `task3Response.json` file in the root of this repository.

### Optional Task

* Add unit tests to verify the code functionality as well as the requirements

## Endpoints

### Get Location Info By Postal Code

#### Endpoint
`GET https://api.zippopotam.us/us/{postalCode}`

#### Description
Returns the location information for a given `postalCode` (particularly the `latitude` and `longitude`)

For more information on the API, take a look at the [API Documentation](https://api.zippopotam.us/).

#### Example Response:
`GET https://api.zippopotam.us/us/33135`
```json
{
  "post code": "33135",
  "country": "United States",
  "country abbreviation": "US",
  "places": [
    {
      "place name": "Miami",
      "longitude": "-80.2317",
      "state": "Florida",
      "state abbreviation": "FL",
      "latitude": "25.7664"
    }
  ]
}
```

### Get Weather Forecast

#### Endpoint

`GET` https://api.open-meteo.com/v1/forecast
* Query Parameters
    * `latitude`
    * `longitude`
    * `start_date`
    * `end_date`
    * `hourly`
    * `temperature_unit`
    * `windspeed_unit`

#### Description
Returns the weather forecast at the given `latitude` and `longitude` between `start_date` and `end_date`.

For more information on the API, take a look at the [API Documentation](https://open-meteo.com/en/docs#:~:text=Every%206%20hours-,API%20Documentation,-The%20API%20endpoint).

#### Example Response:
`GET` https://api.open-meteo.com/v1/forecast?latitude=25.7664&longitude=-80.2317&start_date=2023-05-31&end_date=2023-06-06&hourly=is_day,temperature_2m,precipitation_probability,relativehumidity_2m,windspeed_10m&temperature_unit=fahrenheit&windspeed_unit=mph
```json
{
  "latitude": 25.777832,
  "longitude": -80.22708,
  "generationtime_ms": 0.23090839385986328,
  "utc_offset_seconds": 0,
  "timezone": "GMT",
  "timezone_abbreviation": "GMT",
  "elevation": 4.0,
  "hourly_units": {
    "time": "iso8601",
    "is_day": "",
    "temperature_2m": "°F",
    "precipitation_probability": "%",
    "relativehumidity_2m": "%",
    "windspeed_10m": "mp/h"
  },
  "hourly": {
    "time": ["2023-05-31T00:00", "2023-05-31T01:00", "2023-05-31T02:00", ...],
    "is_day": [1, 0, 0, ...],
    "temperature_2m": [82.1, 76.8, 74.2, ...],
    "precipitation_probability": [100, 100, 100, ...],
    "relativehumidity_2m": [72, 85, 90, ...]
  }
}
```
This example response above has been truncated. You can find the full response in the `forecastResponseExample.json` file in the root of this repository.
