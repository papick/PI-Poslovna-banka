import {Component, OnInit} from "@angular/core";
import {CurrencyService} from "../../service/currencyService";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {ExchangeRateService} from "../../service/exchangeRateService";
import {ExchangeRateInCurrencyService} from "../../service/exchangeRateInCurrencyService";

@Component ({
  selector: 'app-exchange-rate',
  templateUrl: './exchange-rate.component.html',
  styleUrls: ['./exchange-rate.component.css']
})

export class ExchangeRateComponent implements OnInit {

  idBank;

  exchangeRates = [];
  datesBefore = [];

  activeExchRate;
  activeExchRatesInCurrency = [];

  constructor( private exchangeRateService: ExchangeRateService,
               private exchangeRateInCurrencyService: ExchangeRateInCurrencyService,
               protected router: Router,
               private route: ActivatedRoute) {

  }

  ngOnInit(): void {

    this.idBank = this.route.snapshot.params.idBank;

    this.exchangeRateService.getExchangeRates(this.idBank).subscribe(data => {
      this.exchangeRates = data;

      for(let er of this.exchangeRates) {

        let dateFrom = new Date(er.appliedFromDate);
        let dateToday = new Date();

        if(dateFrom <= dateToday) {
          this.datesBefore.push(er);
        }

      }

      this.activeExchRate = this.datesBefore[0];
      this.getExchangeRatesInCurrency(this.activeExchRate.id);

      for(let er of this.datesBefore) {

        let dateFrom = new Date(er.appliedFromDate);
        let dateActive = new Date(this.activeExchRate.appliedFromDate);

        if(dateFrom > dateActive) {

          this.activeExchRate = er;
        }

      }


    })






  }


  newExchangeRate() {

    this.router.navigateByUrl('bank/' + this.idBank + '/form-exchange-rate');


  }

  onChange(value) {

    for(let er of this.exchangeRates) {
      if(value === er.appliedFromDate) {
        this.activeExchRate = er;
        this.getExchangeRatesInCurrency(this.activeExchRate.id);
      }
    }
  }


  exchangeRateInCurrency() {

    this.router.navigateByUrl('bank/' + this.idBank + '/' + this.activeExchRate.id + '/form-exchange-rate-in-currency');

  }

  getExchangeRatesInCurrency(id: any) {

    this.exchangeRateInCurrencyService.getExchangeRatesInCurrency(id).subscribe(data => {

      this.activeExchRatesInCurrency = data;

      for(let it of this.activeExchRatesInCurrency) {
        console.log(it);
      }

    })

  }

}
