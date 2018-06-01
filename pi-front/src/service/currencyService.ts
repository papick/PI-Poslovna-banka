import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {CurrencyModel} from "../model/currency.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class CurrencyService {

  private BASE_URL = 'http://localhost:8080/api/currency';

  constructor(private http: HttpClient) {
  }

  getCurrencies(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/get-currencies`, httpOptions);
  }

  getCurrency(id: any) : Observable<any> {
    return this.http.get(`${this.BASE_URL}/currency/${id}`, httpOptions);
  }


  addNewCurrency(currency: CurrencyModel): Observable<any> {

    const body = JSON.stringify(currency);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/add-currency`, body, {headers: headers});
  }

  deleteCurrency(id: any): Observable<any> {

    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.delete(`${this.BASE_URL}/delete-currency/${id}`,  {headers: headers});

  }

  updateCurrency(currency: CurrencyModel, id: any): Observable<any> {

    const body = JSON.stringify(currency);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`${this.BASE_URL}/update-currency/${id}`, body, {headers: headers});
  }

}
