import { Component, Input, Output, EventEmitter } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterOutlet} from "@angular/router";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-pregunta-mr',
  templateUrl: './pregunta-mr.component.html',
  styleUrls: ['./pregunta-mr.component.css'],
  standalone: true,
  imports: [FormsModule,RouterOutlet,ReactiveFormsModule,CommonModule]  // Incluir FormsModule
})
export class PreguntaMRComponent {
  @Input() pregunta: any;
  @Output() answer = new EventEmitter<string[]>();

  emitAnswer() {
    const selectedOptions = this.pregunta.opciones.filter((opcion: any) => opcion.selected).map((opcion: any) => opcion.texto);
    this.answer.emit(selectedOptions);
  }
}
