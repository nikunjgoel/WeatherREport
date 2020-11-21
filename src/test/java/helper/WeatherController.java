package helper;

import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import Modal.Example;
import Modal.WeatrherParsor;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author nikgoel1
 *
 */
public class WeatherController {

	public static Example getTempAPI(String city) throws IOException {
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/";
		RequestSpecification request = RestAssured.given();
		Response response = request.queryParam("q", city).queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
				.get("/weather").then().contentType(ContentType.JSON).extract().response();
		System.out.println(response.asString());
		WeatrherParsor cn = new WeatrherParsor();
		Example exmp = null;
		try {
			exmp = cn.readJson(response.asString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return exmp;
	}
}
