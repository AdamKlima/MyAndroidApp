package com.example.topit.DatabaseContent;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

@Database(entities = {UserInfo.class}, version = 2)
public abstract class MyAppDatabase extends RoomDatabase {

    private static MyAppDatabase INSTANCE;

    public abstract MyDao myDao();

    public static MyAppDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized (MyAppDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyAppDatabase.class, "myDB")
                        .addCallback(new RoomDatabase.Callback(){
                            public void onCreate(SupportSQLiteDatabase db){
                                super.onCreate(db);
                                new Populate(INSTANCE).execute();
                            }


                        }).build();
            }
        }
        return INSTANCE;
    }

    static class Populate extends AsyncTask<Void, Void, Void>{
        private MyAppDatabase myAppDatabase;

        public Populate(MyAppDatabase db){
            this.myAppDatabase = db;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            MyDao myDao = myAppDatabase.myDao();
            myDao.deleteAll();
            UserInfo userInfo = new UserInfo( "F1N9ZvCh0MfObAzwNEsOzaaaYqL2","-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
            myDao.createUser(userInfo);
            Log.d("update", myDao.getUser("F1N9ZvCh0MfObAzwNEsOzaaaYqL2").toString());

            return null;

        }
    }
}
