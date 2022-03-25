package com.videoclub.service;

import com.videoclub.controller.model.responses.LocationResponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.LocationDao;
import com.videoclub.dao.entity.Location;

import java.util.List;
import java.util.stream.Collectors;

public class LocationService {

    public List<LocationResponse> fetchAll() {
        LocationDao locationDao = DaoFactory.getLocationDao();

        return locationDao
                .findAll()
                .stream()
                .map(Location::toDto)
                .collect(Collectors.toList());
    }

    public boolean update(Long id, Location location) {
        LocationDao locationDao = DaoFactory.getLocationDao();
        return locationDao.update(location);
    }
}
