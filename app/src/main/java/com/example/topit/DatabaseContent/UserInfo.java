package com.example.topit.DatabaseContent;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user")
public class UserInfo {

    @PrimaryKey
    @NonNull
    private String id;
    private String height;
    private String name;
    private String weight;
    private String bodyFat;
    private String bicep;
    private String forearm;
    private String chest;
    private String waist;
    private String thighs;
    private String calves;


    public UserInfo(String id, String height, String name, String weight, String bodyFat, String bicep, String forearm, String chest, String waist, String thighs, String calves) {
        this.id = id;
        this.height = height;
        this.name = name;
        this.weight = weight;
        this.bodyFat = bodyFat;
        this.bicep = bicep;
        this.forearm = forearm;
        this.chest = chest;
        this.waist = waist;
        this.thighs = thighs;
        this.calves = calves;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String wight) {
        this.weight = wight;
    }

    public String getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(String bodyFat) {
        this.bodyFat = bodyFat;
    }

    public String getBicep() {
        return bicep;
    }

    public void setBicep(String bicep) {
        this.bicep = bicep;
    }

    public String getForearm() {
        return forearm;
    }

    public void setForearm(String forearm) {
        this.forearm = forearm;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getThighs() {
        return thighs;
    }

    public void setThighs(String thighs) {
        this.thighs = thighs;
    }

    public String getCalves() {
        return calves;
    }

    public void setCalves(String calves) {
        this.calves = calves;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", height='" + height + '\'' +
                ", name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", bodyFat='" + bodyFat + '\'' +
                ", bicep='" + bicep + '\'' +
                ", forearm='" + forearm + '\'' +
                ", chest='" + chest + '\'' +
                ", waist='" + waist + '\'' +
                ", thighs='" + thighs + '\'' +
                ", calves='" + calves + '\'' +
                '}';
    }
}
