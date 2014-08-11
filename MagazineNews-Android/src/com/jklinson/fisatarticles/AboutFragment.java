package com.jklinson.fisatarticles;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutFragment extends Fragment {

	private Activity context;
	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		context =getActivity();
    	rootView = inflater.inflate(R.layout.about_page, container, false);      
        
		return rootView;
	}

	
	
}
