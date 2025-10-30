package com.HN.EireHaven.scraper.daft.model;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class Listing {
    private long id;
    private String title;
    private String price;
    private String abbreviatedPrice;
    private String numBedrooms;
    private String propertyType;
    private String saleType;
    private String berRating;
    private long publishDate;
    private Instant simplePublishDate;
    private String seoFriendlyPath;
    private double latitude;
    private double longitude;
    private List<String> images;
    private List<SubUnit> subUnits;


    public Listing() {
    }

    public Listing(long id, String title, String price, String abbreviatedPrice, String numBedrooms, String propertyType, String saleType, String berRating, String dateOfConstruction, long publishDate, String seoFriendlyPath, double latitude, double longitude, List<String> images, List<SubUnit> subUnits) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.abbreviatedPrice = abbreviatedPrice;
        this.numBedrooms = numBedrooms;
        this.propertyType = propertyType;
        this.saleType = saleType;
        this.berRating = berRating;
        this.publishDate = publishDate;
        this.seoFriendlyPath = seoFriendlyPath;
        this.latitude = latitude;
        this.longitude = longitude;
        this.images = images;
        this.subUnits = subUnits;
        this.simplePublishDate = Instant.ofEpochMilli(publishDate);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAbbreviatedPrice() {
        return abbreviatedPrice;
    }

    public void setAbbreviatedPrice(String abbreviatedPrice) {
        this.abbreviatedPrice = abbreviatedPrice;
    }

    public String getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(String numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getBerRating() {
        return berRating;
    }

    public void setBerRating(String berRating) {
        this.berRating = berRating;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(long publishDate) {
        this.publishDate = publishDate;
    }

    public String getSeoFriendlyPath() {
        return seoFriendlyPath;
    }

    public void setSeoFriendlyPath(String seoFriendlyPath) {
        this.seoFriendlyPath = seoFriendlyPath;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<SubUnit> getSubUnits() {
        return subUnits;
    }

    public void setSubUnits(List<SubUnit> subUnits) {
        this.subUnits = subUnits;
    }

    public Instant getSimplePublishDate() {
        return simplePublishDate;
    }

    public void setSimplePublishDate(long publishDate) {
        this.simplePublishDate = Instant.ofEpochMilli(publishDate);
    }


    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", abbreviatedPrice='" + abbreviatedPrice + '\'' +
                ", numBedrooms='" + numBedrooms + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", saleType='" + saleType + '\'' +
                ", berRating='" + berRating + '\'' +
                ", publishDate=" + publishDate +
                ", simplePublishDate=" + simplePublishDate +
                ", seoFriendlyPath='" + seoFriendlyPath + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", images=" + images +
                ", subUnits=" + subUnits +
                '}';
    }
}
