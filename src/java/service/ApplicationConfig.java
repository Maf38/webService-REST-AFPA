/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author gai
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entite.service.AeroportFacadeREST.class);
        resources.add(entite.service.AffectationFacadeREST.class);
        resources.add(entite.service.AvionFacadeREST.class);
        resources.add(entite.service.ConstructeurFacadeREST.class);
        resources.add(entite.service.PiloteFacadeREST.class);
        resources.add(entite.service.TypeFacadeREST.class);
        resources.add(entite.service.VolFacadeREST.class);
        resources.add(service.TestRESTResource.class);
    }
    
}
