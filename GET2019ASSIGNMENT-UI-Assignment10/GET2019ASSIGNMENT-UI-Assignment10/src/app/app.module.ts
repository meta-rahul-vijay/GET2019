import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import {DragDropModule} from '@angular/cdk/drag-drop';
import { TodoHeaderComponent } from './todo-header/todo-header.component';
import { TodoBodyComponent } from './todo-body/todo-body.component';
import { TodoFormComponent } from './todo-form/todo-form.component';
import { TodoEditFormComponent } from './todo-edit-form/todo-edit-form.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoHeaderComponent,
    TodoBodyComponent,
    TodoFormComponent,
    TodoEditFormComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    DragDropModule,
    BrowserModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
