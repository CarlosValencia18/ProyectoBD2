import {Component, CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from "./pagina/login/login.component";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})

export class AppComponent {
  title = 'EduQuiz';
}
