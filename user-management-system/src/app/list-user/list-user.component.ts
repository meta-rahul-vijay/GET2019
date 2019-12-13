import { Component, OnInit } from '@angular/core';
import { User } from '../login/user.model';
import { UserService } from '../user.service';
import { Router } from "@angular/router";
import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.scss']
})
export class ListUserComponent implements OnInit {

    //display: boolean = false;

    //showDialog() {
    //    this.display = true;
    //}

    //hideDialog() {
    //    this.display = false;
    //}


    users: User[];

    constructor(private userService: UserService, private router: Router) { }

    ngOnInit() {
        this.users = this.userService.getUsers();
    }

    addUser(): void {
        this.router.navigate(['add-user']);
    }

    deleteUser(user: User): void {
        this.users = this.userService.deleteUser(user);
    }

    editUser(user: User): void {
        this.router.navigate(['edit-user']);
    }

}
