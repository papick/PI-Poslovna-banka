import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";


@Injectable()
export class ClearingService {

  private url = 'http://localhost:8080/api/clearing';

  constructor(private http: HttpClient) {
  }

  clearing(bank) {
    return this.http.post( this.url , bank);
  }

}
