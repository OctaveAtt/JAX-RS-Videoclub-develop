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

        UserDao userDao = DaoFactory.getUserDao();
        User vbk = new User("vbk","aa",40,"aa",43243,"aa");
        userDao.save(vbk);
        userDao.save(new User("21","bb",4,"bb",4343,"bb"));
        User cc =new User("22","cc",55,"cc",43214,"cc");
        userDao.save(cc);

        AlbumDao albumDao = DaoFactory.getAlbumDao();
        albumDao.save(new Album("thriller de michael jackson", LocalDate.ofYearDay(1983, 1),"ed",6, 5));
        albumDao.save(new Album("No.6 Collaboration Project", LocalDate.ofYearDay(2016, 1),"Phil",50 , 5));
        albumDao.save(new Album("Loose Change", LocalDate.ofYearDay(2011, 1),"Nao",32, 5));

        VideoGameDao videoGameDao = DaoFactory.getVideoGameDao();

        videoGameDao.save(new VideoGame("SpiderMan","Insomniac",LocalDate.ofYearDay(2020,1),4));


        User fre = new User("FZ","L",22,"fe",543,"fzl@gmail.com");
        userDao.save(fre);



        albumDao.save(new Album("La BoiTape",LocalDate.ofYearDay(2021,11),"BoiGang",50,21));

        LocationDao locationDao = DaoFactory.getLocationDao();
        locationDao.save(new Location(fre,LocalDate.ofYearDay(2022,3)));
        locationDao.save(new Location(vbk,LocalDate.ofYearDay(2020,2)));
        locationDao.save(new Location(cc,LocalDate.ofYearDay(2020,2)));
    }
}
