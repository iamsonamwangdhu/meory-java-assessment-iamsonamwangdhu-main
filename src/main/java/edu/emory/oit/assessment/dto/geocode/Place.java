package edu.emory.oit.assessment.dto.geocode;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Place {
  private String latitude;
  private String longitude;
  @JsonAlias("place name")
  private String placeName;
  private String state;
  @JsonAlias("state abbreviation")
  private String stateAbbreviation;

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public String getPlaceName() {
    return placeName;
  }

  public String getState() {
    return state;
  }

  public String getStateAbbreviation() {
    return stateAbbreviation;
  }

  @Override
  public String toString() {
    return "Place{" +
        "latitude='" + latitude + '\'' +
        ", longitude='" + longitude + '\'' +
        ", placeName='" + placeName + '\'' +
        ", state='" + state + '\'' +
        ", stateAbbreviation='" + stateAbbreviation + '\'' +
        '}';
  }
}
