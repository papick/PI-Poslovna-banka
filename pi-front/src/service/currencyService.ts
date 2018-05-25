import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class CurrencyService {

  constructor(private http: HttpClient) {
  }

  getCurrencies(): Observable<any> {
    return this.http.get(`http://localhost:8080/api/currency/get-currency`, httpOptions);
  }

}
