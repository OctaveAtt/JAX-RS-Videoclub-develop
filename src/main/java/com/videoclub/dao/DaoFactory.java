package com.videoclub.dao;

import com.videoclub.dao.base.*;

import java.time.LocalDate;


public final class DaoFactory {

    private DaoFactory() {
    }

    public static MovieDao getMovieDao(){
        return new MemoryMovieDao();
    }

    public static AlbumDao getAlbumDao(){
        return new MemoryAlbumDao();
    }

    public static UserDao getUserDao(){
        return new MemoryUserDao();
    }

    public static LocationDao getLocationDao(){
        return new MemoryLocationDao();
    }

    public static VideoGameDao getVideoGameDao(){
        return new MemoryVideoGameDao();
    }
}
