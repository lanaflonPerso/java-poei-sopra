package org.eclipse.ressource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

@Path("personnes")
public class PersonneResource {

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Personne> getPersonnes() {
		PersonneDaoImpl daop = new PersonneDaoImpl();
		List<Personne> personnes = daop.getAll();
		return personnes;
	}

	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void createPersonne(Personne personne) {
		PersonneDaoImpl daop = new PersonneDaoImpl();
		daop.save(personne);
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Personne updatePersonne (Personne personne) {
		PersonneDaoImpl daop = new PersonneDaoImpl();
		Personne updatedPersonne = daop.update(personne);
		return updatedPersonne;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void deletePersonne (Personne personne) {
		PersonneDaoImpl daop = new PersonneDaoImpl();
		daop.remove(personne);
	}
}
