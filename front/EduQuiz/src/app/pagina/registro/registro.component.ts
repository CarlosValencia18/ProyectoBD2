import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterOutlet} from "@angular/router";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [
    FormsModule,ReactiveFormsModule,RouterOutlet
  ],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegistroComponent {
  roles = ['Estudiante', 'Docente'];

  registro = {
    identificacion: '',
    nombres: '',
    apellidos: '',
    correo: '',
    contrasena: '',
    rol: this.roles[0]
  };

  registrar() {
    // Aquí puedes añadir el código para registrar al usuario
    console.log('Registro:', this.registro);

  }
}
