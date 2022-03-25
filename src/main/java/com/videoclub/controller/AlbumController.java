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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Album album) {
        boolean isUpdate = DaoFactory.getAlbumDao().update(album);
        if (isUpdate) return Response.status(204).build();
        return Response.status(404)
                .entity("Le film ne peut pas être mise à jour car la ressource n'existe pas")
                .build();
    }


}
