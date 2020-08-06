package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.contrader.model.Statistiche;
import it.contrader.utils.ConnectionSingleton;

public class StatisticheDAO implements DAO<Statistiche> {
	private final String QUERY_READ = "SELECT * FROM user WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE statistiche SET numeroUrl=?, numeroParole=?, numeroImmagini=?, numeroLink=?, numeroRicercaParole=? WHERE id=?";


	@Override
	public List<Statistiche> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statistiche read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int numeroUrl, numeroParole, numeroImmagini, numeroLink, numeroRicercaParole;

			numeroUrl = resultSet.getInt("numeroUrl");
			numeroParole = resultSet.getInt("numeroParole");
			numeroImmagini = resultSet.getInt("numeroImmagini");
			numeroLink = resultSet.getInt("numeroLink");
			numeroRicercaParole = resultSet.getInt("numeroRicercaParole");

			Statistiche st = new Statistiche(numeroUrl, numeroParole, numeroImmagini, numeroLink, numeroRicercaParole);
			st.setId(resultSet.getInt("id"));

			return st;
		} catch (SQLException e) {
			return null;
		}

	}

	@Override
	public boolean insert(Statistiche dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Statistiche dto) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (dto.getId() == 0)
			return false;

		Statistiche statisticheRead = read(dto.getId());
		if (!statisticheRead.equals(dto)) {
			try {
				// Fill the userToUpdate object
				if (statisticheRead.getNumeroUrl() != 0 ) {
					dto.setNumeroUrl( dto.getNumeroUrl() + statisticheRead.getNumeroUrl() );
				}

				if (statisticheRead.getNumeroParole() != 0 ) {
					dto.setNumeroParole( dto.getNumeroParole() + statisticheRead.getNumeroParole() );
				}

				if (statisticheRead.getNumeroImmagini() != 0 ) {
					dto.setNumeroImmagini( dto.getNumeroImmagini() + statisticheRead.getNumeroImmagini() );
				}

				if (statisticheRead.getNumeroLink() != 0 ) {
					dto.setNumeroLink( dto.getNumeroLink() + statisticheRead.getNumeroLink() );
				}

				if (statisticheRead.getNumeroRicercaParole() != 0 ) {
					dto.setNumeroRicercaParole( dto.getNumeroRicercaParole() + statisticheRead.getNumeroRicercaParole() );
				}

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, statisticheRead.getNumeroUrl());
				preparedStatement.setInt(2, statisticheRead.getNumeroParole());
				preparedStatement.setInt(3, statisticheRead.getNumeroImmagini());
				preparedStatement.setInt(4, statisticheRead.getNumeroLink());
				preparedStatement.setInt(5, statisticheRead.getNumeroRicercaParole());
				preparedStatement.setInt(6, statisticheRead.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> readAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

}
