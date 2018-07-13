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
  items = []
  cities;

  nameSearch:string='';
  postalSearch : string='';
  codeSearch : string='';
  countrySearch : string='';

  constructor(private cityService: CityService,
              protected router: Router,
              private route: ActivatedRoute) {
  }




  ngOnInit() {

    const country = this.route.snapshot.params.country;


    if (country === 'by-country') {
      const id = this.route.snapshot.params.id;
      if (id == 'undefined') {
        const idBank = this.route.snapshot.params.idBank;
        this.router.navigateByUrl('bank/' + idBank + '/countries');
      }else {
        this.cityService.getCitesByCountry(id).subscribe(data => {
          this.items = data.cities;
          this.cities = data.cities;
        })
      }
    } else {
      this.cityService.getCities().subscribe(data => {
        this.items = data.cities;
        this.cities = data.cities;
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

  search(){
    this.items = this.cities.filter(a =>  a.name.toLowerCase().includes(this.nameSearch.toLowerCase()) &&
                                          a.code.toLowerCase().includes(this.codeSearch.toLowerCase()) &&
                                          a.postNum.includes(this.postalSearch) &&
                                          a.country.name.toLowerCase().includes(this.countrySearch.toLowerCase())
                                          );
  }


}
