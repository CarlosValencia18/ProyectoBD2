import { Component, Input, Output, EventEmitter } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from "@angular/common";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-pregunta-fv',
  templateUrl: './pregunta-fv.component.html',
  styleUrls: ['./pregunta-fv.component.css'],
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule,CommonModule,RouterOutlet]  // Incluir FormsModule
})
export class PreguntaFVComponent {
  @Input() pregunta: any;
  @Output() answer = new EventEmitter<boolean>();
  selectedOption: string = '';

  emitAnswer(value: boolean) {
    this.answer.emit(this.selectedOption === 'true');
  }
}
