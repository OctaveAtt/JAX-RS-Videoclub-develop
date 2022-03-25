package com.videoclub.controller;

import com.videoclub.controller.model.creates.CreateVideoGame;
import com.videoclub.controller.model.responses.VideoGameResponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.VideoGameDao;
import com.videoclub.dao.entity.VideoGame;
import com.videoclub.service.VideoGameService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.List;


@Path("/videoGames")
public class VideoGamesController {

    @Inject
    VideoGameService videoGameService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<VideoGameResponse> videoGameReponses = videoGameService.fetchAll();
        return Response.ok(videoGameReponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateVideoGame createVideoGame) {
        VideoGame videoGame = new VideoGame(createVideoGame.getTitle(),createVideoGame.getEditor(), createVideoGame.getReleasedDate(),createVideoGame.getQuantity());
        VideoGameDao videoGameDao = DaoFactory.getVideoGameDao();
        videoGameDao.save(videoGame);
        return Response.status(201).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id){
        VideoGameDao videoGameDao = DaoFactory.getVideoGameDao();
        videoGameDao.delete(id);
        return Response.status(201).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateVideoGame(@PathParam("id") Long id,
                                @FormParam("title") String title,
                                @FormParam("editor") String editor,
                                @FormParam("quantity") int quantity,
                                @FormParam("releasedDate") String releasedDateStr) {

        LocalDate releasedDate = LocalDate.now(); // from releasedDateStr
        VideoGame videoGame = new VideoGame(title, editor, releasedDate,quantity);
        boolean isUpdated = videoGameService.update(id, videoGame);

        if (isUpdated) {
            return Response.noContent().build();
        } else {
            return Response.notModified().build();
        }

    }


}
