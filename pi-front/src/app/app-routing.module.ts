import {ExtraOptions, RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {LogInComponent} from "./log-in.component/log-in.component";
import {BankComponent} from "./bank/bank.component";
import {AddCountryComponent} from "./addCountry/addCountry.component";
import {AddCityComponent} from "./addCity/addCity.component";
import {AddActivitiesComponent} from "./addActivities/addActivities.component";
import {BankAccountsComponent} from "./bank-accounts/bank-accounts.component";
import {AddBankAccountIndividualComponent} from "./add-bank-account-individual/add-bank-account-individual.component";


import {CurrencyFormComponent} from "./currency-form/currency-form.component";
import {ComboZoomCountriesComponent} from "./combo-zoom-countries/combo-zoom-countries.component";

import {AddLegalsComponent} from "./add-legals/add-legals.component";
import {AddLegalAccountComponent} from "./add-legal-account/add-legal-account.component";
import {LegalsComponent} from "./legals/legals.component";
import {AddIndividualComponent} from "./add-individual/add-individual.component";



const routes: Routes = [
  {path: '', redirectTo: 'log-in', pathMatch: 'full'},
  {path: 'log-in', component: LogInComponent},
  {path: 'bank/:idBank', component: BankAccountsComponent},
  {path: 'bank/:idBank/addIndividual', component: AddBankAccountIndividualComponent},
  {path: 'bank/:idBank/addLegalEntity', component: AddLegalsComponent},
  {path: 'bank/:idBank/:click/paymanent/:type', component: BankComponent},
  {path: 'bank/:idBank/:click', component: BankComponent},
  {path: 'bank/:idBank/:click/:id', component: BankComponent},
  {path: 'bank/:idBank/country/city/:mode', component: AddCityComponent},
  {path: 'bank/:idBank/country/:mode/:id', component: AddCountryComponent},
  {path: 'bank/:idBank/clients/legals/:mode/:id', component: AddLegalsComponent},
  {path: 'bank/:idBank/clients/legals/:mode', component: AddLegalsComponent},
  {path: 'bank/:idBank/:click/:country/:id', component: BankComponent},
  {path: 'bank/:idBank/country/country/:mode', component: AddCountryComponent},
  {path: 'bank/:idBank/activity/for/act/:mode', component: AddActivitiesComponent},
  {path: 'bank/:idBank/activity/for/act/:mode/:id', component: AddActivitiesComponent},
  {path: 'bank/:idBank/country/city/:mode/:id', component: AddCityComponent},
  {path: 'currencies/currency-form/:mode', component: CurrencyFormComponent},
  {path: 'currencies/currency-form/:mode/:id', component: CurrencyFormComponent},
  {path: 'currencies/currency-form/:mode/combo-zoom/countries', component: ComboZoomCountriesComponent},
  {path: 'bank/:idBank/add/clients/legal/account/:mode', component: AddLegalAccountComponent},
  {path: 'bank/:idBank/add/clients/legal/account/:mode/:id', component: AddLegalAccountComponent},
  {path: 'bank/:idBank/add/clients/individual/account/:mode/:id', component: AddBankAccountIndividualComponent},
  {path: 'bank/:idBank/add/clients/individual/account/:mode', component: AddBankAccountIndividualComponent},


]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
