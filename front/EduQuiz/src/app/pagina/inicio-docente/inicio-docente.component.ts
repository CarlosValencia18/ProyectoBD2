import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { HttpClient, HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-inicio-docente',
  standalone: true,
  imports: [
    CommonModule, // Añade CommonModule aquí
    RouterOutlet,
  ],
  templateUrl: './inicio-docente.component.html',
  styleUrls: ['./inicio-docente.component.css'],
})
export class InicioDocenteComponent implements OnInit {
  idUsuario: string = history.state.idUsuario;
  examenesCreados = [
    { nombre: 'Examen 1', descripcion: 'Descripción del Examen 1' },
    { nombre: 'Examen 2', descripcion: 'Descripción del Examen 2' },
    // Agrega más exámenes aquí
  ];

  bancosDePreguntas = [
    { nombre: 'Banco 1', descripcion: 'Descripción del Banco 1' },
    { nombre: 'Banco 2', descripcion: 'Descripción del Banco 2' },
    // Agrega más bancos aquí
  ];

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    const url = 'http://localhost:8081/inicio-docente';
    const params = new HttpParams().set('idUsuario', this.idUsuario);

    this.http.get<any>(url, { params }).subscribe({
      next: (response: any) => {
        console.log(response);
        this.examenesCreados = response;
      },
      error: (error) => {
        console.error(error);
      },
    });
  }

  verExamen(examen: any): void {
    console.log('Viendo el examen:', examen.nombre);
  }

  crearExamen(): void {
    console.log('Creando un nuevo examen...');
    this.router.navigate(['/crear-examen'], {
      state: { idUsuario: this.idUsuario },
    });
  }

  verBanco(banco: any): void {
    console.log('Viendo el banco de preguntas:', banco.nombre);
  }

  crearBanco(): void {
    this.router.navigate(['/crear-banco'], {
      state: { idUsuario: this.idUsuario },
    });
  }

  cerrarSesion(event: Event): void {
    event.preventDefault();
    console.log('Cerrando sesión...');
    this.router.navigate(['/login']);
  }

  asignarExamen() {
    this.router.navigate(['/asignar-examen']);
  }
}
