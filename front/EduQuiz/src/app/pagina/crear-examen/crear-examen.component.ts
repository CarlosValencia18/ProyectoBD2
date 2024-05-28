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
import { HttpClient } from '@angular/common/http';

@Component({
  standalone: true,
  selector: 'app-crear-examen',
  templateUrl: './crear-examen.component.html',
  imports: [ReactiveFormsModule, RouterOutlet, FormsModule, CommonModule],
  styleUrls: ['./crear-examen.component.css'],
})
export class CrearExamenComponent implements OnInit {
  idUsuario: string = history.state.idUsuario;
  examForm: FormGroup = this.formBuilder.group({});

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private questionService: QuestionService,
    private formStateService: FormStateService,
    private http: HttpClient
  ) {}

  ngOnInit() {
    console.log(history.state.idUsuario);
    // Inicializar el formulario
    this.examForm = this.formBuilder.group({
      examName: ['', Validators.required],
      examDescription: ['', Validators.required],
      examCategory: ['', Validators.required],
      questionCount: [''],
      examDuration: [''],
      examTema: ['', Validators.required],
      umbralAprobacion: ['', Validators.required],
      preguntas: this.formBuilder.array([], Validators.required),
    });

    // Preguntas de prueba
    const preguntasDePrueba = this.questionService.getQuestions();

    // Crear un FormGroup para cada pregunta de prueba
    // Crear un FormGroup para cada pregunta de prueba
    const preguntasFormGroups = preguntasDePrueba.map((pregunta) =>
      this.formBuilder.group({
        ...pregunta,
        enunciado: [pregunta.enunciado, Validators.required],
        porcentaje: [pregunta.porcentaje],
        opciones: this.formBuilder.array(
          pregunta.opciones
            ? pregunta.opciones.map((opcion: any) =>
                this.formBuilder.group(opcion)
              )
            : [pregunta.respuesta]
        ), // Verifica que pregunta.opciones exista antes de llamar a map
      })
    );

    console.log(preguntasFormGroups);
    // Obtener el FormArray para preguntas
    const preguntasArray = this.examForm.get('preguntas') as FormArray;

    // Agregar los FormGroup a preguntas
    preguntasFormGroups.forEach((preguntaGroup) =>
      preguntasArray.push(preguntaGroup)
    );

    const formState = this.formStateService.getFormState();
    if (formState) {
      this.examForm.patchValue(formState);
    }
  }

  get preguntas(): FormArray {
    return this.examForm.get('preguntas') as FormArray;
  }

  onSubmit() {
    console.log(history.state.idUsuario);
    if (this.examForm.valid) {
      const exam = this.examForm.value;
      // Obtener el valor del formulario
      console.log(exam);
      // Convertir exam a un formato que la API pueda entender
      const examForApi = {
        ...exam,
        preguntas: exam.preguntas.map((pregunta: any) => ({
          enunciado: pregunta.enunciado,
          porcentaje: pregunta.porcentaje,
          duracion: pregunta.duracion,
          privada: pregunta.isPublic,
          opciones: pregunta.opciones ? pregunta.opciones : [],
          tipo: pregunta.questionType,
        })),
        idUsuario: this.idUsuario,
      };
      console.log(examForApi);
      // Enviar examForApi al controlador
      this.http
        .post('http://localhost:8081/crear-examen', examForApi)
        .subscribe((response) => {
          console.log(response);
          this.router.navigate(['/inicio-docente'], {
            state: { idUsuario: this.idUsuario },
          });
        });
    }
  }

  onSelectQuestionBank() {}

  addPregunta() {
    this.formStateService.saveFormState(this.examForm);
    this.router.navigate(['/crear-pregunta'], {
      state: { idUsuario: this.idUsuario },
    });
  }
}
