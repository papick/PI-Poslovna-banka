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

    this.cityService.getCities().subscribe(data => {
      this.items = data.cities;
    })

    /*   const mode = this.route.snapshot.params.mode;
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
