import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CurrencyService} from '../../service/currencyService';
import {ClientService} from "../../service/clientService";

@Component({
  selector: 'app-add-bank-account-individual',
  templateUrl: './add-bank-account-individual.component.html',
  styleUrls: ['./add-bank-account-individual.component.css']
})
export class AddBankAccountIndividualComponent implements OnInit {

  idbank;
  public form: FormGroup;
  public name: AbstractControl;
  public shortname: AbstractControl;
  public adress: AbstractControl;
  public phonenumber: AbstractControl;
  public jmbg: AbstractControl;
  public email: AbstractControl;
  public deliveringadress: AbstractControl;
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
  };

  constructor(private fb: FormBuilder,
              private clientService: ClientService,
              protected route: ActivatedRoute,
              private  currencyService: CurrencyService,
              private router: Router) {

    this.form = this.fb.group({
      'name': ['', Validators.compose([Validators.required])],
      'shortname': ['', Validators.compose([Validators.required])],
      'adress': ['', Validators.compose([Validators.required])],
      'phonenumber': ['', Validators.compose([Validators.required])],
      'jmbg': ['', Validators.compose([Validators.required])],
      'email': ['', Validators.compose([Validators.required])],
      'deliveringadress': ['', Validators.compose([Validators.required])],

    });

    this.name = this.form.controls['name'];
    this.shortname = this.form.controls['shortname'];
    this.adress = this.form.controls['adress'];
    this.phonenumber = this.form.controls['phonenumber'];
    this.jmbg = this.form.controls['jmbg'];
    this.email = this.form.controls['email'];
    this.deliveringadress = this.form.controls['deliveringadress'];
  }

  ngOnInit() {
    this.getCurrencies();
  }

  addIndividual() {

    this.idbank = this.route.snapshot.params.idBank;
    this.individual.name = this.name.value;
    this.individual.abbreviatedName = this.shortname.value;
    this.individual.adress = this.adress.value;
    this.individual.phoneNumber = this.phonenumber.value;
    this.individual.jmbg = this.jmbg.value;
    this.individual.email = this.email.value;
    this.individual.deliveringAdress = this.deliveringadress.value;

    this.clientService.addIndividual(this.individual);

    this.router.navigateByUrl('bank/' + this.idbank + '/bankAccounts');
  }

  getCurrencies() {
    this.currencyService.getCurrencies().subscribe(data => {
      this.currencies = data;
    });
  }

}
