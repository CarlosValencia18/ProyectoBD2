import {
  Component,
  CUSTOM_ELEMENTS_SCHEMA,
  NgModule,
  OnInit,
} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './pagina/login/login.component';
import { CommonModule } from '@angular/common';
import { ApiRestService } from './apirest.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppComponent implements OnInit {
  // Implementa OnInit
  title = 'EduQuiz';

  constructor(private apiRestService: ApiRestService) {} // Inyecta ApiRestService

  ngOnInit() {
    this.apiRestService.getGreeting().subscribe((data) => {
      // Llama a getGreeting() en ngOnInit()
      console.log(data);
    });
  }
}
