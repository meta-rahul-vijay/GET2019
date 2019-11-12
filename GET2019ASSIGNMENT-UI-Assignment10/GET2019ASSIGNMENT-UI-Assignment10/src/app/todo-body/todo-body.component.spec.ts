import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TodoBodyComponent } from './todo-body.component';

describe('TodoBodyComponent', () => {
  let component: TodoBodyComponent;
  let fixture: ComponentFixture<TodoBodyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TodoBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TodoBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
