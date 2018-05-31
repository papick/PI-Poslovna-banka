import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CurrencyService} from "../../service/currencyService";
import {BankAccountService} from "../../service/bankAccountService";
import {ClientService} from "../../service/clientService";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-add-individual',
  templateUrl: './add-individual.component.html',
  styleUrls: ['./add-individual.component.css']
})
export class AddIndividualComponent implements OnInit {

  sklj;
  currencies = [];
  inds = [];

  idBank;
  public form: FormGroup;
  public accountNumber: AbstractControl;
  public currency: AbstractControl;
  public legal: AbstractControl;
  public mailreporting: AbstractControl;

  bankAccount = {
    number: '',
    dateOfOpenning: '',
    valid: true,
    bank: '',
    legalEntity: '',
    individual: '',
    currency: '',
    mailReporting: false
  };

  constructor(private currencyService: CurrencyService,
              private clientService: ClientService,
              private fb: FormBuilder,
              private bankAccountService: BankAccountService, protected route: ActivatedRoute) {
    this.form = this.fb.group({
    'accountNumber': ['', Validators.compose([Validators.required])],
    'currency': ['', Validators.compose([Validators.required])],
    'legal': ['', Validators.compose([Validators.required])],
    'mailreporting': [''],

  });

    this.accountNumber = this.form.controls['accountNumber'];
    this.currency = this.form.controls['currency'];
    this.legal = this.form.controls['legal'];
    this.mailreporting = this.form.controls['mailreporting'];}

  ngOnInit() {
    this.getCurrencies();
    this.getIndividuals();
  }

  getCurrencies() {
    this.currencyService.getCurrencies().subscribe(data => {
      this.currencies = data;
    });
  }

  getIndividuals() {
    this.clientService.getIndividualEntities().subscribe(data => this.inds = data);
  }

  addAccount() {
    this.bankAccount.bank = this.route.snapshot.params.idBank;
    this.bankAccount.individual = this.legal.value;
    this.bankAccount.currency = this.currency.value;
    this.bankAccount.number = this.accountNumber.value;
    this.bankAccount.mailReporting = this.mailreporting.value;


    this.bankAccountService.addAccount(this.bankAccount).subscribe(data => this.sklj = data);
  }
}
