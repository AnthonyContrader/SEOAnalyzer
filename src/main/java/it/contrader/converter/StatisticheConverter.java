package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.StatisticheDTO;
import it.contrader.model.Statistiche;

public class StatisticheConverter implements Converter<Statistiche, StatisticheDTO>{

	@Override
	public StatisticheDTO toDTO(Statistiche entity) {
		StatisticheDTO statisticheDTO = new StatisticheDTO(entity.getId(), entity.getNumeroUrl(), entity.getNumeroParole(), entity.getNumeroImmagini(), entity.getNumeroLink(), entity.getNumeroRicercaParole());
		return statisticheDTO;
	}

	@Override
	public Statistiche toEntity(StatisticheDTO dto) {
		Statistiche statistiche = new Statistiche(dto.getId(), dto.getNumeroUrl(), dto.getNumeroParole(), dto.getNumeroImmagini(), dto.getNumeroLink(), dto.getNumeroRicercaParole());
		return statistiche;
	}

	@Override
	public List<StatisticheDTO> toDTOList(List<Statistiche> entityList) {
		//Crea una lista vuota.
		List<StatisticheDTO> statisticheDTOList = new ArrayList<StatisticheDTO>();

		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Statistiche stat : entityList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			statisticheDTOList.add(toDTO(stat));
		}
		return statisticheDTOList;
	}

}
