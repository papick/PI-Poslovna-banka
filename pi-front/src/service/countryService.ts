import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {CountryModel} from "../model/country.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class CountryService {

  private BASE_URL = 'http://localhost:8080/api/countries';

  constructor(private http: HttpClient) {
  }

  getCountries(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/get-countries`, httpOptions);
  }

  createCountry(country: CountryModel): Observable<any> {
    const body = JSON.stringify(country);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/add-country`, body, {headers: headers})
  }

  deleteCountry(id: any): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.delete(`${this.BASE_URL}/delete-country/` + id, {headers: headers});
  }

  getCountry(id: any): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.get(`${this.BASE_URL}/${id}`, {headers: headers})
  }

  editCountry(country: CountryModel, id: any): Observable<any> {
    const body = JSON.stringify(country);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`${this.BASE_URL}/edit-country/${id}`, body, {headers: headers})
  }


}
