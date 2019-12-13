import { Injectable } from '@angular/core';
import { User } from './login/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

    users: User[] = [];


    constructor() { }

    addUser(user: User) {
        this.users.push(user);
    }

    getUsers(): User[] {
        return this.users;
    }

    editUser(user: User) {
      
    }

    deleteUser(user: User): User[] {
        this.users = this.users.filter(function (usernew) {
            return usernew.username != user.username;
        });
        return this.users;
    }

    getUser(): void {

    }
}
