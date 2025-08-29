import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormControl } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatCardModule
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  // Add '!' to assert that these will be initialized in ngOnInit
  feedbackForm!: FormGroup; 
  formSubmitted = false;
  maxSubjectLength = 40;
  maxCommentsLength = 350;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.feedbackForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      subject: ['', [Validators.required, Validators.maxLength(this.maxSubjectLength)]],
      comments: ['', [Validators.required, Validators.maxLength(this.maxCommentsLength)]]
    });
  }
  
  // Use getters to access the form controls safely
  get name() { return this.feedbackForm.get('name') as FormControl; }
  get email() { return this.feedbackForm.get('email') as FormControl; }
  get subject() { return this.feedbackForm.get('subject') as FormControl; }
  get comments() { return this.feedbackForm.get('comments') as FormControl; }

  onSubmit(): void {
    if (this.feedbackForm.valid) {
      console.log('Form Submitted!', this.feedbackForm.value);
      this.formSubmitted = true;
    }
  }
}