import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ReactiveFormsModule} from '@angular/forms';
import {LogInComponent} from "./log-in.component/log-in.component";
import {APP_BASE_HREF} from "@angular/common";
import {LogInService} from "../service/logInService";
import {BankComponent} from "./bank/bank.component";
import {PaymentCheckComponent} from "./payment-check/payment-check.component";
import {CountryService} from "../service/countryService";
import {CountriesComponent} from "./countries/countries.component";
import {AddCountryComponent} from "./addCountry/addCountry.component";
import {CityService} from "../service/cityService";
import {CityComponent} from './city/city.component';
import {AddCityComponent} from "./addCity/addCity.component";
import {ActivitiesComponent} from "./activities/activities.component";
import {ActivityService} from "../service/activityService";
import {AddActivitiesComponent} from "./addActivities/addActivities.component";
import {BankAccountsComponent} from './bank-accounts/bank-accounts.component';
import {ClientService} from "../service/clientService";
import {PaymentOrderComponent} from "./payment-order/payment-order.component";
import {AddLegalsComponent} from './add-legals/add-legals.component';
import { AddBankAccountIndividualComponent } from './add-bank-account-individual/add-bank-account-individual.component';
import {BankAccountService} from "../service/bankAccountService";
import {CurrencyService} from "../service/currencyService";
import {AnalyticsOfStatementService} from '../service/AnalyticsOfStatementService';
import {CurrenciesComponent} from "./currencies/currencies.component";
import {CurrencyFormComponent} from "./currency-form/currency-form.component";
import {ComboZoomCountriesComponent} from "./combo-zoom-countries/combo-zoom-countries.component";
import { PayCheckComponent } from './pay-check/pay-check.component';
import { TransferCheckComponent } from './transfer-check/transfer-check.component';
import { AddLegalAccountComponent } from './add-legal-account/add-legal-account.component';
import { AddIndividualComponent } from './add-individual/add-individual.component';
import { LegalsComponent } from './legals/legals.component';
import { ClientsComponent } from './clients/clients.component';
import { IndividualsComponent } from './individuals/individuals.component';
import {ExchangeRateComponent} from "./exchange-rate/exchange-rate.component";
import {RecessionService} from "../service/recessionService";


import {ButtonModule} from 'primeng/button';
import {DialogModule} from 'primeng/dialog';
import {DropdownModule} from 'primeng/dropdown';
import {FormsModule} from '@angular/forms';
import {SharedModule} from 'primeng/primeng';
import {ExchangeRateFormComponent} from "./exchange-rate-form/exchange-rate-form.component";
import {ExchangeRateService} from "../service/exchangeRateService";
import {ExchangeRateInCurrencyFormComponent} from "./exchange-rate-in-currency-form/exchange-rate-in-currency-form.component";
import {ExchangeRateInCurrencyService} from "../service/exchangeRateInCurrencyService";



@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    BankComponent,
    PaymentCheckComponent,
    CountriesComponent,
    AddCountryComponent,
    CityComponent,
    CurrenciesComponent,
    AddCityComponent,
    ActivitiesComponent,
    AddActivitiesComponent,
    BankAccountsComponent,
    PaymentOrderComponent,
    AddLegalsComponent,
    AddBankAccountIndividualComponent,
    CurrencyFormComponent,
    ComboZoomCountriesComponent,
    PayCheckComponent,
    TransferCheckComponent,
    AddLegalAccountComponent,
    AddIndividualComponent,
    LegalsComponent,
    ClientsComponent,
    IndividualsComponent,
    ExchangeRateComponent,
    ExchangeRateFormComponent,
    ExchangeRateInCurrencyFormComponent,



  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    ButtonModule,
    DialogModule,
    FormsModule,
    DropdownModule,
    SharedModule,

  ],
  providers: [
    {provide: APP_BASE_HREF, useValue: '/'},
    LogInService,
    CountryService,
    CityService,
    ActivityService,
    ClientService,
    BankAccountService,
    CurrencyService,
    AnalyticsOfStatementService,
    RecessionService,
    ExchangeRateService,
    ExchangeRateInCurrencyService,


  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
