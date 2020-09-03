import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { UrlDTO } from 'src/dto/urldto';
import { UrlService } from 'src/service/url.service';
import { StatisticheDTO } from 'src/dto/statistichedto';

/**
 * Componente della analyze user. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-analyze',
  templateUrl: './analyze.component.html',
  styleUrls: ['./analyze.component.css']
})
export class AnalyzeComponent implements OnInit {

  user: UserDTO;
  urlInsert: UrlDTO = new UrlDTO;
  stat: StatisticheDTO;

  
  constructor(private service: UrlService) {
       
   }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.urlInsert.idUser = this.user.id;
  }

  getStatistiche(url: UrlDTO) {
    this.service.getStatistiche(url).subscribe((statistiche) => this.stat);
  }

}
