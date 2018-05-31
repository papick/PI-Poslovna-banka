import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AnalyticsOfStatementService} from "../../service/AnalyticsOfStatementService";

@Component({
  selector: 'app-pay-check',
  templateUrl: './pay-check.component.html',
  styleUrls: ['./pay-check.component.css']
})
export class PayCheckComponent implements OnInit {

  public form: FormGroup;

  public debtor: AbstractControl;
  public purpose: AbstractControl;
  public creditor: AbstractControl;

  public code: AbstractControl;
  public currency: AbstractControl;
  public sum: AbstractControl;
  public bankAccountDebtor: AbstractControl;
  public modelAssingment: AbstractControl;
  public referenceNumberAssingment: AbstractControl;
  public bankAccountCreditor: AbstractControl;
  public modelApproval: AbstractControl;
  public referenceNumberApproval: AbstractControl;
  public urgent: AbstractControl;

  constructor(private fb: FormBuilder, private analyticeService: AnalyticsOfStatementService) {
    this.form = this.fb.group({
      'debtor': ['', Validators.compose([Validators.required])],
      'purpose': ['', Validators.compose([Validators.required])],
      'creditor': ['', Validators.compose([Validators.required])],

      'code': ['', Validators.compose([Validators.required])],
      'currency': ['', Validators.compose([Validators.required])],
      'sum': ['', Validators.compose([Validators.required])],
      'bankAccountDebtor': ['', Validators.compose([Validators.required])],
      'modelAssingment': ['', Validators.compose([Validators.required])],
      'referenceNumberAssingment': ['', Validators.compose([Validators.required])],
      'bankAccountCreditor': ['', Validators.compose([Validators.required])],
      'modelApproval': ['', Validators.compose([Validators.required])],
      'referenceNumberApproval': ['', Validators.compose([Validators.required])],
      'urgent': [''],
    })

    this.debtor = this.form.controls['debtor'];
    this.purpose = this.form.controls['purpose'];
    this.creditor = this.form.controls['creditor'];

    this.code = this.form.controls['code'];
    this.currency = this.form.controls['currency'];
    this.sum = this.form.controls['sum'];
    this.bankAccountDebtor = this.form.controls['bankAccountDebtor'];
    this.modelAssingment = this.form.controls['modelAssingment'];
    this.referenceNumberAssingment = this.form.controls['referenceNumberAssingment'];
    this.bankAccountCreditor = this.form.controls['bankAccountCreditor'];
    this.modelApproval = this.form.controls['modelApproval'];
    this.referenceNumberApproval = this.form.controls['referenceNumberApproval'];
    this.urgent = this.form.controls['urgent'];
  }

  ngOnInit() {
  }

  ucitaj() {
    this.analyticeService.getPayCheck('nalog_za_naplatu_1').subscribe(data =>{
      this.form.controls['debtor'].setValue(data.debtor);
      this.form.controls['purpose'].setValue(data.purposeOfPayment);
      this.form.controls['creditor'].setValue(data.creditor);
      this.form.controls['sum'].setValue(data.sum);
      this.form.controls['bankAccountDebtor'].setValue(data.debtorAccount.number);
      this.form.controls['modelAssingment'].setValue(data.modelAssigments);
      this.form.controls['referenceNumberAssingment'].setValue(data.referenceNumberAssigments);
      this.form.controls['bankAccountCreditor'].setValue(data.accountCreditor.number);
      this.form.controls['modelApproval'].setValue(data.modelApproval);
      this.form.controls['referenceNumberApproval'].setValue(data.referenceNumberCreditor);
    });
  }

}
