import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ExchangeRateInCurrencyModel} from "../model/exchangeRateInCurrency.model";
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};


@Injectable()
export class ExchangeRateInCurrencyService {

  private BASE_URL = 'http://localhost:8080/api/exchange-rate-in-currency';

  constructor(private http: HttpClient) {
  }


  addNewExchangeRateInCurrency(exchangeRateInCurrencyModel: ExchangeRateInCurrencyModel): Observable<any> {

    const body = JSON.stringify(exchangeRateInCurrencyModel);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/new-exchange-rate-in-currency`, body, {headers: headers});
  }

  getExchangeRatesInCurrency(id: any): Observable<any> {

    return this.http.get(`${this.BASE_URL}/get-all/${id}`, httpOptions);
  }

}
