import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//
//import org.json.JSONArray;
//import org.json.JSONObject;

public class ShoppingAPI {

	private static HttpURLConnection connection;
	
	public static void main(String[] args) {
		
		BufferedReader reader; 
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		try {
			URL url = new URL("https://api.spoonacular.com/food/ingredients/autocomplete?query=appl&apiKey=704d3da3d2f84275b3ebcf55e3cece44");
			connection = (HttpURLConnection) url.openConnection();
			
			// Request Setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);; 
			
			int status = connection.getResponseCode();
						
			if(status > 299) { // Connection status was NOT successful
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			} else { // Connection WAS successful
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}

//			parse(responseContent.toString());
			System.out.println(responseContent.toString());

			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}

	}
	
	
//	public static String parse(String responseBody) {
//		JSONArray albums = new JSONArray(responseBody);
//		for(int i = 0; i < albums.length(); i++) {
//			JSONObject album = albums.getJSONObject(i);
//			String name = album.getString("name");
//			int id = album.getInt("id");
//			System.out.println(id + "   " + name);
//		}
//		return null;
//		
//	}
}
