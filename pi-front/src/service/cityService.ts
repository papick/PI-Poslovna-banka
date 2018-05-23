import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {CityModel} from "../model/city.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class CityService {

  private BASE_URL = 'http://localhost:8080/api/cities';

  constructor(private http: HttpClient) {
  }

  getCities(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/get-all-cities`, httpOptions);
  }

  deleteCity(id: any): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.delete(`${this.BASE_URL}/delete-city/` + id, {headers: headers});
  }

  getCity(id): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.get(`${this.BASE_URL}/get-city/${id}`, {headers: headers})
  }

  getCitesByCountry(id): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.get(`${this.BASE_URL}/get-by-country/${id}`, {headers: headers})
  }

  createCity(city: CityModel): Observable<any> {
    const body = JSON.stringify(city);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/add-city`, body, {headers: headers})
  }

  editCity(city: CityModel, id: any): Observable<any> {
    const body = JSON.stringify(city);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`${this.BASE_URL}/edit-city/${id}`, body, {headers: headers})
  }

}
