package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Adresse;

public class AdresseDaoImpl implements Dao<Adresse> {
	PersonneDaoImpl personneDaoImpl = new PersonneDaoImpl();

	@Override
	public int save(Adresse adresse) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"insert into adresse (rue, codePostal, ville, idPersonne) values (?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, adresse.getRue());
				ps.setString(2, adresse.getCodePostal());
				ps.setString(3, adresse.getVille());
				ps.setInt(4, adresse.getPersonne().getId());
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
	public void remove(Adresse obj) {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("delete from adresse where id=?;");
				ps.setInt(1, obj.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Adresse update(Adresse adresse) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"update adresse set rue = ?, codePostal = ?, ville = ?, idPersonne = ? where id = ?; ");
				ps.setString(1, adresse.getRue());
				ps.setString(2, adresse.getCodePostal());
				ps.setString(3, adresse.getVille());
				ps.setInt(4, adresse.getPersonne().getId());
				ps.setInt(5, adresse.getId());
				ps.executeUpdate();
				return adresse;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Adresse updatePersonne(Adresse adresse) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update adresse set idPersonne = ? where id = ?; ");

				ps.setInt(2, adresse.getId());
				if (adresse.getPersonne() != null)
					ps.setInt(1, adresse.getPersonne().getId());
				else {
					ps.setNull(1, Types.INTEGER);

				}
				ps.executeUpdate();
				return adresse;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Adresse findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from adresse where id = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				r.next();
				Adresse a = new Adresse(r.getInt("id"), r.getString("rue"), r.getString("ville"),
						r.getString("codePostal"), personneDaoImpl.findById(r.getInt("idPersonne")));
				return a;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Adresse> getAll() {
		ArrayList<Adresse> adresses = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from adresse;");
				ResultSet r = ps.executeQuery();
				while (r.next()) {
					Adresse a = new Adresse(r.getInt("id"), r.getString("rue"), r.getString("ville"),
							r.getString("codePostal"), personneDaoImpl.findById(r.getInt("idPersonne")));
					adresses.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return adresses;
	}

	public ArrayList<Adresse> findByIdPersonne(int id) {
		ArrayList<Adresse> adresses = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from adresse where idPersonne = ?;");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				while (r.next()) {
					Adresse a = new Adresse(r.getInt("id"), r.getString("rue"), r.getString("ville"),
							r.getString("codePostal"), personneDaoImpl.findById(r.getInt("idPersonne")));
					adresses.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return adresses;
	}

	public ArrayList<Adresse> findByIdPersonneNotEqual(int id) {
		ArrayList<Adresse> adresses = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c
						.prepareStatement("select * from adresse where idPersonne <> ? or idPersonne is null;");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				while (r.next()) {
					Adresse a = new Adresse(r.getInt("id"), r.getString("rue"), r.getString("ville"),
							r.getString("codePostal"), personneDaoImpl.findById(r.getInt("idPersonne")));
					adresses.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return adresses;
	}
}
