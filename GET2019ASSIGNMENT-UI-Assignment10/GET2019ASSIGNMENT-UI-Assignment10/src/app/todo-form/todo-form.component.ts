import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TodoService } from '../service/todo.service';
import { Todo } from '../model/Todo';
declare var $:any;

@Component({
  selector: 'app-todo-form',
  templateUrl: './todo-form.component.html',
  styleUrls: ['./todo-form.component.css']
})
export class TodoFormComponent implements OnInit {

  todoForm:FormGroup;
  //Status of Todo to be created
  formStatus:string = 'new';
  constructor(private todoService:TodoService) { }

  ngOnInit() {
    this.todoForm = new FormGroup({
      title: new FormControl('',[Validators.required,Validators.minLength(5)]),
      description: new FormControl(''),
      creationDate: new FormControl(null),
      completionDate:new FormControl(null),
      priority: new FormControl('')
    });
  }

  /**
   * This mehtod add new Todo
   * @param todoForm contain all detail for Todo
   */
  addTodo(todoForm:FormGroup){
    this.todoService.addTodo(new Todo(this.todoService.getNewTodoId(),todoForm.value.title,
      todoForm.value.description,this.formStatus,
      todoForm.value.creationDate,todoForm.value.completionDate,
      todoForm.value.priority));
  }
}
