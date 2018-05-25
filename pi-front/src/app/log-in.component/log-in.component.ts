import {Component, OnInit} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {LogInService} from "../../service/logInService";
import {LogInModel} from "../../model/logIn.model";

@Component({
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})

export class LogInComponent implements OnInit {

  public form: FormGroup;
  public username: AbstractControl;
  public password: AbstractControl;
  bank;

  constructor(protected router: Router,
              private fb: FormBuilder,
              private logInService: LogInService,) {
    this.form = this.fb.group({
      'username': ['', Validators.compose([Validators.required])],
      'password': ['', Validators.compose([Validators.required])],

    })
    this.username = this.form.controls['username'];
    this.password = this.form.controls['password'];


  }

  ngOnInit() {
  }

  confirmClick() {
    const logIn = new LogInModel(
      this.username.value,
      this.password.value,
    );
    this.logInService.logIn(logIn).subscribe(data => {
      this.bank = data.bank;
      if (this.bank == null) {
        console.log('Pogresna lozinka! Pokusajte ponovo.');
        this.form.controls['password'].setValue('');
      } else {
        this.router.navigateByUrl('/bank/' + this.bank.id + '/home');
      }
    })
  }
}
