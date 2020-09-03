import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UrlDTO } from 'src/dto/urldto';
import { StatisticheDTO } from 'src/dto/statistichedto';
import { Service } from './service';


/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UrlService extends AbstractService<StatisticheDTO>{
    type: string = "url";
    port: string = '8080';

  constructor(protected http: HttpClient) {
    super(http);
  }

  getStatistiche(url: UrlDTO): Observable<any> {
    return this.http.get<any>('http://localhost:' + this.port + '/' + this.type + '/getStatistiche', url);
  }

}
