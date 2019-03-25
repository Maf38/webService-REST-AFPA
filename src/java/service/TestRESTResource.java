/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author gai
 */
@Path("testREST")
public class TestRESTResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TestRESTResource
     */
    public TestRESTResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        return "<bonjour>Hello World! </bonjour>";
    }
    
    @Path("hello/{msg}")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String hello(@PathParam ("msg")String msg){
        return "Bonjour inconnu. ton message est: "+ msg;
    }

    /**
     * PUT method for updating or creating an instance of RestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
