/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Actor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import session.ActorManager;

/**
 *
 * @author HP
 */
@Named(value = "actorMBean")
@SessionScoped
public class ActorMBean implements Serializable {

    @EJB
    private ActorManager actorManager;

    /**
     * Creates a new instance of ActorMBean
     */
    
    private Actor actor; //para mostrar, actualiar e insertar en un formulario
    private List<Actor> actors; //Para desplegarlos en la base de datos
    
    public ActorMBean() {
    }
    
    public List<Actor> getActor(){
        if ((actors == null)||(actors.isEmpty()))  refresh();
        return actors;
    }

    private void refresh() {
        //tousLesComptes = compteBancaireFacade.findAll();
    }
    
    public Actor getDetails(){
        return actor;
    }
    
    public String gshowDetails(Actor actor){
        this.actor = actor;
        return "ActorDetails";//Se desplegará ActorDetails.xml JSF page
    }
    
    public String update(){
        System.out.println("###UPDATE###");
        actor = actorManager.update(actor);
        return "ActorList";//Se desplegará CustomerDetails.xml JSF page
    }
    
    public String list(){
        System.out.println("###LIST###");
        return "ActorList";//Se desplegará CustomerDetails.xml JSF page
    }
}
