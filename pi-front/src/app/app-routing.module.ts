import {ExtraOptions, RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {LogInComponent} from "./log-in.component/log-in.component";
import {BankComponent} from "./bank/bank.component";


const routes: Routes = [
  {path: '', redirectTo: 'log-in', pathMatch: 'full'},
  {path: 'log-in', component: LogInComponent},
  {path: 'bank/:idBank', component: BankComponent},

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
