package dev.carlos.citiesAPI.geo.models.responses;

public class CityResponse {
    private String cityName;
    private String cityUf;
    private String cityRegion;
    private String cityShortDescription;
    private String cityDescription;
    private String cityImage;
    private Integer cityPopulation;
    private String cityAltitude;
    private Integer cityArea;
    private String cityMayor;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityUf() {
        return cityUf;
    }

    public void setCityUf(String cityUf) {
        this.cityUf = cityUf;
    }

    public String getCityRegion() {
        return cityRegion;
    }

    public void setCityRegion(String cityRegion) {
        this.cityRegion = cityRegion;
    }

    public String getCityShortDescription() {
        return cityShortDescription;
    }

    public void setCityShortDescription(String cityShortDescription) {
        this.cityShortDescription = cityShortDescription;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }

    public String getCityImage() {
        return cityImage;
    }

    public void setCityImage(String cityImage) {
        this.cityImage = cityImage;
    }

    public Integer getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(Integer cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public String getCityAltitude() {
        return cityAltitude;
    }

    public void setCityAltitude(String cityAltitude) {
        this.cityAltitude = cityAltitude;
    }

    public Integer getCityArea() {
        return cityArea;
    }

    public void setCityArea(Integer cityArea) {
        this.cityArea = cityArea;
    }

    public String getCityMayor() {
        return cityMayor;
    }

    public void setCityMayor(String cityMayor) {
        this.cityMayor = cityMayor;
    }
}
