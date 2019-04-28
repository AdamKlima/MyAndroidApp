package com.example.topit.DatabaseContent;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class Repository {
    private MyAppDatabase myAppDatabase;
    private MyDao myDao;

    public Repository(Context context) {
        myAppDatabase = MyAppDatabase.getInstance(context);
        myDao = myAppDatabase.myDao();
    }

    public void createUser(UserInfo userInfo){
        new InsertUserAsyncTask(userInfo).execute();

    }

    public void updateUser(UserInfo userInfo){
        new UpdateUserAsyncTask(userInfo).execute();
    }

    public UserInfo getUser(String id){
        return myDao.getUser(id);
    }

    public void updateUserName(String id, String name) {
        new UpdateUserNameAsyncTask(id, name).execute();
    }

    public void updateUserHeight(String id, String height){
        new UpdateUserHeightAsyncTask(id, height).execute();
    }
    public void updateUserWeight(String id, String weight){
        new UpdateUserWeightAsyncTask(id, weight).execute();
    }
    public void updateUserBodyFat(String id, String bodyFat){
        new UpdateUserBodyFatAsyncTask(id,bodyFat).execute();
    }
    public void updateUserBicep(String id, String bicep){
        new UpdateUserBicepAsyncTask(id, bicep).execute();
    }
    public void updateUserForearm(String id, String forearm){
        new UpdateUserForearmAsyncTask(id, forearm).execute();
    }
    public void updateUserChest(String id, String chest){
        new UpdateUserChestAsyncTask(id, chest).execute();
    }
    public void updateUserWaist(String id, String chest){
        new UpdateUserWaistAsyncTask(id, chest).execute();
    }
    public void updateUserThigh(String id, String thigh){
        new UpdateUserThightAsyncTask(id,thigh).execute();
    }
    public void updateUserCalves(String id,String calves){
        new UpdateUserCalvesAsyncTask(id,calves).execute();
    }


    class InsertUserAsyncTask extends AsyncTask<Void,Void,Void> {

        private UserInfo userInfo;

        public InsertUserAsyncTask(UserInfo userInfo){
            this.userInfo = userInfo;
        }

         @Override
         protected Void doInBackground(Void... voids) {
             myDao.createUser(userInfo);
             return null;
         }


     }

     class UpdateUserAsyncTask extends  AsyncTask<Void,Void,Void>{
         private UserInfo userInfo;


         public UpdateUserAsyncTask(UserInfo userInfo){
             this.userInfo = userInfo;
         }

         @Override
         protected Void doInBackground(Void... voids) {
             myDao.updateUser(userInfo);
             return  null;
         }


     }

    class UpdateUserNameAsyncTask extends  AsyncTask<Void,Void,Void>{

        private final String userId;
        private final String name;
        private UserInfo userInfo;


        public UpdateUserNameAsyncTask(String userId, String name){
            this.userId = userId;
            this.name = name;
            this.userInfo = userInfo;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("update", "update name async");
            UserInfo user = myDao.getUser(userId);
            user.setName(name);
            myDao.updateUser(user);
            return  null;
        }


    }
    class UpdateUserHeightAsyncTask extends  AsyncTask<Void,Void,Void>{

        private final String userId;
        private final String height;
        private UserInfo userInfo;


        public UpdateUserHeightAsyncTask(String userId, String height){
            this.userId = userId;
            this.height = height;
            this.userInfo = userInfo;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("update", "update height async");
            UserInfo user = myDao.getUser(userId);
            user.setHeight(height);
            myDao.updateUser(user);
            return  null;
        }


    }
    class UpdateUserWeightAsyncTask extends  AsyncTask<Void,Void,Void>{

        private final String userId;
        private final String weight;
        private UserInfo userInfo;


        public UpdateUserWeightAsyncTask(String userId, String weight){
            this.userId = userId;
            this.weight = weight;
            this.userInfo = userInfo;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("update", "update weight async");
            UserInfo user = myDao.getUser(userId);
            user.setWeight(weight);
            myDao.updateUser(user);
            return  null;
        }


    }
    class UpdateUserBodyFatAsyncTask extends  AsyncTask<Void,Void,Void>{

        private final String userId;
        private final String bodyFat;
        private UserInfo userInfo;


        public UpdateUserBodyFatAsyncTask(String userId, String bodyFat){
            this.userId = userId;
            this.bodyFat = bodyFat;
            this.userInfo = userInfo;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("update", "update body fat async");
            UserInfo user = myDao.getUser(userId);
            user.setBodyFat(bodyFat);
            myDao.updateUser(user);
            return  null;
        }


    }
    class UpdateUserBicepAsyncTask extends  AsyncTask<Void,Void,Void>{

        private final String userId;
        private final String bicep;
        private UserInfo userInfo;


        public UpdateUserBicepAsyncTask(String userId, String bicep){
            this.userId = userId;
            this.bicep = bicep;
            this.userInfo = userInfo;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("update", "update bicep async");
            UserInfo user = myDao.getUser(userId);
            user.setBicep(bicep);
            myDao.updateUser(user);
            return  null;
        }


    }
    class UpdateUserForearmAsyncTask extends  AsyncTask<Void,Void,Void>{

        private final String userId;
        private final String forearm;
        private UserInfo userInfo;


        public UpdateUserForearmAsyncTask(String userId, String forearm){
            this.userId = userId;
            this.forearm = forearm;
            this.userInfo = userInfo;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("update", "update bicep async");
            UserInfo user = myDao.getUser(userId);
            user.setForearm(forearm);
            myDao.updateUser(user);
            return  null;
        }


    }
    class UpdateUserChestAsyncTask extends  AsyncTask<Void,Void,Void>{

        private final String userId;
        private final String chest;
        private UserInfo userInfo;


        public UpdateUserChestAsyncTask(String userId, String chest){
            this.userId = userId;
            this.chest = chest;
            this.userInfo = userInfo;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("update", "update chest async");
            UserInfo user = myDao.getUser(userId);
            user.setChest(chest);
            myDao.updateUser(user);
            return  null;
        }


    }
    class UpdateUserWaistAsyncTask extends  AsyncTask<Void,Void,Void>{

        private final String userId;
        private final String waist;
        private UserInfo userInfo;


        public UpdateUserWaistAsyncTask(String userId, String waist){
            this.userId = userId;
            this.waist = waist;
            this.userInfo = userInfo;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("update", "update waist async");
            UserInfo user = myDao.getUser(userId);
            user.setWaist(waist);
            myDao.updateUser(user);
            return  null;
        }


    }
    class UpdateUserThightAsyncTask extends  AsyncTask<Void,Void,Void>{

        private final String userId;
        private final String thigh;
        private UserInfo userInfo;


        public UpdateUserThightAsyncTask(String userId, String thigh){
            this.userId = userId;
            this.thigh = thigh;
            this.userInfo = userInfo;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("update", "update thigh async");
            UserInfo user = myDao.getUser(userId);
            user.setThighs(thigh);
            myDao.updateUser(user);
            return  null;
        }


    }
    class UpdateUserCalvesAsyncTask extends  AsyncTask<Void,Void,Void>{

        private final String userId;
        private final String calves;
        private UserInfo userInfo;


        public UpdateUserCalvesAsyncTask(String userId, String calves){
            this.userId = userId;
            this.calves = calves;
            this.userInfo = userInfo;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("update", "update calves async");
            UserInfo user = myDao.getUser(userId);
            user.setCalves(calves);
            myDao.updateUser(user);
            return  null;
        }


    }


}
