import { Component, OnInit } from '@angular/core';
import { UserService, Task } from './user.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  tasks: Task[] = [];
  newTask: Task = { taskDesc: '', priority: 'LOW', completed: false };

  editingTask: Task | null = null;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.loadTasks();
  }

  loadTasks(): void {
    this.userService.getAllTasks().subscribe(data => this.tasks = data);
  }

  addTask(): void {
    if (!this.newTask.taskDesc) return;
    this.userService.createTask(this.newTask).subscribe(task => {
      this.tasks.push(task);
      this.newTask = { taskDesc: '', priority: 'LOW', completed: false };
    });
  }

  editTask(task: Task): void {
    this.editingTask = { ...task };
  }

  updateTask(): void {
    if (!this.editingTask) return;
    this.userService.updateTask(this.editingTask.id!, this.editingTask).subscribe(updated => {
      const index = this.tasks.findIndex(t => t.id === updated.id);
      if (index !== -1) this.tasks[index] = updated;
      this.editingTask = null;
    });
  }

  deleteTask(id: number): void {
    this.userService.deleteTask(id).subscribe(() => {
      this.tasks = this.tasks.filter(t => t.id !== id);
    });
  }

  toggleCompletion(task: Task): void {
    this.userService.toggleTaskCompletion(task.id!).subscribe(updated => {
      const index = this.tasks.findIndex(t => t.id === updated.id);
      if (index !== -1) this.tasks[index] = updated;
    });
  }
}
