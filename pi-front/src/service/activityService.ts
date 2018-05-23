import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {CountryModel} from "../model/country.model";
import {ActivityModel} from "../model/activity.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class ActivityService {

  private BASE_URL = 'http://localhost:8080/api/activities';

  constructor(private http: HttpClient) {
  }

  getActivities(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/get-activities`, httpOptions);
  }

  createActivity(activity: ActivityModel): Observable<any> {
    const body = JSON.stringify(activity);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/add-activity`, body, {headers: headers})
  }

  deleteActivity(id: any): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.delete(`${this.BASE_URL}/delete-activity/` + id, {headers: headers});
  }

  getActivity(id: any): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.get(`${this.BASE_URL}/${id}`, {headers: headers})
  }

  editActivity(activity: ActivityModel, id: any): Observable<any> {
    const body = JSON.stringify(activity);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`${this.BASE_URL}/edit-activity/${id}`, body, {headers: headers})
  }


}
