package com.videoclub.service;

import com.videoclub.controller.model.responses.AlbumResponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.AlbumDao;
import com.videoclub.dao.entity.Album;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumService {

    public List<AlbumResponse> fetchAll() {
        AlbumDao albumDao = DaoFactory.getAlbumDao();

        return albumDao
                .findAll()
                .stream()
                .map(Album::toDto)
                .collect(Collectors.toList());
    }

    public boolean update(Long id, Album album) {
        AlbumDao albumDao = DaoFactory.getAlbumDao();
        return albumDao.update(album);
    }
}
