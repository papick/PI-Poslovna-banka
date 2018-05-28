import {Component, OnInit} from '@angular/core';
import {ActivityService} from "../../service/activityService";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CurrencyService} from "../../service/currencyService";
import {BankAccountService} from "../../service/bankAccountService";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-add-bank-account-legals',
  templateUrl: './add-bank-account-legals.component.html',
  styleUrls: ['./add-bank-account-legals.component.css']
})
export class AddBankAccountLegalsComponent implements OnInit {

  idBank;
  result;
  public form: FormGroup;
  public name: AbstractControl;
  public shortname: AbstractControl;
  public responsibleperson: AbstractControl;
  public accountnumber: AbstractControl;
  public currency: AbstractControl;
  public activity: AbstractControl;
  public adress: AbstractControl;
  public phonenumber: AbstractControl;
  public jmbg: AbstractControl;
  public email: AbstractControl;
  public mbr: AbstractControl;
  public taxauthority: AbstractControl;
  public pib: AbstractControl;
  public deliveringadress: AbstractControl;
  public mailreporting: AbstractControl;
  values = [];
  currencies = [];

  bankAccount = {
    number: '',
    dateOfOpenning: '',
    valid: true,
    bank: '',
    legalEntity: null,
    individual: null,
    currency: '',
  };

  legalEntity = {
    name: '',
    abbreviatedName: '',
    adress: '',
    phoneNumber: '',
    jmbg: '',
    email: '',
    mbr: '',
    taxAuthority: '',
    pib: '',
    activity: '',
    deliveringAdress: '',
    responsiblePerson: '',
    mailReport: ''
  };

  constructor(private activityService: ActivityService,
              private fb: FormBuilder,
              private  currencyService: CurrencyService,
              private bankAccountService: BankAccountService,
              protected route: ActivatedRoute,
              private router: Router) {
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
      'mailreporting': [''],

    });
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
    this.mailreporting = this.form.controls['mailreporting'];

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

  addLegalEntityAccount() {

    this.idBank = this.route.snapshot.params.idBank;
    this.legalEntity.name = this.name.value;
    this.legalEntity.abbreviatedName = this.shortname.value;
    this.legalEntity.adress = this.adress.value;
    this.legalEntity.phoneNumber = this.phonenumber.value;
    this.legalEntity.jmbg = this.jmbg.value;
    this.legalEntity.email = this.email.value;
    this.legalEntity.mbr = this.mbr.value;
    this.legalEntity.taxAuthority = this.taxauthority.value;
    this.legalEntity.pib = this.pib.value;
    this.legalEntity.activity = this.activity.value;
    this.legalEntity.deliveringAdress = this.deliveringadress.value;
    this.legalEntity.responsiblePerson = this.responsibleperson.value;
    this.legalEntity.mailReport = this.mailreporting.value;

    this.bankAccount.bank = this.idBank;
    this.bankAccount.legalEntity = this.legalEntity;
    this.bankAccount.currency = this.currency.value;
    this.bankAccount.number = this.accountnumber.value;

    this.adding();
    this.router.navigateByUrl('bank/' + this.idBank + '/bankAccounts');

  }

  adding() {
    this.bankAccountService.addAccountLegalEntity(this.bankAccount).subscribe();
  }

}
