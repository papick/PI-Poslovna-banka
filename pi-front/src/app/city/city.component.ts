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


  selectedRow: number;

  constructor(private cityService: CityService,
              protected router: Router,
              private route: ActivatedRoute) {
  }


  items = []

  ngOnInit() {

    const country = this.route.snapshot.params.country;
    console.log(country)
    if (country == 'by-country') {
      const id = this.route.snapshot.params.id;
      console.log(id)
      this.cityService.getCitesByCountry(id).subscribe(data => {
        this.items = data.cities;
      })
    } else {
      this.cityService.getCities().subscribe(data => {
        this.items = data.cities;
      })
    }
  }


  add() {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('bank/' + idBank + '/country/city/add');

  }

  deleteCity(id): any {
    this.cityService.deleteCity(id).toPromise()
      .then(data => {
        this.items = this.items.filter(el => el.id != id);

      })
  }

  editCity(id): any {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('bank/' + idBank + '/country/city/edit/' + id);

  }


}
