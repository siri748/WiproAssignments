import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-calculator',
  imports: [FormsModule],
  templateUrl: './calculator.component.html',
  styleUrl: './calculator.component.css'
})
export class CalculatorComponent {
 num1: number = 0;
  num2: number = 0;
  result: number | string | null = null;

  add() {
    this.result = this.num1 + this.num2;
  }

  subtract() {
    this.result = this.num1 - this.num2;
  }

  multiply() {
    this.result = this.num1 * this.num2;
  }

  divide() {
    if (this.num2 === 0) {
      this.result = 'Error: Division by zero';
    } else {
      this.result = this.num1 / this.num2;
    }
  }
}