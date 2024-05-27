// crear-examen.component.ts
import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {RouterOutlet} from "@angular/router";
import {CommonModule} from "@angular/common";
import {Router} from "@angular/router";
@Component({
  standalone: true,
  selector: 'app-crear-examen',
  templateUrl: './crear-examen.component.html',
  imports: [
    ReactiveFormsModule, RouterOutlet, FormsModule,CommonModule
  ],
  styleUrls: ['./crear-examen.component.css']
})
export class CrearExamenComponent implements OnInit {
  examForm: FormGroup = this.formBuilder.group({});

  constructor(private formBuilder: FormBuilder, private router:Router) { }

  ngOnInit() {
    // Preguntas de prueba
    const preguntasDePrueba = [
      { texto: 'Pregunta de prueba 1', porcentaje: 20 },
      { texto: 'Pregunta de prueba 2', porcentaje: 30 },
      { texto: 'Pregunta de prueba 3', porcentaje: 50 },
    ];

    // Crear un FormGroup para cada pregunta de prueba
    const preguntasFormGroups = preguntasDePrueba.map(pregunta =>
      this.formBuilder.group({
        texto: [pregunta.texto, Validators.required],
        porcentaje: [pregunta.porcentaje, Validators.required]
      })
    );

    // Inicializar el formulario con las preguntas de prueba
    this.examForm = this.formBuilder.group({
      examName: ['', Validators.required],
      examDescription: ['', Validators.required],
      examCategory: ['', Validators.required],
      questionCount: ['', [Validators.required, Validators.min(1)]],
      examDateTime: ['', Validators.required],
      examDuration: ['', Validators.required],
      preguntas: this.formBuilder.array(preguntasFormGroups)
    });
  }

  get preguntas(): FormArray {
    return this.examForm.get('preguntas') as FormArray;
  }



  onSubmit() {
    if (this.examForm.valid) {
      console.log(this.examForm.value);
    }
  }

  onSelectQuestionBank() {

  }

  addPregunta() {
  this.router.navigate(['/crear-pregunta']);
  }
}
