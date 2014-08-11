package com.jklinson.fisatarticles.adapters;

import java.util.ArrayList;

import com.jklinson.fisatarticles.R;
import com.jklinson.fisatarticles.models.LatestNews;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LatestNewsAdapters extends ArrayAdapter<LatestNews> {

	Context context;
	ArrayList<LatestNews>latestNews =new ArrayList<LatestNews>();
	protected ImageLoader imageLoader;
	DisplayImageOptions options;
	public LatestNewsAdapters(Context context,
			int textViewResourceId, ArrayList<LatestNews> news, ImageLoader loader) {
		super(context, textViewResourceId, news);
		this.context=context;
		this.latestNews=news;
		imageLoader = loader;
		
		setimageoptions();
	}
	private void setimageoptions() {
		options = new DisplayImageOptions.Builder().cacheInMemory(true)
				.cacheOnDisc(true).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.resetViewBeforeLoading(true)
				.showImageOnLoading(R.drawable.image_loading)
				.showImageOnFail(R.drawable.noimage).build();

	}
	@Override
	public View getView(int position, View v, ViewGroup parent) {
		if (v == null) {
			v = View.inflate(getContext(), R.layout.item_list_favorites, null);
		}

		TextView titleTextView = (TextView) v.findViewById(R.id.text1);
		titleTextView.setText(latestNews.get(position).getNewsTitle());
		TextView ratingTextView = (TextView) v
				.findViewById(R.id.favorite_meal_rating);
		ratingTextView.setText(latestNews.get(position).getNewsDescription());
		imageLoader.displayImage(latestNews.get(position).getNewsImageUrl(),(ImageView)v.findViewById(R.id.icon), options);
		return v;
	}
	
}
