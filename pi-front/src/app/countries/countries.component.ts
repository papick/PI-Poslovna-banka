import {CountryService} from "../../service/countryService";


import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent implements OnInit {

  items = []

  constructor(private countryService: CountryService,
              protected router: Router,
              private route: ActivatedRoute,) {
  }

  ngOnInit() {

    this.countryService.getCountries().subscribe(data => {
      this.items = data.countries;
    })
  }

  add() {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('/bank/' + idBank + '/country/add');

  }

  deleteCountry(id): any {
    this.countryService.deleteCountry(id).toPromise()
      .then(data => {
        this.items = this.items.filter(el => el.id != id);

      })
  }

  forCities(id): any {

  }

  editCountry(id): any {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('bank/' + idBank + '/country/edit/' + id);

  }


  showCities() {
  }


}
