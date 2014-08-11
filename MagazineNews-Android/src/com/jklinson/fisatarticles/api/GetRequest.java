package com.jklinson.fisatarticles.api;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;







import com.jklinson.fisatarticles.globals.Logger;

import android.util.Log;


public class GetRequest {
	/**
	 * 
	 */
	static JSONObject res = new JSONObject();
	static String TAG = "GetRequest";
	static BufferedReader in = null;
	/**
	 * convert response from url into  a Json object
	 * 
	 * @return JSON object
	 * */
	public static JSONObject post(final String url,JSONObject params) {
		String responseString="";
		try {  
			
			HttpClient httpclient = new DefaultHttpClient();
	         HttpGet request = new HttpGet(url);
	       
		         request.setHeader("X-Parse-Application-Id","j0I2HzB4LphpuPN67T6nNvkLc5XR1yZJpShuehan");
		         request.setHeader("X-Parse-REST-API-Key","P9X13qOOObuE6gmAFh7IVkNOnoWCENSbmUE371Z0");
	         
	         
	         

	         HttpResponse response = httpclient.execute(request);

	        	         

//	         if (response.getStatusLine().getStatusCode() == 200)
//	         {
	        	 in = new BufferedReader(new InputStreamReader(
	                     response.getEntity().getContent()));
	             responseString = in.readLine();
	           
//	         }
			
			
			
			JSONObject jObject = new JSONObject(responseString);
			res = jObject;
			
			
		} catch (NullPointerException e) {
			Logger.show(e);
			res = null;
		} catch (UnsupportedEncodingException e) {
			Logger.show(e);
			res = null;
		} catch (ClientProtocolException e) {
			Logger.show(e);
		} catch (IOException e) {
			Logger.show(e);
			res = null;
		} catch (JSONException e) {
			Logger.show(e);
		}
		return res;
	}
	
}
