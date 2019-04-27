package com.example.topit.DatabaseContent;

import android.arch.lifecycle.LiveData;
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

}
