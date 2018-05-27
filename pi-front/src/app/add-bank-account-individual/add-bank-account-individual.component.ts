import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BankAccountService} from '../../service/bankAccountService';
import {ActivatedRoute, Router} from '@angular/router';
import {CurrencyService} from '../../service/currencyService';

@Component({
  selector: 'app-add-bank-account-individual',
  templateUrl: './add-bank-account-individual.component.html',
  styleUrls: ['./add-bank-account-individual.component.css']
})
export class AddBankAccountIndividualComponent implements OnInit {

  result;
  brojRacuna;
  idbank;
  public form: FormGroup;
  public name: AbstractControl;
  public shortname: AbstractControl;
  public accountnumber: AbstractControl;
  public adress: AbstractControl;
  public phonenumber: AbstractControl;
  public jmbg: AbstractControl;
  public email: AbstractControl;
  public deliveringadress: AbstractControl;
  public currency: AbstractControl;
  public mailreporting: AbstractControl;
  values = [];
  currencies = [];

  individual = {
    name: '',
    abbreviatedName: '',
    adress: '',
    phoneNumber: '',
    jmbg: '',
    email: '',
    deliveringAdress: '',
    mailReport: ''
  };

  bankAccount = {
    number: '',
    dateOfOpenning: '',
    valid: true,
    bank: '',
    legalEntity: null,
    individual: null,
    currency: '',
  };

  constructor(private fb: FormBuilder,
              private bankAccountService: BankAccountService,
              protected route: ActivatedRoute,
              private  currencyService: CurrencyService,
              private router: Router) {

    this.form = this.fb.group({
      'name': ['', Validators.compose([Validators.required])],
      'shortname': ['', Validators.compose([Validators.required])],
      'accountnumber': ['', Validators.compose([Validators.required])],
      'adress': ['', Validators.compose([Validators.required])],
      'phonenumber': ['', Validators.compose([Validators.required])],
      'jmbg': ['', Validators.compose([Validators.required])],
      'email': ['', Validators.compose([Validators.required])],
      'deliveringadress': ['', Validators.compose([Validators.required])],
      'currency': ['', Validators.compose([Validators.required])],
      'mailreporting': ['', Validators.compose([Validators.required])],

    });

    this.name = this.form.controls['name'];
    this.shortname = this.form.controls['shortname'];
    this.accountnumber = this.form.controls['accountnumber'];
    this.adress = this.form.controls['adress'];
    this.phonenumber = this.form.controls['phonenumber'];
    this.jmbg = this.form.controls['jmbg'];
    this.email = this.form.controls['email'];
    this.deliveringadress = this.form.controls['deliveringadress'];
    this.currency = this.form.controls['currency'];
    this.mailreporting = this.form.controls['mailreporting'];
  }

  ngOnInit() {
    this.getCurrencies();
  }

  addIndividualAccount() {

    this.idbank = this.route.snapshot.params.idBank;
    this.individual.name = this.name.value;
    this.individual.abbreviatedName = this.shortname.value;
    this.individual.adress = this.adress.value;
    this.individual.phoneNumber = this.phonenumber.value;
    this.individual.jmbg = this.jmbg.value;
    this.individual.email = this.email.value;
    this.individual.deliveringAdress = this.deliveringadress.value;
    this.individual.mailReport = this.mailreporting.value;

    this.bankAccount.bank = this.idbank;
    this.bankAccount.individual = this.individual;
    this.bankAccount.currency = this.currency.value;
    this.bankAccount.number = this.accountnumber.value;

    this.adding();

    this.router.navigateByUrl('bank/' + this.idbank + '/bankAccounts');
  }

  adding() {
    this.bankAccountService.addAccount(this.bankAccount).subscribe();
  }

  getCurrencies() {
    this.currencyService.getCurrencies().subscribe(data => {
      this.currencies = data;
    });
  }

}
