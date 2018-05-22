import {Component, OnInit} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CountryService} from "../../service/countryService";
import {CountryModel} from "../../model/country.model";
import {CityService} from "../../service/cityService";
import {CityModel} from "../../model/city.model";

@Component({
  templateUrl: './addCity.component.html',
})
export class AddCityComponent implements OnInit {

  public form: FormGroup;
  public name: AbstractControl;
  public code: AbstractControl;
  public postNum: AbstractControl;
  public country: AbstractControl;

  public method_name = 'DODAJ';
  public mode: String;
  countries = []
  c: string;

  constructor(protected router: Router,
              private fb: FormBuilder,
              private route: ActivatedRoute,
              private cityService: CityService,
              private countryService: CountryService) {
    this.form = this.fb.group({
      'name': ['', Validators.compose([Validators.required])],
      'code': ['', Validators.compose([Validators.required])],
      'postNum': [''],
      'country': ['', Validators.compose([Validators.required])],

    })
    this.name = this.form.controls['name'];
    this.code = this.form.controls['code'];
    this.postNum = this.form.controls['postNum'];
    this.country = this.form.controls['country'];


  }

  ngOnInit() {
    const m = this.route.snapshot.params.mode;

    this.countryService.getCountries().subscribe(data => {
      this.countries = data.countries;

    })
    if (m == 'edit') {
      this.method_name = 'IZMENI';
      const id = this.route.snapshot.params.id;
      this.cityService.getCity(id).subscribe(data => {
        this.form.controls['name'].setValue(data.name);
        this.form.controls['code'].setValue(data.code);
        this.form.controls['postNum'].setValue(data.postNum);
        this.form.controls['country'].setValue(data.country.name);
      })


    } else if (m == 'add') {
  

    }


  }

  confirmClick() {
    if (this.method_name === 'DODAJ') {
      this.createCity();
    } else {
      this.editCity();
    }
  }

  createCity(): any {
    const city = new CityModel(
      this.name.value,
      this.code.value,
      this.postNum.value,
      this.country.value,
    );
    this.cityService.createCity(city).toPromise()
      .then(data => {

        const idBank = this.route.snapshot.params.idBank;
        this.router.navigateByUrl('bank/' + idBank);
      })
  }

  editCity() {
    const city = new CityModel(
      this.name.value,
      this.code.value,
      this.postNum.value,
      this.country.value,
    );
    const id = this.route.snapshot.params.id;
    this.cityService.editCity(city, id).toPromise()
      .then(data => {

        const idBank = this.route.snapshot.params.idBank;
        this.router.navigateByUrl('bank/' + idBank);
      })
  }

  exit() {
  }

}
