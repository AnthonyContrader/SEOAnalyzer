package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.StatisticheDTO;
import it.contrader.model.Statistiche;

@Component
public class StatisticheConverter extends AbstractConverter<Statistiche, StatisticheDTO> {

	@Override
	public Statistiche toEntity(StatisticheDTO statisticheDTO) {
		Statistiche statistiche = null;
		if (statisticheDTO != null) {
			statistiche = new Statistiche(statisticheDTO.getId(), statisticheDTO.getNumeroUrl(), statisticheDTO.getNumeroParole(), statisticheDTO.getNumeroImmagini(),
					statisticheDTO.getNumeroLink(), statisticheDTO.getNumeroRicercaParole(), statisticheDTO.getNumeroUtenti(), statisticheDTO.getNumeroUtentiAdmin(),
					statisticheDTO.getNumeroUtentiUser());
		}
		return statistiche;
	}

	@Override
	public StatisticheDTO toDTO(Statistiche statistiche) {
		
		StatisticheDTO statisticheDTO = null;
		if (statistiche != null) {
			statisticheDTO = new StatisticheDTO(statistiche.getId(), statistiche.getNumeroUrl(), statistiche.getNumeroParole(), statistiche.getNumeroImmagini(),
					statistiche.getNumeroLink(), statistiche.getNumeroRicercaParole(), statistiche.getNumeroUtenti(), statistiche.getNumeroUtentiAdmin(),
					statistiche.getNumeroUtentiUser());

		}
		return statisticheDTO;
	}
}