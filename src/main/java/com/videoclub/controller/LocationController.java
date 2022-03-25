package com.videoclub.controller;

import com.videoclub.controller.model.creates.CreateLocation;
import com.videoclub.controller.model.responses.LocationResponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.LocationDao;
import com.videoclub.dao.entity.Location;
import com.videoclub.dao.entity.User;
import com.videoclub.service.LocationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.List;


@Path("/locations")
public class LocationController {

    @Inject
    LocationService locationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<LocationResponse> locationReponses = locationService.fetchAll();
        return Response.ok(locationReponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateLocation createLocation) {
        Location location = new Location(createLocation.getLoaner(),createLocation.getLocalDate());
        LocationDao locationDao = DaoFactory.getLocationDao();
        locationDao.save(location);
        return Response.status(201).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id){
        LocationDao locationDao = DaoFactory.getLocationDao();
        locationDao.delete(id);
        return Response.status(201).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateLocation(@PathParam("id") Long id,
                                @FormParam("loaner") User loaner,
                                @FormParam("localDate") String releasedDateStr) {

        LocalDate releasedDate = LocalDate.now(); // from releasedDateStr
        Location location = new Location(loaner,releasedDate);
        boolean isUpdated = locationService.update(id, location);

        if (isUpdated) {
            return Response.noContent().build();
        } else {
            return Response.notModified().build();
        }

    }


}
