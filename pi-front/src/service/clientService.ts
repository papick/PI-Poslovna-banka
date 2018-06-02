import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class ClientService {

  private BASE_URL = 'http://localhost:8080/api/cities';

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

  getLegalEntities(): Observable<any> {
    return this.http.get(`http://localhost:8080/api/legal-entity/get-legalEntities`, httpOptions);
  }

  getIndividualEntities(): Observable<any> {
    return this.http.get(`http://localhost:8080/api/individual/get-individualEntities`, httpOptions);
  }

  getLegalEntity(id): Observable<any> {
    return this.http.get(`http://localhost:8080/api/legal-entity/get-legalEntity/${id}`, httpOptions);
  }

  editLegalEntity(legal, id): Observable<any> {
    const body = JSON.stringify(legal);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`http://localhost:8080/api/legal-entity/edit-legalEntity/${id}`, body, {headers: headers});
  }

  deleteLegalEntity(id): Observable<any> {
    return this.http.delete(`http://localhost:8080/api/legal-entity/delete-legalEntity/${id}`, httpOptions);
  }

  deleteIndividual(id): Observable<any> {
    return this.http.delete(`http://localhost:8080/api/individual/delete-individualEntities/${id}`, httpOptions);
  }

  getIndividual(id): Observable<any>{
    return this.http.get(`http://localhost:8080/api/individual/get-individual/${id}`, httpOptions);
  }

  editIndividual(individual, id): Observable<any> {
    const body = JSON.stringify(individual);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`http://localhost:8080/api/individual/edit-individual/${id}`, body, {headers: headers});
  }
}
