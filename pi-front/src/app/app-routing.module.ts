import {ExtraOptions, RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {LogInComponent} from "./log-in.component/log-in.component";
import {BankComponent} from "./bank/bank.component";
import {AddCountryComponent} from "./addCountry/addCountry.component";


const routes: Routes = [
  {path: '', redirectTo: 'log-in', pathMatch: 'full'},
  {path: 'log-in', component: LogInComponent},
  {path: 'bank/:idBank', component: BankComponent},
  {path: 'bank/:idBank/country/:mode', component: AddCountryComponent},
  {path: 'bank/:idBank/country/:mode/:id', component: AddCountryComponent},

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
