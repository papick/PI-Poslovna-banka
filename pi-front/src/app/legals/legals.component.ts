import {Component, OnInit} from '@angular/core';
import {ClientService} from '../../service/clientService';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-legals',
  templateUrl: './legals.component.html',
  styleUrls: ['./legals.component.css']
})
export class LegalsComponent implements OnInit {

  legals = []
  allLegals;
  idbank;
  mode;

  nameSearch:string='';
  emailSearch : string='';
  pibSearch:string= '';
  personSearch:string='';

  constructor(private clientService: ClientService,
              private route: ActivatedRoute,
              private router: Router) {
  }


  ngOnInit() {

    this.getLegals();

  }

  getLegals() {
    this.clientService.getLegalEntities().subscribe(data =>{
      this.legals = data;
      this.allLegals = data;
    });
  }

  editLegal(id) {
    this.idbank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('bank/' + this.idbank + '/clients/legals/edit/' + id);
  }

  deleteLegal(id) {
    this.clientService.deleteLegalEntity(id).subscribe(data => {
      location.reload();
    });

  }

  add() {
    this.idbank = this.route.snapshot.params.idBank;
    this.mode = this.route.snapshot.params.mode;
    this.router.navigateByUrl('bank/' + this.idbank + '/clients/legals/add');
  }

  search(){
    this.legals = this.allLegals.filter(a => a.name.toLowerCase().includes(this.nameSearch.toLowerCase()) &&
                                            a.email.toLowerCase().includes(this.emailSearch.toLowerCase()) &&
                                            a.pib.includes(this.pibSearch) &&
                                            a.responsiblePerson.toLowerCase().includes(this.personSearch.toString())
                                          );
  }

}
