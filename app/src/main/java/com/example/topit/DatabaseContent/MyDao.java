package com.example.topit.DatabaseContent;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


@Dao
public interface MyDao {

    @Update
     void updateUser(UserInfo userInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createUser(UserInfo userInfo);

    @Query("select * from user where id = :userId")
    UserInfo getUser(String userId);

    @Query("delete  from user")
    void deleteAll();








}
