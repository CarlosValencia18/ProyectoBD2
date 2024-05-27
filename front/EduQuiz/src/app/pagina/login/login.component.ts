import { Component, OnInit } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AppComponent } from '../../app.component';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [AppComponent, ReactiveFormsModule, RouterOutlet, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(private http: HttpClient, private router: Router) {}
  loginForm: FormGroup = new FormGroup({
    username: new FormControl(null, Validators.required),
    password: new FormControl(null, Validators.required),
  });

  ngOnInit() {}
  onSubmit() {
    const url = 'http://localhost:8081/login';
    const params = new HttpParams()
      .set('username', this.loginForm.value.username)
      .set('password', this.loginForm.value.password);
    this.http.post(url, params).subscribe({
      next: (response: any) => {
        console.log(response);
        if (response.idUsuario != null && 'idEstudiante' in response) {
          this.router.navigate(['/seleccionar-examen'], {
            state: { idUsuario: response.idUsuario },
          });
        } else if (response.idUsuario != null && 'idDocente' in response) {
          this.router.navigate(['/inicio-docente'], {
            state: { idUsuario: response.idUsuario },
          });
        } else {
          alert('Usuario o contraseña incorrectos');
        }
      },
      error: (error) => {
        console.error(error);
      },
    });
  }
}
