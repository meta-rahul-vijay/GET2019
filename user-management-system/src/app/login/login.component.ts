import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { User } from './user.model';
import { Router } from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    loginForm = new FormGroup({
        username: new FormControl(),
        password: new FormControl()
    });
  constructor(private router: Router) { }

    ngOnInit() {

    }

    userLoginForm(userForm: FormGroup): void {
        this.router.navigate(['list-user']);
        //console.log("Username = " + this.loginForm.get('username').value);
    }

}
