package com.example.ec.explorecaliTour.controller;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import com.example.ec.explorecaliTour.domain.Difficulty;
import com.example.ec.explorecaliTour.domain.Region;


public class TourDto {
	@Id
	@GeneratedValue
	private Integer id;

	
	private String title;
	
	private String description;
	
	private String blurb;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBlurb() {
		return blurb;
	}
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getBullets() {
		return bullets;
	}
	public void setBullets(String bullets) {
		this.bullets = bullets;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	@Column
	private Integer price;
	@Column
	private String bullets;
	@Column
	private String duration;
	@Column
	private String keywords;
	@Column 
	private Difficulty difficulty;
	@Column
	private Region region;
}
