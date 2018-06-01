import {CountryService} from "../../service/countryService";
import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from '@angular/common';


@Component({
  selector: 'app-root-combo-zoom-countries',
  templateUrl: './combo-zoom-countries.component.html',
  styleUrls: ['./combo-zoom-countries.component.css']
})

export class ComboZoomCountriesComponent implements OnInit {

  items = []
  boolFlag: boolean = true;
  forColour: string;

  country_name: any;

  constructor(private  countryService: CountryService,
              protected  router: Router,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit() {

    this.countryService.getCountries().subscribe(data => {
      this.items = data.countries;
    })
  }


  select(id, name) {

    this.boolFlag = false;
    this.forColour = name;

    this.country_name = name;

  }

  choose() {

   localStorage.setItem('country_currency', this.country_name);
    this.location.back();
  }

  close() {
    this.location.back();
  }

}
