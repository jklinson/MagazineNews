package com.jklinson.fisatarticles;

import java.util.ArrayList;
import java.util.Locale;

import com.jklinson.fisatarticles.adapters.LatestNewsAdapters;
import com.jklinson.fisatarticles.api.Communicator;
import com.jklinson.fisatarticles.globals.Globals;
import com.jklinson.fisatarticles.globals.NetworkConnectivityManager;
import com.jklinson.fisatarticles.models.LatestNews;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

public class LatestNewsFragment extends Fragment {
    private LatestNewsAdapters latestNewsAdapter;
    private ListView latestNewsListView;
    Context context;
    LatestNewsTask latesNewsTask;
    View rootView ;
	protected ImageLoader imageLoader;
    public LatestNewsFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	context =getActivity();
    	rootView = inflater.inflate(R.layout.fragment_latest_news, container, false);      
        getActivity().setTitle("Latest News");
        imageLoader = ImageLoader.getInstance();
		imageLoader.init(ImageLoaderConfiguration.createDefault(getActivity()));
        latesNewsTask =new LatestNewsTask();
        Void params=null;
        latesNewsTask.execute(params);
        return rootView;
    }
    public void updateList(ArrayList<LatestNews> result) {
    	Log.i("LatestNewsFragment", "In update list "+ result.get(0).getNewsTitle());
    	latestNewsAdapter = new LatestNewsAdapters(getActivity(),R.id.latest_news_list,result,imageLoader);
        latestNewsListView =(ListView)rootView.findViewById(R.id.latest_news_list);
        latestNewsListView.setAdapter(latestNewsAdapter);
    	
	}
	public void showAlertMessage(String title,String message){
		new AlertDialog.Builder(getActivity())
	    .setTitle(title)
	    .setMessage(message)
	    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        }
	     })	    
	    .setIcon(R.drawable.ic_launcher)
	     .show();
	}
    
    public class LatestNewsTask extends AsyncTask<Void, Void, ArrayList<LatestNews>> {

		private ProgressDialog progressDialog;

		@Override
		protected ArrayList<LatestNews> doInBackground(Void... arg0) {
			ArrayList<LatestNews>responseList=new ArrayList<LatestNews>();
			try { 
				NetworkConnectivityManager manager=new NetworkConnectivityManager(context);
				if(manager.hasDataConnectivity()){
					
					Communicator communicator=new Communicator(context);
					responseList=communicator.getLatestNews();
					
					
					
					
					return responseList;
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		
		}

		@Override
		protected void onPostExecute(ArrayList<LatestNews> result) {
			super.onPostExecute(result);
			try {
				progressDialog.dismiss();
				if(result.size()>0){
					
					
						updateList(result);
					}
					else{
						showAlertMessage("Download failed.", "Somethng bad happened while fetching latest news. Please try again.");
					}
						
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			try {
				progressDialog = ProgressDialog.show(
						context, "",
						"Fetching latest news,\n please wait...", true);
				progressDialog.setCancelable(true);
				progressDialog.setOnCancelListener(new OnCancelListener() {
					
					@Override
					public void onCancel(DialogInterface dialog) {

						latesNewsTask.cancel(true);
						progressDialog.dismiss();
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
	}
}
