import {Component, OnInit} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {AnalyticsOfStatementService} from "../../service/AnalyticsOfStatementService";

@Component({
  selector: 'payment-check',
  templateUrl: './payment-check.component.html',
  styleUrls: ['./payment-check.component.scss'],

})

export class PaymentCheckComponent implements OnInit {

  public form: FormGroup;

  public debtor: AbstractControl;
  public purpose: AbstractControl;
  public creditor: AbstractControl;

  public code: AbstractControl;
  public currency: AbstractControl;
  public sum: AbstractControl;
  public bankAccount: AbstractControl;
  public model: AbstractControl;
  public referenceNumber: AbstractControl;
  public urgent: AbstractControl;

  constructor(protected router: Router,
              private fb: FormBuilder,
              private route: ActivatedRoute,
              private analyticService: AnalyticsOfStatementService) {
    this.form = this.fb.group({
      'debtor': ['', Validators.compose([Validators.required])],
      'purpose': ['', Validators.compose([Validators.required])],
      'creditor': ['', Validators.compose([Validators.required])],

      'code': ['', Validators.compose([Validators.required])],
      'currency': ['', Validators.compose([Validators.required])],
      'sum': ['', Validators.compose([Validators.required])],
      'bankAccount': ['', Validators.compose([Validators.required])],
      'model': ['', Validators.compose([Validators.required])],
      'referenceNumber': ['', Validators.compose([Validators.required])],
      'urgent': [''],

    })
    this.debtor = this.form.controls['debtor'];
    this.purpose = this.form.controls['purpose'];
    this.creditor = this.form.controls['creditor'];

    this.code = this.form.controls['code'];
    this.currency = this.form.controls['currency'];
    this.sum = this.form.controls['sum'];
    this.bankAccount = this.form.controls['bankAccount'];
    this.model = this.form.controls['model'];
    this.referenceNumber = this.form.controls['referenceNumber'];
    this.urgent = this.form.controls['urgent'];
  }


  ngOnInit() {

  }

  load1() {
    this.analyticService.getPaymentCheck('nalog_za_isplatu_1').subscribe(data => {
      this.form.controls['debtor'].setValue(data.debtor);
      this.form.controls['purpose'].setValue(data.purposeOfPayment);
      this.form.controls['creditor'].setValue(data.creditor);
      //this.form.controls['code'].setValue(data.code);
      // this.form.controls['currency'].setValue(data.debtor);
      this.form.controls['sum'].setValue(data.sum);
      this.form.controls['bankAccount'].setValue(data.debtorAccount.number);
      this.form.controls['model'].setValue(data.modelAssigments);
      this.form.controls['referenceNumber'].setValue(data.referenceNumberAssigments);
    })
  }

  load2() {
    this.analyticService.getPaymentCheck('nalog_za_isplatu_2').subscribe(data => {
      this.form.controls['debtor'].setValue(data.debtor);
      this.form.controls['purpose'].setValue(data.purposeOfPayment);
      this.form.controls['creditor'].setValue(data.creditor);
      //this.form.controls['code'].setValue(data.code);
      // this.form.controls['currency'].setValue(data.debtor);
      this.form.controls['sum'].setValue(data.sum);
      this.form.controls['bankAccount'].setValue(data.debtorAccount.number);
      this.form.controls['model'].setValue(data.modelAssigments);
      this.form.controls['referenceNumber'].setValue(data.referenceNumberAssigments);
    })
  }


  confirmClick() {
    console.log('milica')
  }

}
