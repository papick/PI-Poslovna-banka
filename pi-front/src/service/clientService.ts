import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class ClientService {
  private BASE_URL = 'http://localhost:8080/api/bankAccounts';

  constructor(private http: HttpClient) {
  }

  getLegals(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/get-legals`, httpOptions);
  }

  getIndividuals(): Observable<any>{
    return this.http.get(`${this.BASE_URL}/get-individuals`, httpOptions);
  }

}
