package co.edu.uco.ucobet.generales.application.primaryports.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;


public final class GetCityDTO {

    private String cityName;
    private String stateName;

    public GetCityDTO(final String cityName, final String stateName) {
        setCityName(cityName);
        setStateName(stateName);
    }

    public static GetCityDTO create (final String cityName, final String stateName) {
        return new GetCityDTO(cityName, stateName);
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setCityName(final String cityName) {
        this.cityName = TextHelper.applyTrim(cityName);
    }

    public void setStateName(final String stateName) {
        this.stateName = TextHelper.applyTrim(stateName);
    }
}
