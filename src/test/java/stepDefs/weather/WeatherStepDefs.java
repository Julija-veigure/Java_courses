package stepDefs.weather;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import javax.sound.midi.Soundbank;
import java.util.Map;

public class WeatherStepDefs {

    private int cityId;
    private WeatherResponse response;


    @Given("city id: {int}")
    public void set_city_id(int cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.getWeather(cityId);
    }

    @Then("lon is {double}")
    public void check_lon(double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong lon");

    }

    @Then("lat is {double}")
    public void check_lat(double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat");

    }

    @Then("weather is:")
    public void weathers_data(Map<String, String> weather) {

        Assertions.assertEquals(Integer.valueOf(weather.get("id")), response.getWeathers().get(0).getId(), "Wrong weathers id");
        Assertions.assertEquals(weather.get("main"), response.getWeathers().get(0).getMain(), "Wrong weathers main");
        Assertions.assertEquals(weather.get("description"), response.getWeathers().get(0).getDescription(), "Wrong weathers description");
        Assertions.assertEquals(weather.get("icon"), response.getWeathers().get(0).getIcon(), "Wrong weathers icon");
    }

    @Then("base is {string}")
    public void weather_station(String base) {
        Assertions.assertEquals(base, response.getBase(), "Wrong base");
    }

    @Then("data from weather station main:")
    public void data_from_weather_station(Map<String, String> main) {
        Assertions.assertEquals(Double.valueOf(main.get("temp")), response.getMain().getTemp(), "Wrong main temp");
        Assertions.assertEquals(Double.valueOf(main.get("pressure")), response.getMain().getPressure(), "Wrong main pressure");
        Assertions.assertEquals(Integer.valueOf(main.get("humidity")), response.getMain().getHumidity(), "Wrong main humidity");
        Assertions.assertEquals(Double.valueOf(main.get("temp_min")), response.getMain().getTempMin(), "Wrong main tempMin");
        Assertions.assertEquals(Double.valueOf(main.get("temp_max")), response.getMain().getTempMax(), "Wrong main tempMax");
    }

    @Then("visibility is {int}")
    public void visibility_is(int visibility) {
        Assertions.assertEquals(visibility, response.getVisibility(), "Wrong visibility");
    }

    @And("wind speed is {double} and deg is {int}")
    public void wind_speed_and_deg(double speed, int deg) {
        Assertions.assertEquals(speed, response.getWind().getSpeed(), "Wrong wind speed");
        Assertions.assertEquals(deg, response.getWind().getDeg(), "Wrong wind deg");

    }

    @And("clouds is {int}")
    public void clouds_is(int clouds) {
        Assertions.assertEquals(clouds, response.getClouds().getAll(), "Wrong clouds");
    }

    @And("dt is {int}")
    public void dt_is(int dt) {
        Assertions.assertEquals(dt, response.getDt(), "Wrong dt");
    }

    @And("sys:")
    public void sys(Map<String, String> sys) {
        Assertions.assertEquals(Integer.valueOf(sys.get("type")), response.getSys().getType(), "Wrong sys type");
        Assertions.assertEquals(Integer.valueOf(sys.get("id")), response.getSys().getId(), "Wrong sys id");
        Assertions.assertEquals(Double.valueOf(sys.get("message")), response.getSys().getMessage(), "Wrong sys message");
        Assertions.assertEquals(sys.get("country"), response.getSys().getCountry(), "Wrong sys country");
        Assertions.assertEquals(Integer.valueOf(sys.get("sunrise")), response.getSys().getSunrise(), "Wrong sys sunrise");
        Assertions.assertEquals(Integer.valueOf(sys.get("sunset")), response.getSys().getSunset(), "Wrong sys sunset");
    }


    @And("name is {string}")
    public void name_is(String name) {
        Assertions.assertEquals(name, response.getName(), "Wrong name");
    }

    @And("cod {int}")
    public void cod(int cod) {
        Assertions.assertEquals(cod, response.getCod(), "Wrong cod");
    }


}
