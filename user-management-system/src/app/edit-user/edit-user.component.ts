import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { User } from '../login/user.model';
import { UserService } from '../user.service';
import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit {

    userEditForm: FormGroup;

    constructor(private userService: UserService) { }

    ngOnInit() {

        this.userService.getUsers();
        this.userEditForm = new FormGroup({
            username: new FormControl(),
            password: new FormControl(),
            firstName: new FormControl(),
            lastName: new FormControl(),
            age: new FormControl()
        });
    }

    editUser(user: User): void {

        this.userService.editUser(user);
    }


}
