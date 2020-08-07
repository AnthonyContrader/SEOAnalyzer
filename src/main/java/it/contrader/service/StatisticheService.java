package it.contrader.service;

import it.contrader.converter.StatisticheConverter;
import it.contrader.dao.StatisticheDAO;
import it.contrader.dto.StatisticheDTO;
import it.contrader.model.Statistiche;

public class StatisticheService extends AbstractService<Statistiche, StatisticheDTO> {
	public StatisticheService() {
		this.dao = new StatisticheDAO();
		this.converter = new StatisticheConverter();
	}
}
