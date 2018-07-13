import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ReportModel} from '../../model/report.model';
import {ReportService} from '../../service/reportService';

import * as FileSaver from 'file-saver';

@Component({
  selector: 'report',
  templateUrl: './report.component.html',

})

export class ReportComponent implements OnInit {

  idBank;
  imageRoute;
  public form: FormGroup;
  public from: AbstractControl;
  public to: AbstractControl;
  public bankAccount: AbstractControl;

  window: MyWindow;

  constructor(protected route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder,
              private reportService: ReportService) {
    this.form = this.fb.group({
      'from': ['', Validators.compose([Validators.required])],
      'to': ['', Validators.compose([Validators.required])],
      'bankAccount': ['', Validators.compose([Validators.required])],


    });
    this.from = this.form.controls['from'];
    this.to = this.form.controls['to'];
    this.bankAccount = this.form.controls['bankAccount'];
  }


  ngOnInit() {
    this.idBank = this.route.snapshot.params.idBank;

    if (this.idBank == 1) {
      this.imageRoute = '../../../assets/images/erste.jpg';
    } else if (this.idBank == 2) {
      this.imageRoute = '../../../assets/images/intesa.jpg';
    } else {
      this.imageRoute = '../../../assets/images/banka.jpg';
    }
  }

  generateReportClient() {

    const report = new ReportModel(
      this.bankAccount.value,
      this.from.value,
      this.to.value
    );


    this.reportService.createReportClient(report).subscribe(data => {

      const file = new Blob([data], {type: 'application/pdf'});
      FileSaver.saveAs(file, 'Client_report');

    });


  }

  generateReportBankAccounts() {
    const idBank = this.route.snapshot.params.idBank;
    this.reportService.createReportBankAccount(this.idBank).subscribe(data => {

      const file = new Blob([data], {type: 'application/pdf'});
      FileSaver.saveAs(file, 'Bank_accounts');

    });
  }


}
