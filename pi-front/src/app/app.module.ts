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
import {NiComponent} from "./payment-check/ni.component";
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


@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    BankComponent,
    NiComponent,
    CountriesComponent,
    AddCountryComponent,
    CityComponent,
    AddCityComponent,
    ActivitiesComponent,
    AddActivitiesComponent,
    BankAccountsComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,

  ],
  providers: [
    {provide: APP_BASE_HREF, useValue: '/'},
    LogInService,
    CountryService,
    CityService,
    ActivityService,
    ClientService,

  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
