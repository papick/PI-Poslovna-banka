import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  templateUrl: './bank.component.html',
  styleUrls: ['./bank.component.scss'],

})

export class BankComponent implements OnInit {
  imageRoute;
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
    const click = this.route.snapshot.params.click;
    if (this.idBank == 1) {
      this.imageRoute = '../../../assets/images/erste.jpg';
    } else if (this.idBank == 2) {
      this.imageRoute = '../../../assets/images/intesa.jpg';
    } else {
      this.imageRoute = '../../../assets/images/banka.jpg';
    }



    if (click === 'home') {

      this.home = true;
      this.countries = false;
      this.nalogZaIsplatu = false;
      this.city = false;
    } else if (click === 'nalog-za-splatu') {
      this.nalogZaIsplatu = true;
      this.city = false;
      this.countries = false;
    } else if (click === 'countries') {
      this.home = false;
      this.countries = true;
      this.nalogZaIsplatu = false;
      this.city = false;
    } else if (click === 'city') {
      this.home = false;
      this.countries = false;
      this.nalogZaIsplatu = false;
      this.city = true;
    } else {

    }

  }

  homePage() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/home');
    location.reload();
  }

  getCountries() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/countries');
    location.reload();
  }

  getCities() {
    location.reload();
    this.router.navigateByUrl('/bank/' + this.idBank + '/city');
  }

}
