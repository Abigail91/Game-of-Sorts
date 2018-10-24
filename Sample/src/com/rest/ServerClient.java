package com.rest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ServerClient {
	private static int value;
	private static final String GET_URL = "http://localhost:9080/Sample/rest/sample/generar?value=";
	private static final String USER_AGENT = "Chrome/69.0.3497.100";
	private static final String sort_URL = "http://localhost:9080/Sample/rest/sample/ordenar?value=";
	
 public static void main (String[] args) {
	 
 }

	private static void nuevaOleada() throws IOException {
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

	private static void ordenaOleada() throws IOException {
		URL obj = new URL(sort_URL+ value) ;
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
	public static void getOleada (int value) throws IOException {
		ServerClient.setValue(value);
		nuevaOleada();
			
	}
	public void ordenarOleada (int value) throws IOException {
		ServerClient.setValue(value);
		ordenaOleada();
			
	}
	
	public static int getValue() {
		return value;
	}

	public static void setValue(int value) {
		ServerClient.value = value;
	}


}
