import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-opcion-multiple',
  templateUrl: './opcion-multiple.component.html',
  imports: [
    ReactiveFormsModule, RouterOutlet
  ],
  styleUrls: ['./opcion-multiple.component.css']
})
export class OpcionMultipleComponent implements OnInit {
  questionForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.questionForm = this.formBuilder.group({
      questionTopic: ['', Validators.required],
      questionStatement: ['', Validators.required],
      options: this.formBuilder.group({
        option1: ['', Validators.required],
        option2: ['', Validators.required],
        option3: ['', Validators.required]
      }),
      correctOption: ['', Validators.required]
    });
  }

  ngOnInit() {}

  onSubmit() {
    if (this.questionForm.valid) {
      console.log(this.questionForm.value);
    }
  }
}
