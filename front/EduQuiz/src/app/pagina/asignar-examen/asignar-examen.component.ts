import { Component } from '@angular/core';
import {FormsModule, NgForm, ReactiveFormsModule} from "@angular/forms";
import {RouterOutlet} from "@angular/router";
import {CommonModule} from "@angular/common";
import {Router} from "@angular/router";

@Component({
  selector: 'app-asignar-examen',
  standalone: true,
  imports: [
    FormsModule,ReactiveFormsModule,RouterOutlet,CommonModule
  ],
  templateUrl: './asignar-examen.component.html',
  styleUrl: './asignar-examen.component.css'
})
export class AsignarExamenComponent {
  onSubmit(form: NgForm) {
    console.log(form.value);
    // Aquí puede agregar la lógica para asignar el examen al grupo con el peso dado
  }
}
