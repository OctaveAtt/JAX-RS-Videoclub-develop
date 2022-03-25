package com.videoclub.dao;

import com.videoclub.dao.base.MovieDao;
import com.videoclub.dao.base.VideoGameDao;
import com.videoclub.dao.entity.Movie;
import com.videoclub.dao.entity.VideoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryVideoGameDao implements VideoGameDao {

    private static Long idSequence = 0L;
    private static List<VideoGame> videoGames = new ArrayList<>();

    @Override
    public Long save(VideoGame videoGame) {
        videoGame.setId(++idSequence);
        videoGames.add(videoGame);
        return videoGame.getId();
    }

    @Override
    public List<VideoGame> findAll() {
        return Collections.unmodifiableList(videoGames);
    }

    @Override
    public Optional<VideoGame> findById(Long id) {
        return this.videoGames.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(VideoGame videoGameToUpdate) {
        boolean isUpdate = false;
        List<VideoGame> tempList = new ArrayList<>();
        for (VideoGame vM : videoGames) {
            if (vM.getId() == videoGameToUpdate.getId()) {
                vM = videoGameToUpdate;
                isUpdate = true;
            }
            tempList.add(vM);
        }
        videoGames = tempList;
        return isUpdate;
    }

    @Override
    public void delete(Long id) {
        this.videoGames = this.videoGames
                .stream()
                .filter(v -> v.getId() != id)
                .collect(Collectors.toList());
    }

    public void delete(Movie movie){
        videoGames.remove(movie);
    }
}
