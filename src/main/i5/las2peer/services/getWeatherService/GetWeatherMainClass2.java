package i5.las2peer.services.getWeatherService;

import java.net.HttpURLConnection;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import i5.las2peer.restMapper.RESTService;
import i5.las2peer.restMapper.annotations.ServicePath;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

// TODO Describe your own service
/**
 * las2peer-Template-Service
 * 
 * This is a template for a very basic las2peer service that uses the las2peer WebConnector for RESTful access to it.
 * 
 * Note: If you plan on using Swagger you should adapt the information below in the SwaggerDefinition annotation to suit
 * your project. If you do not intend to provide a Swagger documentation of your service API, the entire Api and
 * SwaggerDefinition annotation should be removed.
 * 
 */
// TODO Adjust the following configuration
@Api
@SwaggerDefinition(
		info = @Info(
				title = "las2peer Template Service",
				version = "1.0.0",
				description = "A las2peer Template Service for demonstration purposes.",
				termsOfService = "http://your-terms-of-service-url.com",
				contact = @Contact(
						name = "John Doe",
						url = "provider.com",
						email = "john.doe@provider.com"),
				license = @License(
						name = "your software license name",
						url = "http://your-software-license-url.com")))
@ServicePath("weather")
// TODO Your own service class
public class GetWeatherMainClass2 extends RESTService {

	
	private static final String REST_URI = "https://api.openweathermap.org";
	private static final String APPID = "1b2b3a82a8e633366caef05c1f70bcb2";
	private Client client;
	private WebTarget webTarget;
	
	public GetWeatherMainClass2() {
		client = ClientBuilder.newClient();
		webTarget = client.target(REST_URI);
	}

	/**
	 * Template of a get function.
	 * @return Returns an HTTP response with the username as string content.
	 */
	@SuppressWarnings({ })
	@GET
	@Path("{location}")
	@Produces(MediaType.APPLICATION_JSON)
	
	@ApiResponses(
			value = { @ApiResponse(
					code = HttpURLConnection.HTTP_NOT_FOUND,
					message = "Connection lost"),//
					@ApiResponse(
							code = HttpURLConnection.HTTP_OK,
							message = "Success|OK")})
	@ApiOperation(
			value = "weather",
			notes = "Return current weather of Aachen")
	
	/**public static Map<String,Object> jsonToMap(String str){
	    Map<String,Object> map = new Gson().fromJson(str,new TypeToken<HashMap<String,Object>> () {
			private static final long serialVersionUID = 1L;}.getType());
	    return map;
	}
	**/
	public void getWeather(@PathParam("location") String location) {
				
		  /**final String REST_URI = "https://api.openweathermap.org";
		  String API_KEY = "347e72f54a7cde54465418abd431fcf0";
	      String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY;

	      try{

	          StringBuilder result = new StringBuilder();
	          URL url = new URL(urlString);
	          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	          BufferedReader rd = new BufferedReader(new InputStreamReader (conn.getInputStream()));
	          String line;
	          while ((line = rd.readLine()) != null){
	              //PrintStream result = null;
				result.append(line);
	          } 
	          rd.close();
	          System.out.println(result);
/**
	          Map<String, Object> respMap = jsonToMap (result.toString());
	          Map<String, Object> mainMap = jsonToMap (((HashMap<String, Object>) respMap).get("main").toString());

	          System.out.println("Current Temperature: " + ((HashMap<String,Object>) mainMap).get("temp")  );
	          **/
	      /**}catch (IOException e){
	          System.out.println(e.getMessage());
	      }**/
	       //HashMap<String, Object> mainMap = null;
		// create gson object
		
		System.out.println(webTarget.toString());
		WebTarget target = webTarget.path("data").path("2.5").path("weather").queryParam("q", location).queryParam("units","metric").queryParam("APPID", APPID);
		// Prepare HTTP GET request 
		Builder builder = target.request();
		// define accepted media types
		builder.accept(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		
	        String body = response.readEntity(String.class);
			
	  		Gson gsonObj = new Gson();
	  		CurrentWeather currWeather1 = gsonObj.fromJson(body, CurrentWeather.class);
			//Gson gsonObj2 = ((GsonBuilder) new GsonBuilder().setPrettyPrinting()).create();
			System.out.println(gsonObj.toJson(currWeather1.getWeather().get(0)));
			System.out.println(gsonObj.toJson(currWeather1.getMain()));
	    	}
		
		public static void main(String args[]) {
			RestClient restclient = new RestClient(REST_URI);
			if(args.length == 0)
				System.out.println("No arguments were given");
			else {
				if((args[0].equals("-currentWeather") || args[0].equals("-weatherForecast")) && args.length != 2)
					System.out.println("Missing arguments");
				else if(args[0].equals("-currentWeather"))
					restclient.getCurrentWeather(args[1]);
				//else if(args[0].equals("-weatherForecast"))
				//	restclient.getWeatherForecast(args[1]);
			}
		
	  	   //String weather = gsonObj2.toJson(currWeather.getWeather());
		  // @SuppressWarnings("null") **/
		  /** String weather =("Current Temperature: " + ((HashMap<String,Object>) mainMap).get("temp"));
		   String returnString = "{"//
				+ "'location':'" + location + "',"
				+ "'info':'" + weather + "'"//
				+ "}";
		return Response.ok().entity(returnString).build();**/
	}
	
	/**public Response getTemplate() {
		UserAgent userAgent = (UserAgent) Context.getCurrent().getMainAgent();
		String name = userAgent.getLoginName();
		return Response.ok().entity(name).build(); 
	} */

	/**
	 * Template of a post function.
	 * 
	 * @param myInput The post input the user will provide.
	 * @return Returns an HTTP response with plain text string content derived from the path input param.
	 */
	@POST
	@Path("/post/{input}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiResponses(
			value = { @ApiResponse(
					code = HttpURLConnection.HTTP_OK,
					message = "REPLACE THIS WITH YOUR OK MESSAGE") })
	@ApiOperation(
			value = "REPLACE THIS WITH AN APPROPRIATE FUNCTION NAME",
			notes = "Example method that returns a phrase containing the received input.")
	public Response postTemplate(@PathParam("input") String myInput) {
		String returnString = "";
		returnString += "Input " + myInput;
		return Response.ok().entity(returnString).build();
	}

	// TODO your own service methods, e. g. for RMI

}
