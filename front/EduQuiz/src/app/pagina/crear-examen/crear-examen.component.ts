// crear-examen.component.ts
import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {RouterOutlet} from "@angular/router";
@Component({
  standalone: true,
  selector: 'app-crear-examen',
  templateUrl: './crear-examen.component.html',
  imports: [
    ReactiveFormsModule,RouterOutlet
  ],
  styleUrls: ['./crear-examen.component.css']
})
export class CrearExamenComponent implements OnInit {
  examForm: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.examForm = this.formBuilder.group({
      examName: ['', Validators.required],
      examDescription: ['', Validators.required],
      examCategory: ['', Validators.required],
      questionCount: ['', [Validators.required, Validators.min(1)]],
      examDateTime: ['', Validators.required],
      examDuration: ['', Validators.required] // Nuevo campo para la duración del examen
    });
  }

  onSubmit() {
    if (this.examForm.valid) {
      // Aquí puedes manejar la lógica de envío del formulario
      console.log(this.examForm.value);
    }
  }
  onCreateQuestion() {
    // Aquí puedes manejar la lógica de creación de una nueva pregunta
    console.log('Crear otra pregunta');
  }

  onSelectQuestionBank() {
    // Aquí puedes manejar la lógica de selección del banco de preguntas
    console.log('Seleccionar banco de preguntas');
  }

}
