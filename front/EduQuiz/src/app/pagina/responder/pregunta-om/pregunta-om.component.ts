import { Component, Input, Output, EventEmitter } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterOutlet} from "@angular/router";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-pregunta-om',
  templateUrl: './pregunta-om.component.html',
  styleUrls: ['./pregunta-om.component.css'],
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule,RouterOutlet,CommonModule]  // Incluir FormsModule
})
export class PreguntaOMComponent {
  @Input() pregunta: any;
  @Output() answer = new EventEmitter<string>();

  emitAnswer(value: string) {
    this.answer.emit(value);
  }

}
