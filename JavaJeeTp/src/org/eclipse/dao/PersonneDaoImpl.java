package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Personne;

public class PersonneDaoImpl implements Dao<Personne> {
	@Override
	public int save(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into personne (nom,prenom, sexe) values (?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.setString(3, String.valueOf(personne.getSexe()));

				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					return resultat.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	@Override
	public Personne findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from personne where id = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next())
					return  new Personne(r.getInt("id"), r.getString("nom"), r.getString("prenom"), r.getString("sexe").charAt(0));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remove(Personne obj) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("delete from personne where id=?;");
				ps.setInt(1, obj.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Personne update(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update personne set nom = ?, prenom = ?, sexe = ? where id = ?; ");
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.setString(3, String.valueOf(personne.getSexe()));
				ps.setInt(4, personne.getId());
				ps.executeUpdate();
				return personne;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Personne> getAll() {
		// TODO Auto-generated method stub
		ArrayList<Personne> personnes = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from personne;");
				ResultSet r = ps.executeQuery();
				while (r.next()) {
					personnes.add( new Personne(r.getInt("id"), r.getString("nom"), r.getString("prenom"), r.getString("sexe").charAt(0)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
		return personnes;
	}

	public Personne findByNomAndPrenom(String nom, String prenom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from personne where nom = ? and prenom = ? ; ");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ResultSet r = ps.executeQuery();
				if (r.next())
					return  new Personne(r.getInt("id"), r.getString("nom"), r.getString("prenom"), r.getString("sexe").charAt(0));
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
}
