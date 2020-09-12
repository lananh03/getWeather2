package i5.las2peer.services.getWeatherService;

public class JsonResult {

    private DailyWeather[] list;
    private City city;
    private Weather weather;
    private Main main;

    public JsonResult() {
    }

    public DailyWeather[] getList() {
        return list;
    }

    public Weather getWeather() {
        return weather;
    }
    
    public Main getMain() {
        return main;
    }
    
    public City getCity() {
        return city;
    }
}