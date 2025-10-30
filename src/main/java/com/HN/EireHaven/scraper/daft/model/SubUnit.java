package com.HN.EireHaven.scraper.daft.model;

import java.util.List;

public class SubUnit {
    private long id;
    private String price;
    private String numBedrooms;
    private String numBathrooms;
    private String propertyType;
    private String berRating;
    private String seoFriendlyPath;
    private List<String> images;

    public SubUnit() {
    }

    public SubUnit(long id, String price, String numBedrooms, String numBathrooms, String propertyType, String berRating, String seoFriendlyPath, List<String> images) {
        this.id = id;
        this.price = price;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.propertyType = propertyType;
        this.berRating = berRating;
        this.seoFriendlyPath = seoFriendlyPath;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(String numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public String getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(String numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getBerRating() {
        return berRating;
    }

    public void setBerRating(String berRating) {
        this.berRating = berRating;
    }

    public String getSeoFriendlyPath() {
        return seoFriendlyPath;
    }

    public void setSeoFriendlyPath(String seoFriendlyPath) {
        this.seoFriendlyPath = seoFriendlyPath;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
