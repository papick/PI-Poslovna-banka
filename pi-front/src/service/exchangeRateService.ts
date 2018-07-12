import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {ExchangeRateModel} from "../model/exchangeRate.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};


@Injectable()
export class ExchangeRateService {

  private BASE_URL = 'http://localhost:8080/api/exchange-rate';

  constructor(private http: HttpClient) {
  }

  getExchangeRates(id: any): Observable<any> {

    return this.http.get(`${this.BASE_URL}/get-exchange-rates/${id}`, httpOptions);
  }

  addNewExchangeRate(exchangeRateModel: ExchangeRateModel): Observable<any> {

    const body = JSON.stringify(exchangeRateModel);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/new-exchange-rate`, body, {headers: headers});
  }



}
