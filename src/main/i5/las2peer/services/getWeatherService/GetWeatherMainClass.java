package i5.las2peer.services.getWeatherService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
public class GetWeatherMainClass extends RESTService {
	
	public GetWeatherMainClass() {

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
	
	public Response getWeather(@PathParam("location") String location) {
				
		  String API_KEY = "347e72f54a7cde54465418abd431fcf0";
	      String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY;
	      String output = null;
	      
	      try {

	  		URL url = new URL(urlString);
	  		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	  		conn.setRequestMethod("GET");
	  		conn.setRequestProperty("Accept", "application/json");

	  		BufferedReader br = new BufferedReader(new InputStreamReader(
	  			(conn.getInputStream())));

	  		System.out.println("Output from Server .... \n");
	  		while ((output = br.readLine()) != null) {
	  			System.out.println(output);
	  		}

	  		
	  		conn.disconnect();

	  	  } catch (MalformedURLException e) {

	  		e.printStackTrace();

	  	  } catch (IOException e) {

	  		e.printStackTrace();

	  	  }

		return Response.ok().entity(output).build();
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
