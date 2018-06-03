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
  bankAccounts = false;
  paymentOrder = false;

  currencies = false;

  payOrder = false;
  transferOrder = false;
  addLegalAccount = false;
  addIndividualAccount = false;
  legals = false;
  individuals = false;


  constructor(protected route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {

    this.idBank = this.route.snapshot.params.idBank;
    const click = this.route.snapshot.params.click;

    localStorage.setItem('idBank', this.idBank);

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
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;

    } else if (click === 'payment-check') {
      this.paymentCheck = true;
      this.city = false;
      this.countries = false;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;

    } else if (click === 'countries') {

      this.home = false;
      this.countries = true;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;

    } else if (click === 'city') {
      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = true;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;

    } else if (click === 'activities') {
      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = true;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;

    } else if (click === 'bankAccounts') {

      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
      this.bankAccounts = true;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;

    } else if (click === 'payment-order') {

      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = true;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;


    } else if (click === 'currencies') {

      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = true;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;

    } else if (click === 'pay-order') {

      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = true;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;
    } else if (click === 'transfer-order') {

      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = true;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;

    } else if (click === 'addLegalAccount') {
      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = true;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = false;

    } else if (click === 'addIndividualAccount') {
      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = true;
      this.legals = false;
      this.individuals = false;
    } else if (click === 'legals') {
      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = true;
      this.individuals = false;
    } else if(click === 'individuals') {
      this.home = false;
      this.countries = false;
      this.paymentCheck = false;
      this.city = false;
      this.activities = false;
      this.bankAccounts = false;
      this.paymentOrder = false;
      this.currencies = false;
      this.payOrder = false;
      this.transferOrder = false;
      this.addLegalAccount = false;
      this.addIndividualAccount = false;
      this.legals = false;
      this.individuals = true;
    }
  }

  homePage() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/home');
    location.reload();

  }

  getCountries() {
    console.log('Je l radis jebo te konj');
    this.router.navigateByUrl('/bank/' + this.idBank + '/countries');
    location.reload();

  }

  getCities() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/city');
    location.reload();

  }

  paymentOrderClick() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/payment-order');
    location.reload();
  }


  paymentCheckk() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/payment-check/paymanent/undefined');
    location.reload();
  }

  getActivities() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/activities');
    location.reload();
  }

  getBankAccounts() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/bankAccounts');
    location.reload();
  }

  getCurrencies() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/currencies');
    location.reload();
  }

  payCheck() {
    this.router.navigateByUrl('/bank/' + this.idBank + '/pay-order');
    location.reload();
  }

  transfer() {
    this.router.navigateByUrl('/bank/' + this.idBank + '/transfer-order');
    location.reload();
  }

  legalsPage() {
    this.router.navigateByUrl('/bank/' + this.idBank + '/legals');
    location.reload();
  }

  individualsPage() {
    this.router.navigateByUrl('/bank/' + this.idBank + '/individuals');
    location.reload();
  }

}
