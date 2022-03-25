package com.videoclub.service;

import com.videoclub.controller.model.responses.MovieResponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.MovieDao;
import com.videoclub.dao.entity.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    public List<MovieResponse> fetchAll() {
        MovieDao movieDao = DaoFactory.getMovieDao();

        return movieDao
                .findAll()
                .stream()
                .map(Movie::toDto)
                .collect(Collectors.toList());
    }

    public boolean update(Long id, Movie movie) {
        MovieDao movieDao = DaoFactory.getMovieDao();
        return movieDao.update(movie);
    }
}
