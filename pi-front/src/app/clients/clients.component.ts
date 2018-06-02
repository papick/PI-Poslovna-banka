import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  constructor(protected router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
  }

  legalEntitiesPage() {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('/bank/' + idBank + '/clients/legals');
  }

  individualsPage() {

  }
}
