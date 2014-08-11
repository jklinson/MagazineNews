package com.jklinson.fisatarticles.globals;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


public class NetworkConnectivityManager {
	Context context;
	static String TAG = "NetworkConnectivityManager";
	public static String SERVER_RESPO_200 = "200";

	public NetworkConnectivityManager(Context context) {
		this.context = context;
	}

	/** Check network connectivity **/
	public boolean hasDataConnectivity() {
		boolean res = false;
		try {
			final ConnectivityManager conMgr = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
			if (activeNetwork != null && activeNetwork.isConnected()) {
				// user is online
				res = true;
			} else {
				// user is offline
				res = false;
			}
		} catch (NullPointerException e) {
			Logger.show(e);
		}
		Logger.show(Log.INFO, TAG, "Network availability :" + res);
		return res;
	}

}
