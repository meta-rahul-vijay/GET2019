import { Injectable } from '@angular/core';
import { Todo } from '../model/Todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  //Array of Todos for storing all
  todos:Todo[] = [];
  //Id for creating new Todo
  todoId:number= 1;
  
  constructor() { }

  /**
   * This method add new Todo
   * @param todo to be added
   */
  addTodo(todo:Todo){
    this.todos.push(todo);
    this.todoId++;
  }
  /**
   * This method return all Todos
   * @returns array of all Todos
   */
  getAllTodo():Todo[]{
    return this.todos;
  }
  /**
   * This method return new id for creating Todo
   * @returns id for creating new Todo
   */
  getNewTodoId():number{
    return this.todoId;
  }
  /**
   * This method change the status of Todo
   * @param index index of Todo in array 
   * @param status new status to be updated
   */
  changeStatus(index:number,status:string){
    let todo:Todo = this.todos[index];
    todo.status = status;
  }
  /**
   * This method delete the Todo by id
   * @param id of the Todo to be deleted
   */
  deleteTodo(id:number):Todo[]{
    this.todos = this.todos.filter(function(todo){
      return todo.id !=id;
    });
   return this.todos;
  }
  /**
   * This method return the Todo by id
   * @param id of the Todo to be returned
   */
  getTodo(id:number):Todo{
    let tempTodo:Todo = this.todos.filter(function(todo){
      return todo.id == id;
    })[0];
    return tempTodo;
  }
}
