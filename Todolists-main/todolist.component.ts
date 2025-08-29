import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-todolist',
  standalone: true,   // 👈 standalone
  imports: [FormsModule, CommonModule], // 👈 use here
  templateUrl: './todolist.component.html',
  styleUrls: ['./todolist.component.css']
})
export class TodolistComponent {
  newTask: string = '';
  tasks: { name: string, done: boolean }[] = [];

  addTask() {
    if (this.newTask.trim() !== '') {
      this.tasks.push({ name: this.newTask, done: false });
      this.newTask = '';
    }
  }

  toggleTask(index: number) {
    this.tasks[index].done = !this.tasks[index].done;
  }

  removeTask(index: number) {
    this.tasks.splice(index, 1);
  }
}
