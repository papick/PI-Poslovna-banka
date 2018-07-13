import {Component, OnInit} from "@angular/core";
import {ExchangeRateService} from "../../service/exchangeRateService";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CurrencyService} from "../../service/currencyService";
import {ExchangeRateInCurrencyService} from "../../service/exchangeRateInCurrencyService";
import {ExchangeRateInCurrencyModel} from "../../model/exchangeRateInCurrency.model";

@Component ({
  selector: 'app-exchange-rate-in-currency-form',
  templateUrl: './exchange-rate-in-currency-form.component.html',
  styleUrls: ['./exchange-rate-in-currency-form.component.css']
})

export class ExchangeRateInCurrencyFormComponent implements OnInit {

  idBank;
  idExchangeRate;

  public form: FormGroup;
  public buying: AbstractControl;
  public middle: AbstractControl;
  public sell: AbstractControl;
  public primaryCurrency: AbstractControl;
  public toOtherCurrency: AbstractControl;


  currencies = [];

  constructor(private exchangeRateInCurrencyService: ExchangeRateInCurrencyService,
              private currencyService: CurrencyService,
              protected router: Router,
              private fb: FormBuilder,
              private route: ActivatedRoute,) {

    this.form = this.fb.group({
      'buying': ['', Validators.compose([Validators.required, Validators.pattern('[0-9]+[,]?[0-9]+')])],
      'middle': ['', Validators.compose([Validators.required, Validators.pattern('[0-9]+[,]?[0-9]+')])],
      'sell': ['', Validators.compose([Validators.required, Validators.pattern('[0-9]+[,]?[0-9]+')])],
      'primaryCurrency': [''],
      'toOtherCurrency': [''],
    })

    this.buying = this.form.controls['buying'];
    this.middle = this.form.controls['middle'];
    this.sell = this.form.controls['sell'];
    this.primaryCurrency = this.form.controls['primaryCurrency'];
    this.toOtherCurrency = this.form.controls['toOtherCurrency'];

  }

  ngOnInit(): void {

    this.idBank = this.route.snapshot.params.idBank;
    this.idExchangeRate = this.route.snapshot.params.idExchangeRate;

    this.currencyService.getCurrencies().subscribe(data => {
      this.currencies = data.currencies;

      for(let cur of this.currencies) {
        console.log(cur.name)
      }
    })
  }

  exit() {

    this.router.navigateByUrl('bank/' + this.idBank + '/exchangeRate');

  }

  confirmClick() {

    if(this.primaryCurrency.value === this.toOtherCurrency.value) {
      alert('Valute moraju biti razlicite!')
    }
    else if(this.primaryCurrency.value === ""){
      alert('Obavezan unos primarne valute!')
    }
    else if(this.toOtherCurrency.value === ""){
      alert('Obavezan unos prema valuti!')
    }
    else {

      const exchangeRateInCurrency = new ExchangeRateInCurrencyModel(
        this.idExchangeRate,
        this.primaryCurrency.value,
        this.toOtherCurrency.value,
        this.buying.value,
        this.middle.value,
        this.sell.value

      );

      console.log(exchangeRateInCurrency)

      this.exchangeRateInCurrencyService.addNewExchangeRateInCurrency(exchangeRateInCurrency).toPromise()
        .then(data => {

          this.router.navigateByUrl('bank/' + this.idBank + '/exchangeRate');
        })

    }

  }

}
