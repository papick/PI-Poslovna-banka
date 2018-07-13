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
  public f: FormGroup;
  public file: AbstractControl;
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
    this.f = this.fb.group({
      'file': [''],
    })
    this.file = this.f.controls['file'];
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
    if (this.route.snapshot.params.type === 'undefined') {

    } else {
      const type = this.route.snapshot.params.type;
      this.analyticService.getPaymentCheck(type).subscribe(data => {
        this.form.controls['debtor'].setValue(data.debtor);
        this.form.controls['purpose'].setValue(data.purposeOfPayment);
        this.form.controls['creditor'].setValue(data.creditor);
        this.form.controls['code'].setValue(data.code);
        this.form.controls['currency'].setValue(data.paymentCurrency.officialCode);
        this.form.controls['sum'].setValue(data.sum);
        this.form.controls['bankAccount'].setValue(data.debtorAccount.number);
        this.form.controls['model'].setValue(data.modelAssigments);
        this.form.controls['referenceNumber'].setValue(data.referenceNumberAssigments);
      })
    }
  }

  load() {
    const idBank = this.route.snapshot.params.idBank;
    console.log('file');
    console.log(this.file.value);
    const path = this.file.value;
    const splited = path.split("\\");
    const fileXML = splited[splited.length-1];
    const splitXML = fileXML.split('.');
    const file = splitXML[0];
    console.log(file);
    this.router.navigateByUrl('/bank/' + idBank + '/payment-check/paymanent/' + file);
    location.reload();
  }


  confirmClick() {
    const type = this.route.snapshot.params.type;
    this.analyticService.savePaymentCheck(type).subscribe();

    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('/bank/' + idBank + '/payment-check/paymanent/undefined');
    location.reload();

  }

}
