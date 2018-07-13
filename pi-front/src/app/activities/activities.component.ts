import {Component, OnInit} from "@angular/core";
import {ActivityService} from "../../service/activityService";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'activities',
  templateUrl: './activities.component.html',
  styleUrls: ['./activities.component.css']
})

export class ActivitiesComponent implements OnInit{

  items = [];
  activities;

  nameSearch:string='';
  codeSearch : string='';

  constructor(private activityService: ActivityService,
              protected router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {

    this.activityService.getActivities().subscribe(data => {
      this.items = data.activities;
      this.activities = data.activities;
    })
  }

  add() {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('/bank/' + idBank + '/activity/for/act/add');

  }

  deleteActivity(id): any {
    this.activityService.deleteActivity(id).toPromise()
      .then(data => {
        this.items = this.items.filter(el => el.id != id);

      })
  }


  editActivity(id): any {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('bank/' + idBank + '/activity/for/act/edit/' + id);

  }

  search(){

    this.items = this.activities.filter(a => a.code.toLowerCase().includes(this.nameSearch.toLowerCase()) &&
                                            a.name.toLowerCase().includes(this.codeSearch.toLowerCase())
                                          );
  }
}
