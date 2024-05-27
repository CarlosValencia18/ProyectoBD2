// examen-resuelto.component.ts
import { Component } from '@angular/core';
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-examen-resuelto',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './examen-resuelto.component.html',
  styleUrl: './examen-resuelto.component.css'
})
export class ExamenResueltoComponent {
  examen = [
    { pregunta: '¿Cuál es la capital de Francia?', respuestaCorrecta: 'Paris' },
    { pregunta: '¿Cuáles son los colores primarios?', respuestaCorrecta: ['Rojo', 'Verde', 'Azul'] },
    { pregunta: '¿La tierra es plana?', respuestaCorrecta: false }
  ];
  respuestasPresentadas = ['Paris', ['Rojo', 'Verde'], false];
  correctas = 0;
  incorrectas = 0;
  nota = 0;
  esRespuestaCorrecta(respuestaCorrecta: any, respuestaPresentada: any): boolean {
    return JSON.stringify(respuestaCorrecta) === JSON.stringify(respuestaPresentada);
  }
  constructor() {} // Inyecta el servicio

  ngOnInit(): void {
    // Calcula las estadísticas del examen
    for (let i = 0; i < this.examen.length; i++) {
      if (JSON.stringify(this.examen[i].respuestaCorrecta) === JSON.stringify(this.respuestasPresentadas[i])) {
        this.correctas++;
      } else {
        this.incorrectas++;
      }
    }
    this.nota = (this.correctas / this.examen.length) * 100;
  }
}
