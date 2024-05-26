import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-crear-banco-preguntas',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  templateUrl: './crear-banco-preguntas.component.html',
  styleUrls: ['./crear-banco-preguntas.component.css']
})
export class CrearBancoPreguntasComponent implements OnInit {
  preguntasCreadas = [
    { titulo: 'Pregunta 1', descripcion: 'Descripción de la Pregunta 1' },
    { titulo: 'Pregunta 2', descripcion: 'Descripción de la Pregunta 2' },
    // Agrega más preguntas aquí
  ];

  constructor() { }

  ngOnInit(): void { }

  crearPregunta(): void {
    console.log('Creando una nueva pregunta...');
  }

  editarPregunta(pregunta: any): void {
    console.log('Editando la pregunta:', pregunta.titulo);
  }

  cerrarSesion(event: Event): void {
    event.preventDefault();
    console.log('Cerrando sesión...');
  }
}
