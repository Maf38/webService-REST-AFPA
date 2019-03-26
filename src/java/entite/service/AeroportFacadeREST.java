/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite.service;

import com.google.gson.Gson;
import entite.Aeroport;
import entite.Vol;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author gai
 */
@Stateless
@Path("entite.aeroport")
public class AeroportFacadeREST extends AbstractFacade<Aeroport> {

    @PersistenceContext(unitName = "serviceRESTPU")
    private EntityManager em;

    public AeroportFacadeREST() {
        super(Aeroport.class);
    }

    @POST
    @Override
    @Consumes({ MediaType.APPLICATION_JSON})
    public void create(Aeroport entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Aeroport entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Aeroport find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Aeroport> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Aeroport> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("testProcEJB")
    @Produces(MediaType.APPLICATION_JSON)
     public String  getAllAeroport() {
        String ejbql = "select v.numVol From Vol v JOIN v.aeroportDept a where a.nomVilleDesservie ='Bastia'";
        Collection<String> lesAeroports;
        String json="";
        try {
            Query query = em.createQuery(ejbql);
            
            lesAeroports = (Collection<String>) query.getResultList();
          
          json= new Gson().toJson(lesAeroports);
        }
        catch(Exception ex){
        
          
            System.out.println("Exception JPQL" + ex.getMessage());
        }
        return json;
    }
   
    @GET
    @Path("listeVol/{ville}")
    @Produces(MediaType.APPLICATION_JSON)
     public String  getAllAeroportFull(@PathParam ("ville") String ville) {
        String ejbql = "select v From Vol v JOIN v.aeroportDept a where a.nomVilleDesservie = :town";
        List<Vol> lesAeroports;
        String json="";
        try {
            Query query = em.createQuery(ejbql);
            query.setParameter("town", ville);
            lesAeroports = (List<Vol>) query.getResultList();
          
            Gson outils = new Gson();
            json = outils.toJson(lesAeroports);
           System.out.println(json);
        }
        catch(Exception ex){
        
          
            System.out.println("Exception JPQL" + ex.getMessage());
        }
        return json;
    }
   
     
     
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
