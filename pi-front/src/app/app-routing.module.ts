import {ExtraOptions, RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {LogInComponent} from "./log-in.component/log-in.component";
import {BankComponent} from "./bank/bank.component";
import {AddCountryComponent} from "./addCountry/addCountry.component";
import {AddCityComponent} from "./addCity/addCity.component";
import {AddActivitiesComponent} from "./addActivities/addActivities.component";
import {BankAccountsComponent} from "./bank-accounts/bank-accounts.component";


const routes: Routes = [
  {path: '', redirectTo: 'log-in', pathMatch: 'full'},
  {path: 'log-in', component: LogInComponent},
  {path: 'bank/:idBank/:click', component: BankComponent},
  {path: 'bank/:idBank/country/:mode', component: AddCountryComponent},
  {path: 'bank/:idBank/country/city/:mode', component: AddCityComponent},
  {path: 'bank/:idBank/activity/for/act/:mode', component: AddActivitiesComponent},
  {path: 'bank/:idBank/activity/for/act/:mode/:id', component: AddActivitiesComponent},
  {path: 'bank/:idBank/country/:mode/:id', component: AddCountryComponent},
  {path: 'bank/:idBank/country/city/:mode/:id', component: AddCityComponent},


]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
