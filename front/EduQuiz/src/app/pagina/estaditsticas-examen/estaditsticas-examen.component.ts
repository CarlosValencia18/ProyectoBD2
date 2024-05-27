import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";
import {CommonModule} from "@angular/common";
import {Router} from "@angular/router";

@Component({
  selector: 'app-estaditsticas-examen',
  standalone: true,
  imports: [RouterOutlet,CommonModule],
  templateUrl: './estaditsticas-examen.component.html',
  styleUrl: './estaditsticas-examen.component.css'
})

export class EstadisticasExamenComponent {
  estadisticasPreguntas = [
    { pregunta: '¿Cuál es la capital de Francia?', correctas: 80, incorrectas: 20, total: 100 },
    { pregunta: '¿Cuáles son los colores primarios?', correctas: 70, incorrectas: 30, total: 100 },
    { pregunta: '¿La tierra es plana?', correctas: 90, incorrectas: 10, total: 100 }
  ];

  constructor(private router: Router) {
  }

  volverAlInicio() {
    this.router.navigate(['/inicio-docente']);
  }
}
