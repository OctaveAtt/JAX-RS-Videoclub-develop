package com.videoclub;

import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.*;
import com.videoclub.dao.entity.*;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDate;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MovieDao dao = DaoFactory.getMovieDao();
        dao.save(new Movie("La ligne verte", 188, LocalDate.ofYearDay(1999, 1),3));
        dao.save(new Movie("Le parrain", 175, LocalDate.ofYearDay(1972, 1),4));
        dao.save(new Movie("H2G2 ", 109, LocalDate.ofYearDay(2005, 1),5));
        dao.save(new Movie("Que justice soit faite", 104, LocalDate.ofYearDay(2009, 1),6));
        dao.save(new Movie("Les affranchis", 146, LocalDate.ofYearDay(1990, 1),2));
        dao.save(new Movie("Metropolis", 153, LocalDate.ofYearDay(1927, 1),5));
        dao.save(new Movie("Blade Runner 2049", 163, LocalDate.ofYearDay(2017, 1),56));
        dao.save(new Movie("Princesse Mononoké", 133, LocalDate.ofYearDay(1997, 1),32));
        dao.save(new Movie("Transformers", 224, LocalDate.ofYearDay(2007, 1),12));

        VideoGameDao videoGameDao = DaoFactory.getVideoGameDao();

        videoGameDao.save(new VideoGame("SpiderMan","Insomniac",LocalDate.ofYearDay(2020,1),4));

        UserDao userDao = DaoFactory.getUserDao();
        User remy = new User("Remy","L",22,"fe",543,"remyl@gmail.com");
        userDao.save(remy);


        AlbumDao albumDao = DaoFactory.getAlbumDao();
        albumDao.save(new Album("La BoiTape",LocalDate.ofYearDay(2021,11),"BoiGang",50,21));

        LocationDao locationDao = DaoFactory.getLocationDao();
        locationDao.save(new Location(remy,LocalDate.ofYearDay(2022,3)));
    }
}
