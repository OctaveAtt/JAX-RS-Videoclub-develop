package com.videoclub.service;

import com.videoclub.controller.model.responses.VideoGameResponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.VideoGameDao;
import com.videoclub.dao.entity.VideoGame;

import java.util.List;
import java.util.stream.Collectors;

public class VideoGameService {

    public List<VideoGameResponse> fetchAll() {
        VideoGameDao videoGameDao = DaoFactory.getVideoGameDao();

        return videoGameDao
                .findAll()
                .stream()
                .map(VideoGame::toDto)
                .collect(Collectors.toList());
    }

    public boolean update(Long id, VideoGame videoGame) {
        VideoGameDao videoGameDao = DaoFactory.getVideoGameDao();
        return videoGameDao.update(videoGame);
    }
}
