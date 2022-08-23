package com.demo.manga.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    
    
}
