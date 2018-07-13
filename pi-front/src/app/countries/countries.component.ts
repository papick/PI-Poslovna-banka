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
  countries;

  nameSearch:string='';
  codeSearch : string='';

  constructor(private countryService: CountryService,
              protected router: Router,
              private route: ActivatedRoute,) {
  }

  ngOnInit() {

    this.countryService.getCountries().subscribe(data => {
      this.items = data.countries;
      this.countries = data.countries;
    })
  }

  add() {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('/bank/' + idBank + '/country/country/add');

  }

  deleteCountry(id): any {
    this.countryService.deleteCountry(id).toPromise()
      .then(data => {
        this.items = this.items.filter(el => el.id != id);

      })
  }

  forCities(id): any {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('/bank/' + idBank + '/countries/' + id);
  }

  editCountry(id): any {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('bank/' + idBank + '/country/edit/' + id);

  }


  showCities() {
    const idBank = this.route.snapshot.params.idBank;
    const id = this.route.snapshot.params.id;

    this.router.navigateByUrl('bank/' + idBank + '/city/by-country/' + id)

  }

  search(){
    this.items = this.countries.filter(a => a.name.toLowerCase().includes(this.nameSearch.toLowerCase()) &&
                                            a.code.toLowerCase().includes(this.codeSearch.toLowerCase())
                                          );
  }


}
