import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {ClientService} from "../../service/clientService";

@Component({
  selector: 'app-bank-accounts',
  templateUrl: './bank-accounts.component.html',
  styleUrls: ['./bank-accounts.component.css']
})
export class BankAccountsComponent implements OnInit {

  items = []
  activeId;
  pravnoLice = false;
  fizickoLice = false;
  prikaziZaFizicka = false;
  individualAccounts = [];

  constructor(private clientService: ClientService, protected route: ActivatedRoute) {
  }

  ngOnInit() {
    this.activeId = this.route.snapshot.params.idBank;
  }

  getLegals() {
    this.fizickoLice = false;
    this.pravnoLice = true;
    this.prikaziZaFizicka = false;
    this.clientService.getLegals().subscribe(data => {
      this.items = data;
    });
  }

  getIndividuals() {
    this.pravnoLice = false;
    this.fizickoLice = true;
    this.prikaziZaFizicka = true;
    this.clientService.getIndividuals().subscribe(data => {
      this.individualAccounts = data;
    });
  }

  addLegalEntity() {

  }

  addIndividual() {
    
  }
}