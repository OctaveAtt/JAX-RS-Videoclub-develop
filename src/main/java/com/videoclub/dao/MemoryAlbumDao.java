package com.videoclub.dao;


import com.videoclub.dao.base.AlbumDao;
import com.videoclub.dao.entity.Album;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryAlbumDao implements AlbumDao {

    private static Long idSequence = 0L;
    private static List<Album> albums = new ArrayList<>();

    @Override
    public Long save(Album album) {
        album.setId(++idSequence);
        albums.add(album);
        return album.getId();
    }

    @Override
    public List<Album> findAll() {
        return Collections.unmodifiableList(albums);
    }

    @Override
    public Optional<Album> findById(Long id) {
        return this.albums.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(Album albumToUpdate) {
        boolean isUpdate = false;
        List<Album> tempList = new ArrayList<>();
        for (Album u : albums) {
            if (u.getId() == albumToUpdate.getId()) {
                u = albumToUpdate;
                isUpdate = true;
            }
            tempList.add(u);
        }
        albums = tempList;
        return isUpdate;
    }

    @Override
    public void delete(Long id) {
        this.albums = this.albums
                .stream()
                .filter(movie -> movie.getId() != id)
                .collect(Collectors.toList());
    }

    public void delete(Album album){
        albums.remove(album);
    }
}
