import { Component, OnInit } from '@angular/core';
import {ClientService} from "../../service/clientService";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-individuals',
  templateUrl: './individuals.component.html',
  styleUrls: ['./individuals.component.css']
})
export class IndividualsComponent implements OnInit {
  indvs = [];
  idbank;
  mode;

  constructor(private clientService: ClientService,
              private route: ActivatedRoute,
              private router: Router) {
  }


  ngOnInit() {

    this.getIndividuals();

  }

  getIndividuals() {
    this.clientService.getIndividualEntities().subscribe(data => this.indvs = data);
  }

  editIndividual(id) {
    this.idbank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('bank/' + this.idbank + '/add/clients/individual/edit/account/izmeni/' + id);
  }

  deleteIndividual(id) {
    this.clientService.deleteIndividual(id).subscribe(data => {
      location.reload();
    });

  }

  add() {
    this.idbank = this.route.snapshot.params.idBank;
    this.mode = this.route.snapshot.params.mode;
    this.router.navigateByUrl('bank/' + this.idbank + '/add/clients/individual/edit/account/dodaj');
  }
}
