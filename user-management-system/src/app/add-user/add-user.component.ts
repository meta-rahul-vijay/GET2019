import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { UserService } from '../user.service';
import { User } from '../login/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {

    addForm: FormGroup;
    constructor(private userService: UserService, private router: Router) { }

    ngOnInit() {
        this.addForm = new FormGroup({
            username: new FormControl(),
            password: new FormControl(),
            firstName: new FormControl(),
            lastName: new FormControl(),
            age: new FormControl()
        })
    }

    addUser(addForm: FormGroup): void {
        this.userService.addUser(new User(this.addForm.get('username').value, this.addForm.get('password').value,
            this.addForm.get('firstName').value, this.addForm.get('lastName').value,
            this.addForm.get('age').value));
        this.router.navigate(['list-user']);
    }

}
