import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  templateUrl: './bank.component.html',
  styleUrls: ['./bank.component.scss'],

})

export class BankComponent implements OnInit {
  imageRoute;
  paymentCheck = false;
  idBank;
  home = true;
  countries = false;
  city = false;
  activities = false;

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
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
    } else if (click === 'payment-check') {
      this.paymentCheck = true;
      this.city = false;
      this.countries = false;
      this.activities = false;
    } else if (click === 'countries') {
      this.home = false;
      this.countries = true;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
    } else if (click === 'city') {
      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = true;
      this.activities = false;
    } else if (click === 'activities') {
      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = true;
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

  paymentCheckk() {
    location.reload();

    this.router.navigateByUrl('/bank/' + this.idBank + '/payment-check');
  }

  getActivities() {
    location.reload();

    this.router.navigateByUrl('/bank/' + this.idBank + '/activities');
  }

}
