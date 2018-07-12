import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from "./app.component";
import {BankComponent} from "./bank/bank.component";
import {LogInComponent} from "./log-in.component/log-in.component";
import {PaymentCheckComponent} from "./payment-check/payment-check.component";
import {CountriesComponent} from "./countries/countries.component";
import {AddCountryComponent} from "./addCountry/addCountry.component";
import {CityComponent} from "./city/city.component";
import {CurrenciesComponent} from "./currencies/currencies.component";
import {AddCityComponent} from "./addCity/addCity.component";
import {ActivitiesComponent} from "./activities/activities.component";
import {AddActivitiesComponent} from "./addActivities/addActivities.component";
import {BankAccountsComponent} from "./bank-accounts/bank-accounts.component";
import {PaymentOrderComponent} from "./payment-order/payment-order.component";
import {AddLegalsComponent} from "./add-legals/add-legals.component";
import {AddBankAccountIndividualComponent} from "./add-bank-account-individual/add-bank-account-individual.component";
import {CurrencyFormComponent} from "./currency-form/currency-form.component";
import {ComboZoomCountriesComponent} from "./combo-zoom-countries/combo-zoom-countries.component";
import {PayCheckComponent} from "./pay-check/pay-check.component";
import {TransferCheckComponent} from "./transfer-check/transfer-check.component";
import {AddLegalAccountComponent} from "./add-legal-account/add-legal-account.component";
import {AddIndividualComponent} from "./add-individual/add-individual.component";
import {LegalsComponent} from "./legals/legals.component";
import {ClientsComponent} from './clients/clients.component';
import {IndividualsComponent} from "./individuals/individuals.component";
import {AnalyticsOfStatementService} from "../service/AnalyticsOfStatementService";
import {CurrencyService} from "../service/currencyService";
import {ClientService} from '../service/clientService';
import {BankAccountService} from "../service/bankAccountService";
import {ActivityService} from "../service/activityService";
import {CityService} from "../service/cityService";
import {CountryService} from "../service/countryService";
import {LogInService} from "../service/logInService";
import {APP_BASE_HREF} from '@angular/common';
import {RecessionService} from "../service/recessionService";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ButtonModule} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {SharedModule} from 'primeng/components/common/shared';
import {DropdownModule} from "primeng/primeng";


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


  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    ButtonModule,
    DialogModule,
    FormsModule,
    DropdownModule,
    SharedModule
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
    RecessionService

  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
