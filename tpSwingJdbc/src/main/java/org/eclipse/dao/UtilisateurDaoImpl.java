package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

	public Utilisateur save(Utilisateur utilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"insert into utilisateur (nom,prenom, sexe, type) values (?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, utilisateur.getNom());
				ps.setString(2, utilisateur.getPrenom());
				ps.setString(3, utilisateur.getSexe());
				ps.setString(4, utilisateur.getType());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					utilisateur.setNum(resultat.getInt(1));
					return utilisateur;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove(Utilisateur utilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("delete from utilisateur where numero=?;");
				ps.setInt(1, utilisateur.getNum());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Utilisateur update(Utilisateur utilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update utilisateur set nom=?, prenom=?, sexe = ? where numero=?;");
				ps.setString(1, utilisateur.getNom());
				ps.setString(2, utilisateur.getPrenom());
				ps.setString(3, utilisateur.getSexe());
				ps.setInt(4, utilisateur.getNum());
				int nbr = ps.executeUpdate();
				if (nbr != 0)
					return utilisateur;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Utilisateur findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
		try {
			PreparedStatement ps = c.prepareStatement("select * from utilisateur where numero = ?; ");
			ps.setInt(1, id);
			ResultSet r = ps.executeQuery();
			if (r.next())
				return new Utilisateur(r.getInt("numero"), r.getString("nom"), r.getString("prenom"), r.getString("sexe"), r.getString("type"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	return null;
	}
	
	public Utilisateur findByNomPrenom(String nom, String prenom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
		try {
			PreparedStatement ps = c.prepareStatement("select * from utilisateur where nom = ? and prenom =?; ");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ResultSet r = ps.executeQuery();
			if (r.next())
				return new Utilisateur(r.getInt("numero"), r.getString("nom"), r.getString("prenom"), r.getString("sexe"), r.getString("type"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	return null;
	}

	public List<Utilisateur> getAll() {
		Connection c = MyConnection.getConnection();
		List<Utilisateur> utilisateurs = null;
		if (c != null) {
			try {
				utilisateurs = new ArrayList<Utilisateur>();
				PreparedStatement ps = c.prepareStatement("select * from personne;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int num = result.getInt("numero");
					String nom = result.getString("nom");
					String prenom = result.getString("prenom");
					String sexe = result.getString("sexe");
					String type = result.getString("type");
					Utilisateur utilisateur = new Utilisateur(num, nom, prenom, sexe, type);
					utilisateurs.add(utilisateur);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return utilisateurs;
	}

}
