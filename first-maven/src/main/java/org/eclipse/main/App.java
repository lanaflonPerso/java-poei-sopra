package org.eclipse.main;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        PersonneDaoImpl pDaoImpl = new PersonneDaoImpl();
        Personne personne = new Personne("Wick", "John");
        Personne insertedPers = pDaoImpl.save(personne);
        if (insertedPers!=null) {
        	System.out.println("Personne ajoutée avec succès!");
        }
        else {
			System.out.println("Problème lors de l'insertion.");
		}
    }
}
