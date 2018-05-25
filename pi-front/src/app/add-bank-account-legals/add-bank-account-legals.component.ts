import {Component, OnInit} from '@angular/core';
import {ActivityService} from "../../service/activityService";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CurrencyService} from "../../service/currencyService";

@Component({
  selector: 'app-add-bank-account-legals',
  templateUrl: './add-bank-account-legals.component.html',
  styleUrls: ['./add-bank-account-legals.component.css']
})
export class AddBankAccountLegalsComponent implements OnInit {

  public form: FormGroup;
  public name: AbstractControl;
  public shortname: AbstractControl;
  public accountnumber: AbstractControl;
  public activity: AbstractControl;
  public adress: AbstractControl;
  public phonenumber: AbstractControl;
  public jmbg: AbstractControl;
  public email: AbstractControl;
  public mbr: AbstractControl;
  public taxauthority: AbstractControl;
  public pib: AbstractControl;
  public deliveringadress: AbstractControl;
  public currency: AbstractControl;
  public responsibleperson: AbstractControl;
  values = [];
  currencies = [];

  constructor(private activityService: ActivityService, private fb: FormBuilder, private  currencyService: CurrencyService) {
    this.form = this.fb.group({
      'name': ['', Validators.compose([Validators.required])],
      'shortname': ['', Validators.compose([Validators.required])],
      'accountnumber': ['', Validators.compose([Validators.required])],
      'activity': ['', Validators.compose([Validators.required])],
      'adress': ['', Validators.compose([Validators.required])],
      'phonenumber': ['', Validators.compose([Validators.required])],
      'jmbg': ['', Validators.compose([Validators.required])],
      'email': ['', Validators.compose([Validators.required])],
      'mbr': ['', Validators.compose([Validators.required])],
      'taxauthority': ['', Validators.compose([Validators.required])],
      'pib': ['', Validators.compose([Validators.required])],
      'deliveringadress': ['', Validators.compose([Validators.required])],
      'currency': ['', Validators.compose([Validators.required])],
      'responsibleperson': ['', Validators.compose([Validators.required])],

    })
    this.name = this.form.controls['name'];
    this.shortname = this.form.controls['shortname'];
    this.accountnumber = this.form.controls['accountnumber'];
    this.activity = this.form.controls['activity'];
    this.adress = this.form.controls['adress'];
    this.phonenumber = this.form.controls['phonenumber'];
    this.jmbg = this.form.controls['jmbg'];
    this.email = this.form.controls['email'];
    this.mbr = this.form.controls['mbr'];
    this.taxauthority = this.form.controls['taxauthority'];
    this.pib = this.form.controls['pib'];
    this.deliveringadress = this.form.controls['deliveringadress'];
    this.currency = this.form.controls['currency'];
    this.responsibleperson = this.form.controls['responsibleperson'];

  }

  ngOnInit() {
    this.selectItem();
    this.getCurrencies();

  }

  selectItem() {
    this.activityService.getActivities().subscribe(data => {
      this.values = data.activities;
    });
  }

  getCurrencies() {
    this.currencyService.getCurrencies().subscribe(data => {
      this.currencies = data;
    });
  }

}
