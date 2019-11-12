import { Component, OnInit } from '@angular/core';
import { TodoService } from '../service/todo.service';
import { Todo } from '../model/Todo';
import {CdkDragDrop} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-todo-body',
  templateUrl: './todo-body.component.html',
  styleUrls: ['./todo-body.component.css']
})
export class TodoBodyComponent implements OnInit {

  todos:Todo[] = [];
  constructor(private todoService:TodoService) { }

  ngOnInit() {
    this.todos = this.todoService.getAllTodo();
  }
  /**
   * This method return the background color for Todo according to their priority
   * @param priority of the Todo
   */
  getBackgroundColor(priority:string):string{
    switch(priority){
      case 'low':
        return 'lightblue';
      case 'medium':
        return 'aquamarine';
      case 'high':
        return 'lightcoral';
    }
  }
   /**
   * This method change the status of Todo to completed when drop to In Progress section
   * @param event 
   */
  dropInProgress(event: CdkDragDrop<string[]>) {
    this.todoService.changeStatus(event.previousIndex,'inProgress');
  }
  /**
   * This method change the status of Todo to completed when drop to completed section
   * @param event 
   */
  dropInCompleted(event: CdkDragDrop<string[]>){
    this.todoService.changeStatus(event.previousIndex,'completed');
  }
  /**
   * This method delete the Todo by id
   * @param id of the Todo to be deleted
   */
  deleteTodo(id:number){
    console.log(id);
    this.todos = this.todoService.deleteTodo(id);
  }
}
