import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-seleccionar-examen',
  standalone: true,
  templateUrl: './seleccionar-examen.component.html',
  styleUrls: ['./seleccionar-examen.component.css'],
  imports: [CommonModule, RouterOutlet]
})
export class SeleccionarExamenComponent implements OnInit {
  examenesDisponibles = [
    { nombre: 'Examen 1', descripcion: 'Descripción del Examen 1' },
    { nombre: 'Examen 2', descripcion: 'Descripción del Examen 2' },
    // Agrega más exámenes aquí
  ];

  constructor() { }

  ngOnInit(): void { }

  presentarExamen(examen: any): void {
    console.log('Presentando el examen:', examen.nombre);
  }
  cerrarSesion(event: Event): void {
    event.preventDefault();
    console.log('Cerrando sesión...');
  }
}
