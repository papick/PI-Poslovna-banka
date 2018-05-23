import {Component, OnInit} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CountryService} from "../../service/countryService";
import {CountryModel} from "../../model/country.model";
import {ActivityService} from "../../service/activityService";
import {ActivityModel} from "../../model/activity.model";

@Component({
  templateUrl: './addActivities.component.html',
})
export class AddActivitiesComponent implements OnInit {

  public form: FormGroup;
  public name: AbstractControl;
  public code: AbstractControl;

  public method_name = 'DODAJ';
  public mode: String;


  constructor(protected router: Router,
              private fb: FormBuilder,
              private route: ActivatedRoute,
              private activityService: ActivityService) {
    this.form = this.fb.group({
      'name': ['', Validators.compose([Validators.required])],
      'code': ['', Validators.compose([Validators.required])],

    })
    this.name = this.form.controls['name'];
    this.code = this.form.controls['code'];


  }

  ngOnInit() {
    this.mode = this.route.snapshot.params.mode;
    if (this.mode == 'edit') {
      this.method_name = 'IZMENI';
      const id = this.route.snapshot.params.id;
      this.activityService.getActivity(id).subscribe(data => {
        this.form.controls['name'].setValue(data.name);
        this.form.controls['code'].setValue(data.code);

      })
    } else if (this.mode == 'add') {
    }
    else {

    }
  }

  confirmClick() {
    if (this.method_name === 'DODAJ') {
      this.createActivity();
    } else {
      this.editActivity();
    }
  }

  createActivity(): any {
    const activity = new ActivityModel(
      this.name.value,
      this.code.value,
    );
    this.activityService.createActivity(activity).toPromise()
      .then(data => {
        const idBank = this.route.snapshot.params.idBank;
        this.router.navigateByUrl('bank/' + idBank + '/activities');

      })
  }

  editActivity() {
    const activity = new ActivityModel(
      this.name.value,
      this.code.value,
    );
    const id = this.route.snapshot.params.id;
    this.activityService.editActivity(activity, id).toPromise()
      .then(data => {
        const idBank = this.route.snapshot.params.idBank;
        this.router.navigateByUrl('bank/' + idBank + '/activities');

      })
  }

  exit() {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('bank/' + idBank + '/activities');

  }
}
