package Modal;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class WeatrherParsor {

	/**
	 * @author nikgoel1
	 * @param Json
	 * @return
	 * @throws IOException
	 */
	public Example readJson(String Json) throws IOException {

		try {
			return new ObjectMapper().readValue(Json, Example.class);
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
	}

}
