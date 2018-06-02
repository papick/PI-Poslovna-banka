import {Component, OnInit} from '@angular/core';
import {ActivityService} from "../../service/activityService";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CurrencyService} from "../../service/currencyService";
import {ActivatedRoute, Router} from "@angular/router";
import {ClientService} from "../../service/clientService";

@Component({
  selector: 'app-add-bank-account-legals',
  templateUrl: './add-legals.component.html',
  styleUrls: ['./add-legals.component.css']
})
export class AddLegalsComponent implements OnInit {

  idBank;
  methodName = 'Dodaj';
  public form: FormGroup;
  public name: AbstractControl;
  public shortname: AbstractControl;
  public responsibleperson: AbstractControl;
  public activity: AbstractControl;
  public adress: AbstractControl;
  public phonenumber: AbstractControl;
  public jmbg: AbstractControl;
  public email: AbstractControl;
  public mbr: AbstractControl;
  public taxauthority: AbstractControl;
  public pib: AbstractControl;
  public deliveringadress: AbstractControl;
  values = [];
  currencies = [];
  editResponse;

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
  };

  constructor(private activityService: ActivityService,
              private fb: FormBuilder,
              private  currencyService: CurrencyService,
              private clientService: ClientService,
              protected route: ActivatedRoute,
              private router: Router) {
    this.form = this.fb.group({
      'name': ['', Validators.compose([Validators.required])],
      'shortname': ['', Validators.compose([Validators.required])],
      'activity': ['', Validators.compose([Validators.required])],
      'adress': ['', Validators.compose([Validators.required])],
      'phonenumber': ['', Validators.compose([Validators.required])],
      'jmbg': ['', Validators.compose([Validators.required])],
      'email': ['', Validators.compose([Validators.required])],
      'mbr': ['', Validators.compose([Validators.required])],
      'taxauthority': ['', Validators.compose([Validators.required])],
      'pib': ['', Validators.compose([Validators.required])],
      'deliveringadress': ['', Validators.compose([Validators.required])],
      'responsibleperson': ['', Validators.compose([Validators.required])],

    });
    this.name = this.form.controls['name'];
    this.shortname = this.form.controls['shortname'];
    this.activity = this.form.controls['activity'];
    this.adress = this.form.controls['adress'];
    this.phonenumber = this.form.controls['phonenumber'];
    this.jmbg = this.form.controls['jmbg'];
    this.email = this.form.controls['email'];
    this.mbr = this.form.controls['mbr'];
    this.taxauthority = this.form.controls['taxauthority'];
    this.pib = this.form.controls['pib'];
    this.deliveringadress = this.form.controls['deliveringadress'];
    this.responsibleperson = this.form.controls['responsibleperson'];

  }

  ngOnInit() {
    const m = this.route.snapshot.params.mode;

    this.selectItem();
    this.getCurrencies();

    if (m === 'edit') {
      this.methodName = 'Izmeni';
      const id = this.route.snapshot.params.id;
      this.clientService.getLegalEntity(id).subscribe(data => {
        this.form.controls['name'].setValue(data.name);
        this.form.controls['shortname'].setValue(data.abbreviatedName);
        this.form.controls['adress'].setValue(data.adress);
        this.form.controls['activity'].setValue(data.activity.code);
        this.form.controls['phonenumber'].setValue(data.phoneNumber);
        this.form.controls['jmbg'].setValue(data.jmbg);
        this.form.controls['email'].setValue(data.email);
        this.form.controls['mbr'].setValue(data.mbr);
        this.form.controls['taxauthority'].setValue(data.taxAuthority);
        this.form.controls['pib'].setValue(data.pib);
        this.form.controls['deliveringadress'].setValue(data.deliveringAdress);
        this.form.controls['responsibleperson'].setValue(data.responsiblePerson);
      });
    } else {
      this.methodName = 'Dodaj';
    }
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

  addLegalEntity() {

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


    this.clientService.addLegal(this.legalEntity).toPromise()
      .then(data => {
        const idBank = this.route.snapshot.params.idBank;
        this.router.navigateByUrl('bank/' + idBank + '/legals');

      });

  }

  confirmClick() {
    if (this.methodName === 'Dodaj') {
      this.addLegalEntity();
    } else {
      this.editLegalEntity();
    }
  }

  editLegalEntity() {
    const id = this.route.snapshot.params.id;
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
    this.clientService.editLegalEntity(this.legalEntity, id).subscribe(data => {
      this.editResponse = data;
      this.router.navigateByUrl('bank/' + this.idBank + '/legals');
    });
  }


}
