package it.contrader.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.StatisticheConverter;
import it.contrader.dao.StatisticheRepository;
import it.contrader.dto.StatisticheDTO;
import it.contrader.model.Statistiche;

@Service
public class StatisticheService extends AbstractService<Statistiche, StatisticheDTO> {

	@Autowired
	private StatisticheConverter converter;
	@Autowired
	private StatisticheRepository repository;

	public StatisticheDTO findByID(Long id) {
		return converter.toDTO(repository.findById(id).get());
	}

}
