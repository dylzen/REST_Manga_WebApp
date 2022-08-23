package com.demo.manga.service;
 
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
/*
 * 	The @Path annotation defines the relative URL that forms the URI that identifies a resource.
 * 	You can use this annotation on both class level or method level.
 */
@Path("/bonjour")
public class MangaBonjour {
	
	/*
	 * 	The @GET annotation specifies that the annotated method, direBonjour() handles HTTP GET request. 
	 * 	Jersey provides annotations corresponding to HTTP methods: @POST, @PUT, @DELETE…
	 * 	The @Produces annotation specifies the content type of the response, which is text plain in our code. 
	 * 	You can also specify text/xml, text/html, JSON, etc.
	 */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String direBonjour() {
        return "Bonjour, tout le MANGA -> TEXT_PLAIN!";
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHTMLHello() {
        return "<html><title>Hello</title><body><h1>Bonjour, tout le MANGA -> TEXT_HTML!</h1><body></html>";
        /* 
         * 	The browser now shows the HTML response sent from the web service 
         * 	(a web browser always expects Text/HTML response). 
         * 	That means with the same URI, the response representation can be different,
         *  depending on content type accepted by the clients. 
         */
    }
    /*
     *  Produce una response JSON 
     *  (la pagina non cambia perché il browser non si aspetta una response JSON di default).
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayJsonHello() {
        return "{\"name\":\"greeting\", \"message\":\"Bonjour tout le monde!\"}";
    }
}