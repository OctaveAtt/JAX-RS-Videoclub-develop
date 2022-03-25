package com.videoclub.dao;


import com.videoclub.dao.base.LocationDao;
import com.videoclub.dao.entity.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryLocationDao implements LocationDao {

    private static Long idSequence = 0L;
    private static List<Location> locations = new ArrayList<>();

    @Override
    public Long save(Location location) {
        location.setId(++idSequence);
        locations.add(location);
        return location.getId();
    }

    @Override
    public List<Location> findAll() {
        return Collections.unmodifiableList(locations);
    }

    @Override
    public Optional<Location> findById(Long id) {
        return this.locations.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(Location locationToUpdate) {
        boolean isUpdate = false;
        List<Location> tempList = new ArrayList<>();
        for (Location u : locations) {
            if (u.getId() == locationToUpdate.getId()) {
                u = locationToUpdate;
                isUpdate = true;
            }
            tempList.add(u);
        }
        locations = tempList;
        return isUpdate;
    }

    @Override
    public void delete(Long id) {
        this.locations = this.locations
                .stream()
                .filter(movie -> movie.getId() != id)
                .collect(Collectors.toList());
    }

    public void delete(Location location){
        locations.remove(location);
    }
}
