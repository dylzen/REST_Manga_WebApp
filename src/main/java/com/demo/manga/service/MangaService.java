package com.demo.manga.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demo.manga.dao.MangaDAO;
import com.demo.manga.model.Manga;


@Path("/mangaseries")
public class MangaService {
	// URI:
    // /contextPath/servletPath/series
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Manga> getSeries_JSON() {
        List<Manga> series = MangaDAO.findAllManga();
        return series;
    }
    
    // URI:
    // /contextPath/servletPath/Mangas/{manga_series_id}
    @GET
    @Path("/{manga_series_id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Manga getManga(@PathParam("manga_series_id") int manga_series_id) {
        return MangaDAO.findMangaByMangaID(manga_series_id);
    }

    // URI:
    // /contextPath/servletPath/Mangas
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void addManga(Manga manga) {
        MangaDAO.createMangaRecord(manga);
    }

    // URI:
    // /contextPath/servletPath/Mangas
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Manga updateManga(Manga manga) {
        return MangaDAO.updateMangaByID(manga);
    }

    @DELETE
    @Path("/{manga_series_id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteManga(@PathParam("manga_series_id") int manga_series_id) {
        MangaDAO.deleteMangaByID(manga_series_id);
    }
    
    
}
