import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import { ClearingService } from "../../service/clearingService";

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
  exchangeRate = false;

  currencies = false;

  payOrder = false;
  transferOrder = false;
  addLegalAccount = false;
  addIndividualAccount = false;
  legals = false;
  individuals = false;

  click;

  constructor(protected route: ActivatedRoute,
              private router: Router,
              private clearingService : ClearingService) {
  }

  ngOnInit() {

    this.idBank = this.route.snapshot.params.idBank;
    this.click = this.route.snapshot.params.click;

    console.log(this.click);

    localStorage.setItem('idBank', this.idBank);

    if (this.idBank == 1) {
      this.imageRoute = '../../../assets/images/erste.jpg';
    } else if (this.idBank == 2) {
      this.imageRoute = '../../../assets/images/intesa.jpg';
    } else {
      this.imageRoute = '../../../assets/images/banka.jpg';
    }


    if (this.click === 'home') {

      this.showHome();

    } else if (this.click === 'payment-check') {


    } else if (this.click === 'countries') {

      this.showCountries();

    } else if (this.click === 'city') {

      this.showCities();

    } else if (this.click === 'activities') {

      this.showActivities();

    } else if (this.click === 'bankAccounts') {

      this.showBankAccounts();

    } else if (this.click === 'payment-order') {

      this.showPaymentOrder();


    } else if (this.click === 'currencies') {

      this.showCurrencies();


    } else if (this.click === 'pay-order') {

      this.showPayOrder();

    } else if (this.click === 'transfer-order') {

      this.showTransferOrder();

    } else if (this.click === 'addLegalAccount') {

      this.showAddLegalAccount();

    } else if (this.click === 'addIndividualAccount') {

      this.showAddIndividualAccount();

    } else if (this.click === 'legals') {

      this.showLegals();

    } else if(this.click === 'individuals') {

      this.showIndividuals();
    }
    else if(this.click === 'exchangeRate') {

      this.showExchangeRate();
    }
  }

  clearing(){
    const bank = {id: this.idBank}
    this.clearingService.clearing(bank).subscribe( data => {
      alert("Exported clearings");
    })
  }

  homePage() {


    this.router.navigateByUrl('/bank/' + this.idBank + '/home');
    this.showHome();


  }

  getCountries() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/countries');
    this.showCountries();

  }

  getCities() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/city');
    this.showCities();

  }

  paymentOrderClick() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/payment-order');
    this.showPaymentOrder();
  }


  paymentCheckk() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/payment-check/paymanent/undefined');
    this.showPaymentCheck();
  }

  getActivities() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/activities');
    this.showActivities();
  }

  getBankAccounts() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/bankAccounts');
    this.showBankAccounts();
  }

  getCurrencies() {

    this.router.navigateByUrl('/bank/' + this.idBank + '/currencies');
    this.showCurrencies();
  }

  payCheck() {
    this.router.navigateByUrl('/bank/' + this.idBank + '/pay-order');
    this.showPayOrder();
  }

  transfer() {
    this.router.navigateByUrl('/bank/' + this.idBank + '/transfer-order');
    this.showTransferOrder();
  }

  legalsPage() {
    this.router.navigateByUrl('/bank/' + this.idBank + '/legals');
    this.showLegals();
  }

  individualsPage() {
    this.router.navigateByUrl('/bank/' + this.idBank + '/individuals');
    this.showIndividuals();
  }

  exchangeRateClick() {
    this.router.navigateByUrl('/bank/' + this.idBank + '/exchangeRate');
    this.showExchangeRate();
  }


  // divs handle functions

  showHome() {

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
    this.exchangeRate = false;
  }


  showCountries() {

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
    this.exchangeRate = false;
  }

  showPaymentCheck() {

    this.home = false;
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
    this.exchangeRate = false;
  }


  showCities() {

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
    this.exchangeRate = false;
  }


  showActivities() {

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
    this.exchangeRate = false;
  }


  showBankAccounts() {

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
    this.exchangeRate = false;
  }


  showPaymentOrder() {

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
    this.exchangeRate = false;
  }

  showCurrencies() {

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
    this.exchangeRate = false;
  }

  showPayOrder() {

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
    this.exchangeRate = false;
  }

  showTransferOrder() {

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
    this.exchangeRate = false;
  }


  showAddLegalAccount() {

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
    this.exchangeRate = false;
  }


  showAddIndividualAccount() {

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
    this.exchangeRate = false;
  }

  showLegals() {

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
    this.exchangeRate = false;
  }

  showIndividuals() {

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
    this.exchangeRate = false;

  }

  showExchangeRate() {

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
    this.individuals = false;
    this.exchangeRate = true;
  }


}
