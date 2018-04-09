package com.skilldistillery.filmquery.entities;

public class Film {
	private int id;
	private String title;
	private String desc;
	private int releaseYear;
	private int langId;
	private int rentalDur;
	private double rentalRate;
	private int length;
	private double replaceCost;
	private String rating;
	private String specialFeat;
	private List<Actor> cast
	
	
	
	public Film(int id, String title, String desc, int releaseYear, int langId, int rentalDur, double rentalRate,
			int length, double replaceCost, String rating, String specialFeat) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentalDur = rentalDur;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replaceCost = replaceCost;
		this.rating = rating;
		this.specialFeat = specialFeat;
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", desc=" + desc + ", releaseYear=" + releaseYear + ", langId="
				+ langId + ", rentalDur=" + rentalDur + ", rentalRate=" + rentalRate + ", length=" + length
				+ ", replaceCost=" + replaceCost + ", rating=" + rating + ", specialFeat=" + specialFeat + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getLangId() {
		return langId;
	}
	public void setLangId(int langId) {
		this.langId = langId;
	}
	public int getRentalDur() {
		return rentalDur;
	}
	public void setRentalDur(int rentalDur) {
		this.rentalDur = rentalDur;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getReplaceCost() {
		return replaceCost;
	}
	public void setReplaceCost(double replaceCost) {
		this.replaceCost = replaceCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecialFeat() {
		return specialFeat;
	}
	public void setSpecialFeat(String specialFeat) {
		this.specialFeat = specialFeat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + id;
		result = prime * result + langId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + rentalDur;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replaceCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeat == null) ? 0 : specialFeat.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (id != other.id)
			return false;
		if (langId != other.langId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentalDur != other.rentalDur)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replaceCost) != Double.doubleToLongBits(other.replaceCost))
			return false;
		if (specialFeat == null) {
			if (other.specialFeat != null)
				return false;
		} else if (!specialFeat.equals(other.specialFeat))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



}
