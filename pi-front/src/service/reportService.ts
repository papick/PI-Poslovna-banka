import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {ReportModel} from "../model/report.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class ReportService {

  private BASE_URL = 'http://localhost:8080/api/reports';

  constructor(private http: HttpClient) {
  }


  createReportClient(report: ReportModel): Observable<any> {
    const body = JSON.stringify(report);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/get-client-report`, body, {headers: headers});
  }

  createReportBankAccount(id: any): Observable<Blob> {

    //const headers = new HttpHeaders({'Content-Type': 'application/pdf'});
    return this.http.get(`${this.BASE_URL}/get-accounts/${id}`, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }), responseType: 'blob' });
  }


}
