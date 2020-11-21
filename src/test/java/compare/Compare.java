package compare;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import Modal.Example;
import helper.WeatherController;

public class Compare {

	static Example exmp;
	String city;

	/**
	 * @author nikgoel1
	 * @param val
	 * @param city
	 * @return
	 * @throws Exception 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String resdAPIDATA(String val, String city){
		try {
			exmp = new WeatherController().getTempAPI(city);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getMAxTempAPI();
	}

	public static String getMAxTempAPI() {
		return ((exmp.getMain().getTemp_max()));
	}

}
