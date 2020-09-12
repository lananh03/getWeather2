package i5.las2peer.services.getWeatherService;

public class DailyWeather {
	private long dt;
    private Main main;
    private Weather[] weather;

    public DailyWeather() {
    }

    public long getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public Weather[] getWeather() {
        return weather;
    }

}
