import {Component, OnInit} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ExchangeRateModel} from "../../model/exchangeRate.model";
import {ExchangeRateService} from "../../service/exchangeRateService";


@Component ({
  selector: 'app-exchange-rate-form',
  templateUrl: './exchange-rate-form.component.html',
  styleUrls: ['./exchange-rate-form.component.css']
})

export class ExchangeRateFormComponent implements OnInit {

  idBank;

  public form: FormGroup;
  public validFrom: AbstractControl;

  constructor(private exchangeRateService: ExchangeRateService,
              protected router: Router,
              private fb: FormBuilder,
              private route: ActivatedRoute,
              ) {

    this.form = this.fb.group({
      'validFrom': ['', Validators.compose([Validators.required])],
    })

    this.validFrom = this.form.controls['validFrom'];
  }

  ngOnInit(): void {

    this.idBank = this.route.snapshot.params.idBank;

  }

  confirmClick() {


    const exchangeRate = new ExchangeRateModel(
      this.idBank,
      this.validFrom.value,
    );

    this.exchangeRateService.addNewExchangeRate(exchangeRate).toPromise()
      .then(data => {

        this.router.navigateByUrl('bank/' + this.idBank + '/exchangeRate');
      })

  }

  exit() {

    this.router.navigateByUrl('bank/' + this.idBank + '/exchangeRate');
  }

}
