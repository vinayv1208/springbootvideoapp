package com.video.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Video {
	
	int id;
	String name;
	String discription;
	String director;
	String hero;
	String heroin;
	int budjet;
	String produced_by;
	String release_date;
	String language;
	String category;
	
	public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public String getDirector() {
        return director;
    }

    public String getHero() {
        return hero;
    }

    public String getHeroin() {
        return heroin;
    }

    public int getBudjet() {
        return budjet;
    }

    public String getProduced_by() {
        return produced_by;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getLanguage() {
        return language;
    }

    public String getCategory() {
        return category;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public void setHeroin(String heroin) {
        this.heroin = heroin;
    }

    public void setBudjet(int budjet) {
        this.budjet = budjet;
    }

    public void setProduced_by(String produced_by) {
        this.produced_by = produced_by;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCategory(String category) {
        this.category = category;
    }

	
	
	/*
	 * {
  "id": "1",
  "name": "The Dark Knight",
  "discription": "After Gordon, Dent  organised ",
  "director": "Christopher Nolan",
  "hero": "Joker",
  "heroin": "NA",
  "budjet": "100",
  "produced_by": "DC Comics",
  "release_date": "20-10-2016",
  "language": "English",
  "category": "premium"
}
	 */
	
}
