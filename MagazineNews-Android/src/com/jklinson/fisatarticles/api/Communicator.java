/**
 *
 *
 */
package com.jklinson.fisatarticles.api;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jklinson.fisatarticles.globals.Globals;
import com.jklinson.fisatarticles.globals.Logger;
import com.jklinson.fisatarticles.globals.NetworkConnectivityManager;
import com.jklinson.fisatarticles.models.LatestNews;

import android.content.Context;
import android.util.Log;


/**
 * @author Linson
 *
 * This class will handle the functions which communicate with the server
 */
public class Communicator {

	Context context;
	NetworkConnectivityManager connectivityManager;
	public static String TAG="Communicator";
	public String appendUrl;
	public Communicator(Context context) {

		this.context = context;
		connectivityManager=new NetworkConnectivityManager(context);
	}
	/**
	 * @param userName
	 * @param password
	 */
	public ArrayList<LatestNews> getLatestNews() {
		
		 String url=Globals.baseURL+Globals.latestNews;
		 ArrayList<LatestNews>latestNewsList=new ArrayList<LatestNews>();
		 try {
			 JSONObject latestNewsResponse=GetRequest.post(url,null);
			 
			 JSONArray results =latestNewsResponse.getJSONArray("results");
			
			for (int i = 0; i < results.length(); i++) {
				LatestNews news = new LatestNews(results.getJSONObject(i));
				latestNewsList.add(news);				
			}			
			 return latestNewsList;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;

		}
	
	

	
}
