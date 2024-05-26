// crear-pregunta.component.ts
import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {RouterOutlet} from "@angular/router";

@Component({
  standalone: true,
  selector: 'app-crear-pregunta',
  templateUrl: './crear-pregunta.component.html',
  imports: [
    ReactiveFormsModule,RouterOutlet
  ],
  styleUrls: ['./crear-pregunta.component.css']
})
export class CrearPreguntaComponent implements OnInit {
  questionForm: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.questionForm = this.formBuilder.group({
      questionTopic: ['', Validators.required],
      questionType: ['', Validators.required],
      questionStatement: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.questionForm.valid) {
      // Aquí puedes manejar la lógica de envío del formulario
      console.log(this.questionForm.value);
    }
  }
}
