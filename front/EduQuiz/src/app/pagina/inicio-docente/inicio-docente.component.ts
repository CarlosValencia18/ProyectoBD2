import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import {Router} from "@angular/router";// Importa CommonModule

@Component({
  selector: 'app-inicio-docente',
  standalone: true,
  imports: [
    CommonModule,  // Añade CommonModule aquí
    RouterOutlet
  ],
  templateUrl: './inicio-docente.component.html',
  styleUrls: ['./inicio-docente.component.css']
})
export class InicioDocenteComponent implements OnInit {
  examenesCreados = [
    {nombre: 'Examen 1', descripcion: 'Descripción del Examen 1'},
    {nombre: 'Examen 2', descripcion: 'Descripción del Examen 2'},
    // Agrega más exámenes aquí
  ];

  bancosDePreguntas = [
    {nombre: 'Banco 1', descripcion: 'Descripción del Banco 1'},
    {nombre: 'Banco 2', descripcion: 'Descripción del Banco 2'},
    // Agrega más bancos aquí
  ];

  constructor(private router: Router) {
  }

  ngOnInit(): void {
  }

  verExamen(examen: any): void {
    console.log('Viendo el examen:', examen.nombre);
  }

  crearExamen(): void {
    console.log('Creando un nuevo examen...');
  }

  verBanco(banco: any): void {
    console.log('Viendo el banco de preguntas:', banco.nombre);
  }

  crearBanco(): void {
    this.router.navigate(['/crear-banco']);
  }

  cerrarSesion(event: Event): void {
    event.preventDefault();
    console.log('Cerrando sesión...');
  }

  asignarExamen() {
    this.router.navigate(['/asignar-examen'])
  }
}
