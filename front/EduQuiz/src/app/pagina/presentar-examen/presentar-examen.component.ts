import { Component, Input, OnInit } from '@angular/core';
import { PreguntaMRComponent } from '../responder/pregunta-mr/pregunta-mr.component';
import { PreguntaOMComponent } from '../responder/pregunta-om/pregunta-om.component';
import { PreguntaFVComponent } from '../responder/pregunta-fv/pregunta-fv.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Importar FormsModule
import { RouterOutlet } from '@angular/router';
import { Router } from '@angular/router';
import { HttpClient, HttpParams } from '@angular/common/http';
@Component({
  selector: 'app-presentar-examen',
  templateUrl: './presentar-examen.component.html',
  styleUrls: ['./presentar-examen.component.css'],
  imports: [
    CommonModule,
    FormsModule, // Asegurarse de incluir FormsModule
    PreguntaOMComponent,
    PreguntaMRComponent,
    PreguntaFVComponent,
    RouterOutlet,
  ],
  standalone: true,
})
export class PresentarExamenComponent implements OnInit {
  @Input() preguntas: any[] = [];
  currentQuestionIndex = 0;
  selectedOption: string | null = '';
  respuestasSeleccionadas: (string | boolean | String[])[] = [];
  respuestasMultiplesSeleccionadas: string[][] = [];
  respuestaVerdaderoFalso: boolean | undefined; // Variable para almacenar la respuesta de verdadero/falso

  constructor(private http: HttpClient, private router: Router) {}
  contador: number = 0;
  intervalId: any;

  ngOnInit(): void {
    // Datos de prueba
    this.preguntas = [
      {
        type: 'trueFalse',
        enunciado: 'El sol es una estrella',
        respuesta: true,
        visible: true,
      },
      {
        type: 'multipleAnswers',
        enunciado: 'Selecciona los colores primarios',
        duracion: 2,
        visible: true,
        opciones: [
          { texto: 'Rojo', correcta: true },
          { texto: 'Verde', correcta: false },
          { texto: 'Azul', correcta: true },
          { texto: 'Amarillo', correcta: true },
        ],
      },
      {
        type: 'trueFalse',
        enunciado: 'El sol es una estrella',
        respuesta: true,
      },
      {
        type: 'multipleChoice',
        enunciado: '¿Cuál es la capital de Francia?',
        visible: true,
        opciones: [
          { texto: 'París', correcta: true },
          { texto: 'Londres', correcta: false },
          { texto: 'Berlín', correcta: false },
        ],
      },
    ];
    this.iniciarTemporizador(
      this.preguntas[this.currentQuestionIndex].duracion
    );
    const idExamen = history.state.idExamen; // Obtiene idExamen del estado de la navegación
    const url = 'http://localhost:8081/presentar-examen';
    const params = new HttpParams().set('idExamen', idExamen);

    this.http.get<any>(url, { params }).subscribe({
      next: (response: any) => {
        this.preguntas = response;
      },
      error: (error) => {
        console.error(error);
      },
    });
  }

  // Propiedades y métodos existentes...
  iniciarTemporizador(duracion: number) {
    this.contador = duracion * 60; // Convertir duración a segundos
    this.intervalId = setInterval(() => {
      this.contador--;
      if (this.contador === 0) {
        clearInterval(this.intervalId);
        this.preguntas[this.currentQuestionIndex].visible = false; // Ocultar la pregunta
      }
    }, 1000);
  }
  // Inicializamos selectedOption como null

  onAnswerSelected(answer: any) {
    if (answer === null) {
      // handle the case when answer is null
      return;
    }
    if (Array.isArray(answer)) {
      this.respuestasMultiplesSeleccionadas[this.currentQuestionIndex] = answer;
      this.respuestasSeleccionadas[this.currentQuestionIndex] =
        this.respuestasMultiplesSeleccionadas[this.currentQuestionIndex];
    } else {
      this.respuestasSeleccionadas[this.currentQuestionIndex] = answer;
    }
    console.log('Respuestas almacenadas:', this.respuestasSeleccionadas);
    console.log(
      'Respuestas múltiples almacenadas:',
      this.respuestasMultiplesSeleccionadas
    );
  }

  enviarRespuestaYSiguientePregunta() {
    //this.onAnswerSelected(this.selectedOption); // Almacena la respuesta seleccionada
    console.log(this.respuestasSeleccionadas[this.currentQuestionIndex]);
    console.log(
      this.respuestasMultiplesSeleccionadas[this.currentQuestionIndex]
    );
    // Si es la última pregunta, redirige al estudiante a la página de examen-resuelto
    if (this.currentQuestionIndex === this.preguntas.length - 1) {
      this.router.navigate(['/examen-resuelto']);
    } else {
      this.nextQuestion(); // Avanza a la siguiente pregunta
    } // Avanza a la siguiente pregunta
    this.selectedOption = ''; // Restablece la opción seleccionada para la nueva pregunta
    console.log('Respuestas almacenadas:', this.respuestasSeleccionadas);
  }
  nextQuestion(): void {
    if (this.currentQuestionIndex < this.preguntas.length - 1) {
      clearInterval(this.intervalId); // Detener el temporizador anterior
      this.currentQuestionIndex++;
      this.iniciarTemporizador(
        this.preguntas[this.currentQuestionIndex].duracion
      );
    }
  }

  prevQuestion(): void {
    if (this.currentQuestionIndex > 0) {
      clearInterval(this.intervalId); // Detener el temporizador anterior
      this.currentQuestionIndex--;
      this.iniciarTemporizador(
        this.preguntas[this.currentQuestionIndex].duracion
      );
    }
  }
}
