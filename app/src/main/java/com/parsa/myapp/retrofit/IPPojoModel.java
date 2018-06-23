
package com.parsa.myapp.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IPPojoModel {

    @SerializedName("as")
    @Expose
    private String as;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("isp")
    @Expose
    private String isp;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("org")
    @Expose
    private String org;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("regionName")
    @Expose
    private String regionName;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("zip")
    @Expose
    private String zip;

    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }

    public IPPojoModel withAs(String as) {
        this.as = as;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public IPPojoModel withCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public IPPojoModel withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public IPPojoModel withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public IPPojoModel withIsp(String isp) {
        this.isp = isp;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public IPPojoModel withLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public IPPojoModel withLon(Double lon) {
        this.lon = lon;
        return this;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public IPPojoModel withOrg(String org) {
        this.org = org;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public IPPojoModel withQuery(String query) {
        this.query = query;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public IPPojoModel withRegion(String region) {
        this.region = region;
        return this;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public IPPojoModel withRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public IPPojoModel withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public IPPojoModel withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public IPPojoModel withZip(String zip) {
        this.zip = zip;
        return this;
    }

}
