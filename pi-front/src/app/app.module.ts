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
import {NiComponent} from "./nalog-za-isplatu/ni.component";


@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    BankComponent,
    NiComponent,
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

  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
