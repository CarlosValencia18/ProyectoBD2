import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-seleccionar-examen',
  standalone: true,
  templateUrl: './seleccionar-examen.component.html',
  styleUrls: ['./seleccionar-examen.component.css'],
  imports: [CommonModule, RouterOutlet],
})
export class SeleccionarExamenComponent implements OnInit {
  examenesDisponibles = [
    { nombre: 'Examen 1', descripcion: 'Descripción del Examen 1' },
    { nombre: 'Examen 2', descripcion: 'Descripción del Examen 2' },
    // Agrega más exámenes aquí
  ];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    const idUsuario = history.state.idUsuario; // Obtiene idUsuario del estado de la navegación
    const url = 'http://localhost:8081/seleccionar-examen';
    const params = new HttpParams().set('idUsuario', idUsuario);

    this.http.get<any>(url, { params }).subscribe({
      next: (response: any) => {
        this.examenesDisponibles = response;
      },
      error: (error) => {
        console.error(error);
      },
    });
  }

  presentarExamen(examen: any): void {
    console.log('Presentando el examen:', examen.nombre);
  }
  cerrarSesion(event: Event): void {
    event.preventDefault();
    console.log('Cerrando sesión...');
  }
}
