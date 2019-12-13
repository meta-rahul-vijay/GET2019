import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AddUserComponent } from './add-user/add-user.component';
import { ListUserComponent } from './list-user/list-user.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Routes = [{ path: 'login', component: LoginComponent },
    { path: 'add-user', component: AddUserComponent },
    { path: 'list-user', component: ListUserComponent },
    { path: 'edit-user', component: EditUserComponent },
    { path: '', redirectTo: '/login', pathMatch: 'full'},
    { path: '**', component: PageNotFoundComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
