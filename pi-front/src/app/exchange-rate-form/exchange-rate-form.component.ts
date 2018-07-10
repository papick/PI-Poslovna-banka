import {Component, OnInit} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";


@Component ({
  selector: 'app-exchange-rate-form',
  templateUrl: './exchange-rate-form.component.html',
  styleUrls: ['./exchange-rate-form.component.css']
})

export class ExchangeRateFormComponent implements OnInit {

  idBank;

  public form: FormGroup;
  public validFrom: AbstractControl;

  constructor(protected router: Router,
              private fb: FormBuilder,
              private route: ActivatedRoute) {

    this.form = this.fb.group({
      'validFrom': ['', Validators.compose([Validators.required])],
    })

    this.validFrom = this.form.controls['validFrom'];
  }

  ngOnInit(): void {

    this.idBank = this.route.snapshot.params.idBank;

  }

  confirmClick() {

    

  }

  exit() {

    this.router.navigateByUrl('bank/' + this.idBank + '/exchangeRate');
  }

}
