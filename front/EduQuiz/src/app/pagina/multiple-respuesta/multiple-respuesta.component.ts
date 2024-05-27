import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms'; // Se eliminó CommonModule
import { RouterOutlet } from '@angular/router';
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-multiple-respuesta',
  standalone: true,
  imports: [ReactiveFormsModule, RouterOutlet,CommonModule],
  templateUrl: './multiple-respuesta.component.html',
  styleUrls: ['./multiple-respuesta.component.css']
})
export class MultipleRespuestaComponent implements OnInit {
  preguntaForm!: FormGroup;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.preguntaForm = this.fb.group({
      enunciado: ['', Validators.required],
      opciones: this.fb.array([this.crearOpcion()]),
    });
  }

  get opciones() {
    return this.preguntaForm.get('opciones') as FormArray;
  }

  crearOpcion(): FormGroup {
    return this.fb.group({
      texto: ['', Validators.required],
      correcta: [false],
    });
  }

  addOpcion(): void {
    this.opciones.push(this.crearOpcion());
  }

  removeOpcion(index: number): void {
    this.opciones.removeAt(index);
  }

  guardarRespuesta(): void {
    if (this.preguntaForm.valid) {
      console.log('Respuesta guardada:', this.preguntaForm.value);
    } else {
      console.error('Formulario inválido');
    }
  }

  onSubmit(): void {
    // Esta función se llama cuando se envía el formulario
    this.guardarRespuesta();
  }
  getFormData(): any {
    return this.preguntaForm.value;
  }

}
