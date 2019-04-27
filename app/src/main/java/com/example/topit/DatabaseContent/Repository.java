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

}
