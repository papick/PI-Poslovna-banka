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

  idBank;
  public form: FormGroup;
  public name: AbstractControl;
  public shortname: AbstractControl;
  public adress: AbstractControl;
  public phonenumber: AbstractControl;
  public jmbg: AbstractControl;
  public email: AbstractControl;
  values = [];
  currencies = [];
  methodName = 'Dodaj';
  editResponse;

  individual = {
    name: '',
    abbreviatedName: '',
    adress: '',
    phoneNumber: '',
    jmbg: '',
    email: '',
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

    });

    this.name = this.form.controls['name'];
    this.shortname = this.form.controls['shortname'];
    this.adress = this.form.controls['adress'];
    this.phonenumber = this.form.controls['phonenumber'];
    this.jmbg = this.form.controls['jmbg'];
    this.email = this.form.controls['email'];
  }

  ngOnInit() {
    const m = this.route.snapshot.params.mode;

    if (m === 'izmeni') {
      this.methodName = 'Izmeni';
      const id = this.route.snapshot.params.id;
      this.clientService.getIndividual(id).subscribe(data => {
        this.form.controls['name'].setValue(data.name);
        this.form.controls['shortname'].setValue(data.abbreviatedName);
        this.form.controls['adress'].setValue(data.adress);
        this.form.controls['phonenumber'].setValue(data.phoneNumber);
        this.form.controls['jmbg'].setValue(data.jmbg);
        this.form.controls['email'].setValue(data.email);
      });


    } else {
      this.methodName = 'Dodaj';
    }

  }

  addIndividual() {

    this.idBank = this.route.snapshot.params.idBank;
    this.individual.name = this.name.value;
    this.individual.abbreviatedName = this.shortname.value;
    this.individual.adress = this.adress.value;
    this.individual.phoneNumber = this.phonenumber.value;
    this.individual.jmbg = this.jmbg.value;
    this.individual.email = this.email.value;

    this.clientService.addIndividual(this.individual).toPromise()
      .then(data => {
        const idBank = this.route.snapshot.params.idBank;
        this.router.navigateByUrl('bank/' + idBank + '/bankAccounts');
      });
  }

  confirmClick() {
    if (this.methodName === 'Dodaj') {
      this.addIndividual();
    } else {
      this.editIndividual();
    }
  }

  editIndividual() {
    const id = this.route.snapshot.params.id;
    this.idBank = this.route.snapshot.params.idBank;
    this.individual.name = this.name.value;
    this.individual.abbreviatedName = this.shortname.value;
    this.individual.adress = this.adress.value;
    this.individual.phoneNumber = this.phonenumber.value;
    this.individual.jmbg = this.jmbg.value;
    this.individual.email = this.email.value;

    this.clientService.editIndividual(this.individual, id).subscribe(data => {
      this.editResponse = data;
      this.router.navigateByUrl('bank/' + this.idBank + '/individuals');
    });
  }
}
