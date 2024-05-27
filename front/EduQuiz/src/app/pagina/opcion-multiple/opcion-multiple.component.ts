import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-opcion-multiple',
  standalone: true,
  imports: [ReactiveFormsModule, RouterOutlet, CommonModule],
  templateUrl: './opcion-multiple.component.html',
  styleUrls: ['./opcion-multiple.component.css']
})
export class OpcionMultipleComponent implements OnInit {
  preguntaForm: FormGroup;
  correcta: any;
  constructor(private formBuilder: FormBuilder) {
    this.preguntaForm = this.formBuilder.group({
      enunciado: ['', Validators.required],
      opciones: this.formBuilder.array([this.crearOpcion()])
    });

  }

  ngOnInit() {}

  get opciones() {
    return this.preguntaForm.get('opciones') as FormArray;
  }

  crearOpcion(): FormGroup {
    return this.formBuilder.group({
      texto: ['', Validators.required],
      correcta: [false]
    });
  }

  addOpcion(): void {
    this.opciones.push(this.crearOpcion());
  }

  removeOpcion(index: number): void {
    this.opciones.removeAt(index);
  }

  onSubmit(): void {
    console.log(this.preguntaForm.value);
  }
  getFormData(): any {
    return this.preguntaForm.value;
  }

}
