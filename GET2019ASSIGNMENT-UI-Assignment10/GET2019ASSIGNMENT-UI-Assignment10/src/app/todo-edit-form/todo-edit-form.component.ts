import { Component, OnInit, Input, OnChanges, SimpleChanges} from '@angular/core';
import { Todo } from '../model/Todo';
import { FormGroup, FormControl} from '@angular/forms';
import { TodoService } from '../service/todo.service';

@Component({
  selector: 'app-todo-edit-form',
  templateUrl: './todo-edit-form.component.html',
  styleUrls: ['./todo-edit-form.component.css']
})
export class TodoEditFormComponent implements OnInit,OnChanges {

  @Input('id') id:number;
  currentId:number = this.id;
  todo:Todo;
  todoForm:FormGroup;
  modalId:string;
  modalDataTarget:string;
  constructor(private todoService:TodoService) {
   }

  ngOnInit() {
    this.modalId = "exampleModal"+this.currentId;
    this.modalDataTarget = "#"+this.modalId;
    this.todo = this.todoService.getTodo(this.currentId);
   this.todoForm = new FormGroup({
      title: new FormControl(''),
      description: new FormControl(''),
      creationDate: new FormControl(null),
      completionDate:new FormControl(null),
      priority: new FormControl('')
    });
  }
  ngOnChanges(changes: SimpleChanges){
    for (let propName in changes) {
      let chng = changes[propName];
      this.currentId = chng.currentValue;
     this.todo = this.todoService.getTodo(this.currentId);
    }
  }
}
