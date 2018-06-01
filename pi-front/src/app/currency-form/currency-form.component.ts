import {Component, OnInit} from "@angular/core";
import {CurrencyService} from "../../service/currencyService";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from '@angular/common';
import {CurrencyModel} from "../../model/currency.model";

@Component({
  selector: 'app-currency-form',
  templateUrl: './currency-form.component.html',
  styleUrls: ['./currency-form.component.css']
})
export class CurrencyFormComponent implements OnInit {

  public form: FormGroup;
  public officialCode: AbstractControl;
  public name: AbstractControl;
  public country: AbstractControl;
  public domicilna: AbstractControl;

  public title = 'Dodavanje nove valute';
  public method_name = 'DODAJ';



  constructor(private currencyService: CurrencyService,
              protected router: Router,
              private fb: FormBuilder,
              private route: ActivatedRoute,
              private location: Location) {

    this.form = this.fb.group({
      'officialCode': ['', Validators.compose([Validators.required])],
      'name': ['', Validators.compose([Validators.required])],
      'country': ['', Validators.compose([Validators.required])],
      'domicilna': [''],
    })

    this.officialCode = this.form.controls['officialCode'];
    this.name = this.form.controls['name'];
    this.country = this.form.controls['country'];
    this.domicilna = this.form.controls['domicilna'];

  }

  ngOnInit() {

    const mode = this.route.snapshot.params.mode;

    const country_name  = localStorage.getItem('country_currency');
    this.form.controls['country'].setValue(country_name);

    if (mode == 'edit') {

      this.method_name = 'IZMENI';
      this.title = 'Izmena valute';

      const id = this.route.snapshot.params.id;

      this.currencyService.getCurrency(id).subscribe(data => {
        this.form.controls['officialCode'].setValue(data.officialCode);
        this.form.controls['name'].setValue(data.name);
        this.form.controls['country'].setValue(data.country.name);
        this.form.controls['domicilna'].setValue(data.domicilna);

        }
      )
    }


  }

  close() {
    this.location.back();
  }

  comboZoomCountry() {
    this.router.navigateByUrl('currencies/currency-form/add/combo-zoom/countries');
  }


  confirmClick() {

    if (this.method_name === 'DODAJ') {
      this.confirmAdding();
    } else {
      this.confirmUpdating();
    }
  }


  confirmAdding(): any {

    const currency = new CurrencyModel(
        this.officialCode.value,
        this.name.value,
        this.domicilna.value,
        this.country.value,
    );

    this.currencyService.addNewCurrency(currency).toPromise()
      .then(data => {

        const idBank = localStorage.getItem('idBank');
        this.router.navigateByUrl('bank/' + idBank + '/currencies');

      })

  }

  confirmUpdating(): any {

    const currency = new CurrencyModel(
      this.officialCode.value,
      this.name.value,
      this.domicilna.value,
      this.country.value,
    );

    const id = this.route.snapshot.params.id;

    this.currencyService.updateCurrency(currency, id).toPromise()
      .then(data => {
        const idBank = localStorage.getItem('idBank');
        this.router.navigateByUrl('bank/' + idBank + '/currencies');
      })

  }


}
