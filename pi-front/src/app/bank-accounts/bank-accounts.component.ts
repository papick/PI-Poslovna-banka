import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from "@angular/router";
import {ClientService} from "../../service/clientService";
import {RecessionService} from '../../service/recessionService';
import  {Recession} from '../../model/recession.model';
import index from "@angular/cli/lib/cli";

@Component({
  selector: 'app-bank-accounts',
  templateUrl: './bank-accounts.component.html',
  styleUrls: ['./bank-accounts.component.css']
})
export class BankAccountsComponent implements OnInit {

  items = [];
  index;
  activeId;
  pravnoLice = false;
  fizickoLice = false;
  idbank;
  individual = false;

  dialogVisible=false;
  selectedAccountTo:any = {};
  selectedAccountFrom:any;
  accounts = [];

  constructor(private clientService: ClientService, protected route: ActivatedRoute, private router: Router, private recessionService:RecessionService) {
  }

  ngOnInit() {
    this.activeId = this.route.snapshot.params.idBank;
  }

  getAllForSelect(id){
    this.clientService.getLegals(this.idbank).subscribe(data => {
      this.accounts = data;
      this.clientService.getIndividuals(this.idbank).subscribe(data => {
        this.accounts = data.concat(this.accounts);
        this.selectedAccountFrom =  this.accounts.find(account => account.id == id);
        this.accounts = this.accounts.filter(account => account.id != id);

      });
    });


  }

  getLegals() {
    this.fizickoLice = false;
    this.pravnoLice = true;
    this.individual = false;
    this.idbank = this.route.snapshot.params.idBank;
    this.clientService.getLegals(this.idbank).subscribe(data => {
      this.items = data;
    });
  }

  getIndividuals() {
    this.pravnoLice = false;
    this.fizickoLice = true;
    this.individual = true;
    this.idbank = this.route.snapshot.params.idBank;
    this.clientService.getIndividuals(this.idbank).subscribe(data => {
      this.items = data;
    });
  }

  addL() {
    this.router.navigateByUrl('bank/' + this.activeId + '/clients/legals/dodaj');
  }

  addI() {
    this.router.navigateByUrl('bank/' + this.activeId + '/addIndividual');
  }

  addLegalEntityAccount() {
    this.router.navigateByUrl('bank/' + this.activeId + '/add/clients/legal/account/dodaj');
    location.reload();
  }

  addIndividualAccount() {
    this.router.navigateByUrl('bank/' + this.activeId + '/addIndividualAccount');
    location.reload();
  }

  editLegalAccountPage(id) {
    this.router.navigateByUrl('bank/' + this.activeId + '/add/clients/legal/account/edit/' + id);
  }

  editIndividualAccountPage(id) {
    this.router.navigateByUrl('bank/' + this.activeId + '/add/clients/individual/edit/individual/account/edit/' + id);
  }

  showDialog(id){
    this.getAllForSelect(id);
    this.dialogVisible = true;
  }

  delete(){
    let body:Recession = {};
    body.accountFrom = this.selectedAccountFrom;
    body.accountTo = this.selectedAccountTo;
    this.recessionService.addRecession(body).subscribe(data =>{
      this.dialogVisible = false;
    });

    console.log(JSON.stringify(body));
  }

  cancel(){
    this.dialogVisible = false;
  }
}
