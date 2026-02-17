package task2;

import java.io.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class WeatherApp {

	public static void main(String[] args) {
		   try {
	            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=19.07&longitude=72.87&current_weather=true";

	            URL url = new URL(apiUrl);
	            HttpURLConnection con = (HttpURLConnection) url.openConnection();
	            con.setRequestMethod("GET");

	            BufferedReader br = new BufferedReader(
	                    new InputStreamReader(con.getInputStream())
	            );

	            StringBuilder response = new StringBuilder();
	            String line;

	            while ((line = br.readLine()) != null) {
	                response.append(line);
	            }
	            br.close();

	            JSONObject json = new JSONObject(response.toString());
	            JSONObject current = json.getJSONObject("current_weather");

	            System.out.println("------ Weather Report ------");
	            System.out.println("Temperature : " + current.getDouble("temperature") + " °C");
	            System.out.println("Wind Speed  : " + current.getDouble("windspeed") + " km/h");
	            System.out.println("WeatherCode : " + current.getInt("weathercode"));
	            System.out.println("----------------------------");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	

	}
