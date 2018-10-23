package com.game;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	private static int value;
	private static final String GET_URL = "http://localhost:9080/Sample/rest/sample/generar?value=";
	private static final String USER_AGENT = "Chrome/69.0.3497.100";
	

	public static void main(String[] args) throws IOException {
		
		Main.setValue(3);
		sendGET();
	}

	private static void sendGET() throws IOException {
		URL obj = new URL(GET_URL+ value) ;
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response);
		} else {
			System.out.println("GET request not worked");
		}

	}

	public static int getValue() {
		return value;
	}

	public static void setValue(int value) {
		Main.value = value;
	}


	}
	

	




