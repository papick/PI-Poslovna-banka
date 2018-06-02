import {Component, OnInit} from '@angular/core';
import {CurrencyService} from "../../service/currencyService";
import {ClientService} from "../../service/clientService";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {BankAccountService} from "../../service/bankAccountService";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-add-legal-account',
  templateUrl: './add-legal-account.component.html',
  styleUrls: ['./add-legal-account.component.css']
})
export class AddLegalAccountComponent implements OnInit {

  sklj;
  currencies = [];
  legalEntities = [];
  methodName = 'Dodaj';
  editResponse;

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
              private bankAccountService: BankAccountService, protected route: ActivatedRoute,
              private router: Router) {
    this.form = this.fb.group({
      'accountNumber': ['', Validators.compose([Validators.required])],
      'currency': ['', Validators.compose([Validators.required])],
      'legal': ['', Validators.compose([Validators.required])],
      'mailreporting': [''],

    });

    this.accountNumber = this.form.controls['accountNumber'];
    this.currency = this.form.controls['currency'];
    this.legal = this.form.controls['legal'];
    this.mailreporting = this.form.controls['mailreporting'];
  }

  ngOnInit() {
    this.getCurrencies();
    this.getLegals();

    const m = this.route.snapshot.params.mode;

    if (m === 'edit') {
      this.methodName = 'Izmeni';
      const id = this.route.snapshot.params.id;
      this.bankAccountService.getBankAccount(id).subscribe(data => {
        this.form.controls['accountNumber'].setValue(data.number);
        this.form.controls['currency'].setValue(data.currency.name);
        this.form.controls['legal'].setValue(data.legalEntity.name);
        this.form.controls['mailreporting'].setValue(data.mailReporting);
      });
    } else {
      this.methodName = 'Dodaj';
    }
  }

  getCurrencies() {
    this.currencyService.getCurrencies().subscribe(data => {
      this.currencies = data.currencies;
    });
  }

  getLegals() {
    this.clientService.getLegalEntities().subscribe(data => this.legalEntities = data);
  }

  confirmClick() {
    if (this.methodName === 'Dodaj') {
      this.addAccount();
    } else {
      this.editAccount();
    }
  }

  editAccount() {
    const id = this.route.snapshot.params.id;
    this.bankAccount.bank = this.route.snapshot.params.idBank;
    this.bankAccount.legalEntity = this.legal.value;
    this.bankAccount.currency = this.currency.value;
    this.bankAccount.number = this.accountNumber.value;
    this.bankAccount.mailReporting = this.mailreporting.value;
    this.bankAccountService.editLegalBankAccount(this.bankAccount, id).subscribe(data => {
      this.editResponse = data;
      this.router.navigateByUrl('bank/' + this.bankAccount.bank + '/bankAccounts');
    });
  }

  addAccount() {
    this.bankAccount.bank = this.route.snapshot.params.idBank;
    this.bankAccount.legalEntity = this.legal.value;
    this.bankAccount.currency = this.currency.value;
    this.bankAccount.number = this.accountNumber.value;
    this.bankAccount.mailReporting = this.mailreporting.value;


    this.bankAccountService.addAccountLegalEntity(this.bankAccount).subscribe(data => {
      this.sklj = data
      this.router.navigateByUrl('bank/' + this.bankAccount.bank + '/bankAccounts');
    });

  }

}
