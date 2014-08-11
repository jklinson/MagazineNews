package com.jklinson.fisatarticles.models;

import org.json.JSONException;
import org.json.JSONObject;

public class LatestNews {

	private String newsTitle;
	private String newsDescription;
	private String createdAt;
	private String updatedAt;
	private String newsImageUrl;
	private String newsId;
	
	private String newsTitle_key 		="news_title";
	private String newsDescription_key 	="news_description";
	private String createdAt_key 		="createdAt";
	private String updatedAt_key		="updatedAt";
	private String newsId_key			="objectId";
	private String images_key			="images";
	private String newsImageUrl_key		="url";
	
	public LatestNews(JSONObject latestObj) throws JSONException {
		
		this.newsTitle 		 = latestObj.getString(newsTitle_key);
		this.newsDescription = latestObj.getString(newsDescription_key);
		this.createdAt		 = latestObj.getString(createdAt_key);
		this.updatedAt 		 = latestObj.getString(updatedAt_key);
		this.newsId 		 = latestObj.getString(newsId_key);
		if(latestObj.has(images_key)){
			this.newsImageUrl= latestObj.getJSONObject(images_key).getString(newsImageUrl_key);
		}
		
		
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsDescription() {
		return newsDescription;
	}

	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getNewsImageUrl() {
		return newsImageUrl;
	}

	public void setNewsImageUrl(String newsImageUrl) {
		this.newsImageUrl = newsImageUrl;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	
	
}
