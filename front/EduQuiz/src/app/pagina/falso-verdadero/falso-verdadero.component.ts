import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import {RouterOutlet} from "@angular/router";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-falso-verdadero',
  standalone: true,
  imports: [ReactiveFormsModule,RouterOutlet,CommonModule],
  templateUrl: './falso-verdadero.component.html',
  styleUrls: ['./falso-verdadero.component.css']
})
export class FalsoVerdaderoComponent implements OnInit {
  preguntaForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.preguntaForm = this.fb.group({
      enunciado: ['', Validators.required],
      respuesta: ['', Validators.required],
    });
  }

  guardarRespuesta(): void {
    if (this.preguntaForm.valid) {
      console.log('Respuesta guardada:', this.preguntaForm.value);
    } else {
      console.error('Formulario inválido');
    }
  }
  getFormData(): any {
    return this.preguntaForm.value;
  }

  onSubmit(): void {
    // Esta función se llama cuando se envía el formulario
    this.guardarRespuesta();
  }
}
