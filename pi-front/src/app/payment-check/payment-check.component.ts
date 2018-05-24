import {Component} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'payment-check',
  templateUrl: './payment-check.component.html',
  styleUrls: ['./payment-check.component.scss'],

})

export class PaymentCheckComponent {

  public form: FormGroup;

  public code: AbstractControl;
  public currency: AbstractControl;
  public sum: AbstractControl;
  public bankAccount: AbstractControl;
  public model: AbstractControl;
  public referenceNumber: AbstractControl;
  public urgent: AbstractControl;

  constructor(protected router: Router,
              private fb: FormBuilder,
              private route: ActivatedRoute) {
    this.form = this.fb.group({
      'code': ['', Validators.compose([Validators.required])],
      'currency': ['', Validators.compose([Validators.required])],
      'sum': ['', Validators.compose([Validators.required])],
      'bankAccount': ['', Validators.compose([Validators.required])],
      'model': ['', Validators.compose([Validators.required])],
      'referenceNumber': ['', Validators.compose([Validators.required])],
      'urgent': [''],

    })
    this.code = this.form.controls['code'];
    this.currency = this.form.controls['currency'];
    this.sum = this.form.controls['sum'];
    this.bankAccount = this.form.controls['bankAccount'];
    this.model = this.form.controls['model'];
    this.referenceNumber = this.form.controls['referenceNumber'];
    this.urgent = this.form.controls['urgent'];
  }

  confirmClick() {
    console.log('milica')
  }

}
