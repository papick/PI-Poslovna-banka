import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class ClientService {

  constructor(private http: HttpClient) {
  }

  getLegals(): Observable<any> {
    return this.http.get(`http://localhost:8080/api/bankAccounts/get-legals`, httpOptions);
  }

  getIndividuals(): Observable<any> {
    return this.http.get(`http://localhost:8080/api/bankAccounts/get-individuals`, httpOptions);
  }

  addLegal(legal): Observable<any> {
    const body = JSON.stringify(legal);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8080/api/legal-entity/add-legal-entity`, body, {headers: headers});
  }

  addIndividual(individual): Observable<any> {
    const body = JSON.stringify(individual);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8080/api/individual/add-individual`, body, {headers: headers});
  }

}
