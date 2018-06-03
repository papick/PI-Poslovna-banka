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

  addLegals(legalEntity): Observable<any> {
    const body = JSON.stringify(legalEntity);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8080/api/legal-entity/add-legal-entity`, body, {headers: headers});
  }

  addIndividuals(individual): Observable<any> {
    const body = JSON.stringify(individual);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8080/api/individual/add-individual`, body, {headers: headers});
  }

  addAccount(account): Observable<any> {
    const body = JSON.stringify(account);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8080/api/bankAccounts/add-account-individual`, body, {headers: headers});
  }

  addAccountLegalEntity(account): Observable<any> {
    const body = JSON.stringify(account);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8080/api/bankAccounts/add-account-legal`, body, {headers: headers});
  }

  editLegalBankAccount(account, id): Observable<any> {
    const body = JSON.stringify(account);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`http://localhost:8080/api/bankAccounts//edit-legal-account/${id}`, body, {headers: headers});
  }

  getBankAccount(id): Observable<any> {
    return this.http.get(`http://localhost:8080/api/bankAccounts/get-account/${id}`, httpOptions);
  }

  editIndividualBankAccount(account, id): Observable<any> {
    const body = JSON.stringify(account);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`http://localhost:8080/api/bankAccounts/edit-individual-account/${id}`, body, {headers: headers});
  }

}
