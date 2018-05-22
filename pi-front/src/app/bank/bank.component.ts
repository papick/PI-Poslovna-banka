import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  templateUrl: './bank.component.html',
  styleUrls: ['./bank.component.scss'],
})

export class BankComponent implements OnInit {

  imageRoute = '../../../assets/images/erste.jpg';
  nalogZaIsplatu = false;
  idBank;

  constructor(protected route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.idBank = this.route.snapshot.params.idBank;
  }

  nalogIsplata() {
    this.nalogZaIsplatu = true;
  }

  home() {
    this.router.navigateByUrl('bank/' + this.idBank);
  }
}
