
import {Component, OnInit} from "@angular/core";
import {CurrencyService} from "../../service/currencyService";
import {Router} from "@angular/router";
import {Location} from '@angular/common';

@Component({
  selector: 'app-currencies',
  templateUrl: './currencies.component.html',
  styleUrls: ['./currencies.component.css']
})
export class CurrenciesComponent implements OnInit {

  items = [];

  selectedRow: number;

  constructor(private currencyService : CurrencyService,
              protected router: Router,
              private location: Location,) {

  }

  ngOnInit(): void {

    this.currencyService.getCurrencies().subscribe(data => {
      this.items = data.currencies;
    })
  }

  setClickedRow(index: any) {

    this.selectedRow = index;

  }

  addNewCurrency(): any {

    this.router.navigateByUrl('currencies/currency-form/add');
  }

  deleteCurrency(id): any {

    this.currencyService.deleteCurrency(id).toPromise()
      .then(data => {
        //this.items = this.items.filter(el => el.id != id);

      })

    console.log('brisem' + id)
    location.reload();

  }

  updateCurrency(id) : any {

    this.router.navigateByUrl('currencies/currency-form/edit/' + id);
  }


}
