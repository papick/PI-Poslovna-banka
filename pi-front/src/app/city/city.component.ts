import {CountryService} from "../../service/countryService";


import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CityService} from "../../service/cityService";
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {


  constructor(private cityService: CityService,
              protected router: Router,
              private route: ActivatedRoute,
              private countryService: CountryService,
              private fb: FormBuilder) {

  }


  items = []

  ngOnInit() {
    this.cityService.getCities().subscribe(data => {
      this.items = data.cities;
    })
    /*
    const mode = this.route.snapshot.params.mode;
    if (mode == 'all') {
      this.cityService.getCities().subscribe(data => {
        this.items = data.cities;
      })
    }
    else if (mode == 'by-country') {
      const id = this.route.snapshot.params.id;
      this.cityService.getCitesByCountry(id).subscribe(data => {
        this.items = data.cities;
      })
    } else {
    }*/
  }

  add() {
    this.router.navigateByUrl('/city/a/d/d/add');
  }

  deleteCity(id): any {
    this.cityService.deleteCity(id).toPromise()
      .then(data => {
        this.items = this.items.filter(el => el.id != id);

      })
  }

  editCity(id): any {
    this.router.navigateByUrl('city/e/d/i/t/edit/' + id)
  }


}
