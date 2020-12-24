package com.vladimir.myapplication.Model;

import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("lang_id")
    private int lang_id;

    @SerializedName("cityID")
    private int cityID;

    @SerializedName("stateID")
    private int stateID;

    @SerializedName("name")
    private String name;

    @SerializedName("eng")
    private String eng;

    @SerializedName("declension")
    private String declension;

    @SerializedName("translit")
    private String translit;

    @SerializedName("preview_img")
    private String preview_img;

    public City(int lang_id, int cityID, int stateID, String name, String eng, String declension, String translit, String preview_img) {
        this.lang_id = lang_id;
        this.cityID = cityID;
        this.stateID = stateID;
        this.name = name;
        this.eng = eng;
        this.declension = declension;
        this.translit = translit;
        this.preview_img = preview_img;
    }

    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getDeclension() {
        return declension;
    }

    public void setDeclension(String declension) {
        this.declension = declension;
    }

    public String getTranslit() {
        return translit;
    }

    public void setTranslit(String translit) {
        this.translit = translit;
    }

    public String getPreview_img() {
        return preview_img;
    }

    public void setPreview_img(String preview_img) {
        this.preview_img = preview_img;
    }
}
