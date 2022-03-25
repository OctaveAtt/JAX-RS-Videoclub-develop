package com.videoclub.controller;

import com.videoclub.controller.model.creates.CreateAlbum;
import com.videoclub.controller.model.responses.AlbumResponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.AlbumDao;
import com.videoclub.dao.entity.Album;
import com.videoclub.service.AlbumService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.List;


@Path("/albums")
public class AlbumController {

    @Inject
    AlbumService albumService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<AlbumResponse> albumReponses = albumService.fetchAll();
        return Response.ok(albumReponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateAlbum createAlbum) {
        Album album = new Album(createAlbum.getTitle(), createAlbum.getReleaseDate(), createAlbum.getArtist(),createAlbum.getDuration(),createAlbum.getQuantity());
        AlbumDao albumDao = DaoFactory.getAlbumDao();
        albumDao.save(album);
        return Response.status(201).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id){
        AlbumDao albumDao = DaoFactory.getAlbumDao();
        albumDao.delete(id);
        return Response.status(201).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateAlbum(@PathParam("id") Long id,
                                @FormParam("title") String title,
                                @FormParam("duration") double duration,
                                @FormParam("artist") String artist,
                                @FormParam("quantity") int quantity,
                                @FormParam("releasedDate") String releasedDateStr) {

        LocalDate releasedDate = LocalDate.now(); // from releasedDateStr
        Album album = new Album(title, releasedDate, artist,duration,quantity);
        boolean isUpdated = albumService.update(id, album);

        if (isUpdated) {
            return Response.noContent().build();
        } else {
            return Response.notModified().build();
        }

    }


}
