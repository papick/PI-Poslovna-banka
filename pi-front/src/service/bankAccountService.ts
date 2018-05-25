import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class BankAccountService {

  constructor(private http: HttpClient) {
  }

  addLegals(): Observable<any> {
    return this.http.post(`http://localhost:8080/api/legal-entity/add-legal-entity`, httpOptions);
  }

  addIndividuals(individual): Observable<any> {
    const body = JSON.stringify(individual);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8080/api/individual/add-individual`, body, {headers: headers});
  }

  addAccount(account): Observable<any>{
    const body = JSON.stringify(account);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8080/api/bankAccounts/add-account-individual`, body, {headers: headers});
  }

}
