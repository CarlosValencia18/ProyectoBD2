import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import {MultipleRespuestaComponent} from "../multiple-respuesta/multiple-respuesta.component";
import {CommonModule} from "@angular/common";
import {OpcionMultipleComponent} from "../opcion-multiple/opcion-multiple.component";
import {FalsoVerdaderoComponent} from "../falso-verdadero/falso-verdadero.component";
import { ViewChild } from '@angular/core';



@Component({
  standalone: true,
  selector: 'app-crear-pregunta',
  templateUrl: './crear-pregunta.component.html',
  imports: [
    ReactiveFormsModule, RouterOutlet, MultipleRespuestaComponent,CommonModule,OpcionMultipleComponent,FalsoVerdaderoComponent
  ],
  styleUrls: ['./crear-pregunta.component.css']
})
export class CrearPreguntaComponent implements OnInit {
  questionForm: FormGroup = new FormGroup({});
  showMultipleRespuestaContainer: boolean = false;
  showOpcionMultipleContainer = false;
  showFalsoVerdaderoContainer = false;

  @ViewChild(FalsoVerdaderoComponent) falsoVerdaderoComponent!: FalsoVerdaderoComponent;
  @ViewChild(OpcionMultipleComponent) opcionMultipleComponent!: OpcionMultipleComponent;
  @ViewChild(MultipleRespuestaComponent) multipleRespuestaComponent!: MultipleRespuestaComponent;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.questionForm = this.formBuilder.group({
      questionType: ['', Validators.required],
      //questionStatement: ['', Validators.required],
      isPublic: [false]
    });
  }

  onSubmit() {
    if (this.questionForm.valid) {
      const questionType = this.questionForm.get('questionType')?.value;
      console.log('Tipo de pregunta seleccionado:', questionType);

      let questionData;
      if (questionType === 'trueFalse' && this.falsoVerdaderoComponent) {
        questionData = this.falsoVerdaderoComponent.getFormData();
      } else if (questionType === 'multipleChoice' && this.opcionMultipleComponent) {
        questionData = this.opcionMultipleComponent.getFormData();
      } else if (this.multipleRespuestaComponent) {
        questionData = this.multipleRespuestaComponent.getFormData();
      }

      const finalData = {
        ...this.questionForm.value,
        ...questionData
      };

      console.log('Datos finales:', finalData);
      // Aquí puedes enviar los datos finales a tu servidor o hacer lo que necesites con ellos
    } else {
      console.log('El formulario no está completo. Faltan los siguientes campos:');
      Object.keys(this.questionForm.controls).forEach(controlName => {
        const control = this.questionForm.get(controlName);
        if (control && control.invalid) {
          console.log(controlName);
        }
      });
    }
  }


  toggleQuestionContainers(): void {
    const questionControl = this.questionForm.get('questionType');
    if (questionControl) {
      const questionType = questionControl.value;
      this.showMultipleRespuestaContainer = questionType === 'multipleAnswers';
      this.showOpcionMultipleContainer = questionType === 'multipleChoice';
      this.showFalsoVerdaderoContainer = questionType === 'trueFalse';
    }
  }
}