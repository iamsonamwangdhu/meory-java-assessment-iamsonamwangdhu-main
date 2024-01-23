package edu.emory.oit.assessment.dto.geocode;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.Arrays;

public class GeocodeResponse {
  @JsonAlias("post code")
  private String postCode;
  private String country;
  @JsonAlias("country abbreviation")
  private String countryAbbreviation;
  private Place[] places;

  public String getPostCode() {
    return postCode;
  }

  public String getCountry() {
    return country;
  }

  public String getCountryAbbreviation() {
    return countryAbbreviation;
  }

  public Place[] getPlaces() {
    return places;
  }

  @Override
  public String toString() {
    return "GeocodeResponse{" +
        "postCode='" + postCode + '\'' +
        ", country='" + country + '\'' +
        ", countryAbbreviation='" + countryAbbreviation + '\'' +
        ", places=" + Arrays.toString(places) +
        '}';
  }
}
