package com.sbproject.calendar.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Administrator on 2017-11-10.
 */

@Dao
public interface DataDao {
    @Query("select * from data where userseq like :userseq and year like :year and weekofyear like :weekofyear order by day")
    List<Data> selectWeekOfYear(int userseq, int year, int weekofyear);

    @Query("delete from data where year like :year and weekofyear like :weekofyear and day like :day")
    void deleteDay(int year, int weekofyear, int day);

    @Query("delete from data where seq like :seq and year like :year and weekofyear like :weekofyear and day like :day")
    void deleteDay(int seq, int year, int weekofyear, int day);

    @Insert
    void insert(Data data);

    @Delete
    void delete(Data data);
}