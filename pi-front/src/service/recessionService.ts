import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

import {CountryModel} from "../model/country.model";
import {ActivityModel} from "../model/activity.model";



@Injectable()
export class RecessionService {

  private BASE_URL = 'http://localhost:8080/api/recession';

  constructor(private http: HttpClient) {
  }

  addRecession(body){
    return this.http.post(this.BASE_URL,body);
  }
}
