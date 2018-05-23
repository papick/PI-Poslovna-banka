import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  templateUrl: './bank.component.html',
  styleUrls: ['./bank.component.scss'],

})

export class BankComponent implements OnInit {
  imageRoute = '../../../assets/images/erste.jpg';
  nalogZaIsplatu = false;
  idBank;
  home = true;
  countries = false;
  city = false;

  constructor(protected route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.idBank = this.route.snapshot.params.idBank;
  }

  nalogIsplata() {
    this.nalogZaIsplatu = true;
    this.city = false;
    this.countries = false;

  }

  getCountries() {
    this.home = false;
    this.countries = true;
    this.nalogZaIsplatu = false;
    this.city = false;

  }

  homePage() {
    this.home = true;
    this.countries = false;
    this.nalogZaIsplatu = false;
    this.city = false;


  }

  getCities() {
    this.home = false;
    this.countries = false;
    this.nalogZaIsplatu = false;
    this.city = true;
  }


}
