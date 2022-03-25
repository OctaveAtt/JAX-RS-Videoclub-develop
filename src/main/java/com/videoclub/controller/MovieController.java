package com.videoclub.controller;

import com.videoclub.controller.model.creates.CreateMovie;
import com.videoclub.controller.model.responses.MovieResponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.MovieDao;
import com.videoclub.dao.entity.Movie;
import com.videoclub.service.MovieService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.List;


@Path("/movies")
public class MovieController {

    @Inject
    MovieService movieService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<MovieResponse> movieReponses = movieService.fetchAll();
        return Response.ok(movieReponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateMovie createMovie) {
        Movie movie = new Movie(createMovie.getTitle(), createMovie.getDuration(), createMovie.getReleaseDate(),createMovie.getQuantity());
        MovieDao movieDao = DaoFactory.getMovieDao();
        movieDao.save(movie);
        return Response.status(201).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id){
        MovieDao movieDao = DaoFactory.getMovieDao();
        movieDao.delete(id);
        return Response.status(201).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateMovie(@PathParam("id") Long id,
                                @FormParam("title") String title,
                                @FormParam("duration") double duration,
                                @FormParam("quantity") int quantity,
                                @FormParam("releasedDate") String releasedDateStr) {

        LocalDate releasedDate = LocalDate.now(); // from releasedDateStr
        Movie movie = new Movie(title, duration, releasedDate,quantity);
        boolean isUpdated = movieService.update(id, movie);

        if (isUpdated) {
            return Response.noContent().build();
        } else {
            return Response.notModified().build();
        }

    }


}
