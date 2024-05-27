// crear-examen.component.ts
import { Component, OnInit } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { QuestionService } from '../../services/question.service';
import { FormStateService } from '../../services/form-state.service';

@Component({
  standalone: true,
  selector: 'app-crear-examen',
  templateUrl: './crear-examen.component.html',
  imports: [ReactiveFormsModule, RouterOutlet, FormsModule, CommonModule],
  styleUrls: ['./crear-examen.component.css'],
})
export class CrearExamenComponent implements OnInit {
  examForm: FormGroup = this.formBuilder.group({});

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private questionService: QuestionService,
    private formStateService: FormStateService
  ) {}

  ngOnInit() {
    // Inicializar el formulario
    this.examForm = this.formBuilder.group({
      examName: ['', Validators.required],
      examDescription: ['', Validators.required],
      examCategory: ['', Validators.required],
      questionCount: [''],
      examDuration: [''],
      preguntas: this.formBuilder.array([], Validators.required),
    });

    const formState = this.formStateService.getFormState();
    if (formState) {
      this.examForm.setValue(formState);
    }

    // Preguntas de prueba
    const preguntasDePrueba = this.questionService.getQuestions();

    // Crear un FormGroup para cada pregunta de prueba
    const preguntasFormGroups = preguntasDePrueba.map((pregunta) =>
      this.formBuilder.group({
        ...pregunta,
        enunciado: [pregunta.enunciado, Validators.required],
        porcentaje: [pregunta.porcentaje, Validators.required],
      })
    );
    console.log(preguntasFormGroups);
    // Obtener el FormArray para preguntas
    const preguntasArray = this.examForm.get('preguntas') as FormArray;

    // Agregar los FormGroup a preguntas
    preguntasFormGroups.forEach((preguntaGroup) =>
      preguntasArray.push(preguntaGroup)
    );
  }

  get preguntas(): FormArray {
    return this.examForm.get('preguntas') as FormArray;
  }

  onSubmit() {
    if (this.examForm.valid) {
      console.log(this.examForm.value);
    }
  }

  onSelectQuestionBank() {}

  addPregunta() {
    this.formStateService.saveFormState(this.examForm);
    this.router.navigate(['/crear-pregunta']);
  }
}
