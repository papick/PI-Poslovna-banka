import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from "@angular/router";
import {ClientService} from "../../service/clientService";
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

  individual = false;

  constructor(private clientService: ClientService, protected route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.activeId = this.route.snapshot.params.idBank;
  }

  getLegals() {
    this.fizickoLice = false;
    this.pravnoLice = true;
    this.individual = false;
    this.clientService.getLegals().subscribe(data => {
      this.items = data;
    });
  }

  getIndividuals() {
    this.pravnoLice = false;
    this.fizickoLice = true;
    this.individual = true;
    this.clientService.getIndividuals().subscribe(data => {
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
}
