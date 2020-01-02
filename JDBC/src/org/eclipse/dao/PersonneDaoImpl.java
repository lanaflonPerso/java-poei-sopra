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
	public Personne save(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into personne (nom,prenom) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					personne.setNum(resultat.getInt(1));
					return personne;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remove(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("delete from personne where num=?;");
				ps.setInt(1, personne.getNum());
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
				PreparedStatement ps = c.prepareStatement("update personne set nom=?, prenom=? where num=?;");
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.setInt(3, personne.getNum());
				int nbr = ps.executeUpdate();
				if (nbr != 0)
					return personne;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Personne findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from personne where num = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next())
					return new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public List<Personne> getAll() {
		Connection c = MyConnection.getConnection();
		List<Personne> personnes = null;
		if (c != null) {
			try {
				personnes = new ArrayList<Personne>();
				PreparedStatement ps = c.prepareStatement("select * from personne;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int num = result.getInt("num");
					String nom = result.getString("nom");
					String prenom = result.getString("prenom");
					Personne personne = new Personne(num, nom, prenom);
					personnes.add(personne);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personnes;
	}
}
