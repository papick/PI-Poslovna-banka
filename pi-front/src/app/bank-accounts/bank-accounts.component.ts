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
  allAccounts=[];
  index;
  activeId;
  pravnoLice = false;
  fizickoLice = false;
  idbank;
  individual = false;

  dialogVisible=false;
  selectedAccountTo:any = {};
  selectedAccountFrom:any;
  accounts :any=[] ;
  accountsSelect:any=[];

  nameSearch:string='';
  accountNumberSearch : string='';
  pibSearch:string= '';
  jmbgSearch:string='';
  bankSearch:string ='';

  combozoomVisible = false;

  constructor(private clientService: ClientService, protected route: ActivatedRoute, private router: Router, private recessionService:RecessionService) {
  }

  ngOnInit() {
    this.activeId = this.route.snapshot.params.idBank;
  }

  getAllForSelect(id){
    this.clientService.getAccounts().subscribe(data => {
      this.accounts = data;
      this.selectedAccountFrom =  this.accounts.find(account => account.id == id);
      this.accounts = this.accounts.filter(account => account.id != id && account.valid);
      this.accountsSelect = this.accounts.slice();
    });


  }

  getLegals() {
    this.fizickoLice = false;
    this.pravnoLice = true;
    this.individual = false;
    this.idbank = this.route.snapshot.params.idBank;
    this.clientService.getLegals(this.idbank).subscribe(data => {
      this.items = data;
      this.allAccounts = this.items;

    });
  }

  getIndividuals() {
    this.pravnoLice = false;
    this.fizickoLice = true;
    this.individual = true;
    this.idbank = this.route.snapshot.params.idBank;
    this.clientService.getIndividuals(this.idbank).subscribe(data => {
      this.items = data;
      this.allAccounts = this.items;

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
      const item = this.items.find( a => a.id == body.accountFrom.id);
      item.valid=false;
    });

    console.log(JSON.stringify(body));
  }

  cancel(){
    this.dialogVisible = false;
  }

  search(){
    if(!this.individual){

        this.items = this.allAccounts.filter(a => a.number.includes(this.accountNumberSearch) &&
                                            a.legalEntity.name.toLowerCase().includes(this.nameSearch.toLowerCase()) &&
                                            a.legalEntity.pib.includes(this.pibSearch)
                                            );
    }else{
      this.items = this.allAccounts.filter(a => a.number.includes(this.accountNumberSearch) &&
                                          a.individual.name.toLowerCase().includes(this.nameSearch.toLowerCase()) &&
                                          a.individual.jmbg.includes(this.jmbgSearch)
                                          );
    }
  }

  searchCombozoom(){
      this.accounts = this.accountsSelect.filter(a => {
        let nameCheck;
        if(a.individual){
          nameCheck=  a.individual.name.toLowerCase().includes(this.nameSearch.toLowerCase());
        }else{
          nameCheck =  a.legalEntity.name.toLowerCase().includes(this.nameSearch.toLowerCase());
        }
        console.log(a.bank.name.toLowerCase().includes(this.bankSearch.toLowerCase()));
        return nameCheck  && a.number.includes(this.accountNumberSearch) &&
        a.bank.name.toLowerCase().includes(this.bankSearch.toLowerCase())
      }
                                          );

  }

  showCombozoom(){
    this.combozoomVisible =true;
  }

  izaberi(id){
    this.accounts = this.accountsSelect.slice();
    this.selectedAccountTo = this.accounts.find(a => a.id == id);
    this.nameSearch='';
    this.accountNumberSearch ='';
    this.pibSearch= '';
    this.jmbgSearch='';
    this.combozoomVisible = false;
  }

}
