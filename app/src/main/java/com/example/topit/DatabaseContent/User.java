package com.example.topit.DatabaseContent;

public class User {
    String userId;
  public    String userName;
    String userHeight;
    String userWeight;
    String userBodyFat;
    String userBicep;
    String userForearm;
    String userChest;
    String userWaist;
    String userThighs;
    String userCalves;

    public User(){

    }

    public User(String userId, String userName, String userHeight, String userWeight, String userBodyFat, String userBicep, String userForearm, String userChest, String userWaist, String userThighs, String userCalves) {
        this.userId = userId;
        this.userName = userName;
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.userBodyFat = userBodyFat;
        this.userBicep = userBicep;
        this.userForearm = userForearm;
        this.userChest = userChest;
        this.userWaist = userWaist;
        this.userThighs = userThighs;
        this.userCalves = userCalves;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserHeight() {
        return userHeight;
    }

    public String getUserWeight() {
        return userWeight;
    }

    public String getUserBodyFat() {
        return userBodyFat;
    }

    public String getUserBicep() {
        return userBicep;
    }

    public String getUserForearm() {
        return userForearm;
    }

    public String getUserChest() {
        return userChest;
    }

    public String getUserWaist() {
        return userWaist;
    }

    public String getUserThighs() {
        return userThighs;
    }

    public String getUserCalves() {
        return userCalves;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserHeight(String userHeight) {
        this.userHeight = userHeight;
    }

    public void setUserWeight(String userWeight) {
        this.userWeight = userWeight;
    }

    public void setUserBodyFat(String userBodyFat) {
        this.userBodyFat = userBodyFat;
    }

    public void setUserBicep(String userBicep) {
        this.userBicep = userBicep;
    }

    public void setUserForearm(String userForearm) {
        this.userForearm = userForearm;
    }

    public void setUserChest(String userChest) {
        this.userChest = userChest;
    }

    public void setUserWaist(String userWaist) {
        this.userWaist = userWaist;
    }

    public void setUserThighs(String userThighs) {
        this.userThighs = userThighs;
    }

    public void setUserCalves(String userCalves) {
        this.userCalves = userCalves;
    }
}
