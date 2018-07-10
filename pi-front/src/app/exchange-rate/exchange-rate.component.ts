import {Component, OnInit} from "@angular/core";
import {CurrencyService} from "../../service/currencyService";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";

@Component ({
  selector: 'app-exchange-rate',
  templateUrl: './exchange-rate.component.html',
  styleUrls: ['./exchange-rate.component.css']
})

export class ExchangeRateComponent implements OnInit {

  idBank;

  constructor( protected router: Router,
               private route: ActivatedRoute,) {

  }

  ngOnInit(): void {

    this.idBank = this.route.snapshot.params.idBank;

  }


  newExchangeRate() {

    this.router.navigateByUrl('bank/' + this.idBank + '/form-exchange-rate');

  }

}
