package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";

	@Override
	public Film getFilmById(int filmId) throws SQLException {

		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String filmTitle = "%" + filmId + "%";
		String sql = "SELECT id, title, description, release_year, language_id, rental_duration, "
				+ "rental_rate, length, replacement_cost, rating, special_features FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, filmTitle);
		stmt.setString(2, filmTitle);
		ResultSet rs = stmt.executeQuery();

		int count = 0;
		Film film = null;

		while (rs.next()) {
			int id = rs.getInt(1);
			String title = rs.getString(2);
			String desc = rs.getString(3);
			int releaseYear = rs.getInt(4);
			int langId = rs.getInt(5);
			int rentalDur = rs.getInt(6);
			double rentalRate = rs.getDouble(7);
			int length = rs.getInt(8);
			double replaceCost = rs.getDouble(9);
			String rating = rs.getString(10);
			String specialFeat = rs.getString(11);

			count++;

			film = new Film(id, title, desc, releaseYear, langId, rentalDur, rentalRate, length, replaceCost, rating,
					specialFeat);
			List<Actor> cast = getActorsByFilmId(film.getId());

		}
		// if (count == 0) {
		// System.out.println("Film not found");
		// }
		rs.close();
		stmt.close();
		conn.close();

		return film;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load DB driver. Exiting");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public Actor getActorById(int actorId) {
		String user = "student";
		String pass = "student";
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String actorIdStr = "%" + actorId + "%";
			String sql = "SELECT id, first_name, last_name, films FROM actor WHERE id = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, actorIdStr);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);

				actor = new Actor(id, firstName, lastName);

			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return actor;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		String user = "student";
		String pass = "student";
		List<Actor> actorList = null;
		
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String actorByFilmId = "%" + filmId + "%";
			String sql = "SELECT a.id, a.first_name, a.last_name FROM actor a JOIN film_actor fa ON fa.actor_id = a.id WHERE fa.film_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, actorByFilmId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				Actor actor = new Actor(id, firstName, lastName);
					
				actorList = new ArrayList<Actor>();
				actorList.add(actor);

			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return actorList;
	}
}
