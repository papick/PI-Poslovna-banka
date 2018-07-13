import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class AnalyticsOfStatementService {

  private BASE_URL = 'http://localhost:8080/api/analytic';

  constructor(private http: HttpClient) {
  }

  getPaymentOrder(name: any): Observable<any> {
    return this.http.get(`${this.BASE_URL}/xml-order/${name}`, httpOptions);
  }

  savePaymentOrder(name: any): Observable<any> {
    return this.http.get(`${this.BASE_URL}/save/xml-order/${name}`, httpOptions);
  }

  getPaymentCheck(name: any): Observable<any> {
    return this.http.get(`${this.BASE_URL}/xml/${name}`, httpOptions);
  }

  savePaymentCheck(name: any): Observable<any> {
    return this.http.get(`${this.BASE_URL}/save/xml/${name}`, httpOptions);
  }

  getPayCheck(name: any): Observable<any> {
    return this.http.get(`${this.BASE_URL}/xml-naplata/${name}`, httpOptions);
  }

  getTransferCheck(name: any): Observable<any> {
    return this.http.get(`${this.BASE_URL}/xml-prenos/${name}`, httpOptions);
  }

  savePayCheck(name: any): Observable<any> {
    return this.http.get(`${this.BASE_URL}/save/xml-payment/${name}`, httpOptions);
  }

  saveTransferCheck(name: any): Observable<any> {
    return this.http.get(`${this.BASE_URL}/save/xml-transfer/${name}`, httpOptions);
  }


}
