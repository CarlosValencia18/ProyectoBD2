import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {RouterOutlet} from "@angular/router";
import {CommonModule} from "@angular/common";
import {AppComponent} from "../../app.component";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [AppComponent,ReactiveFormsModule,RouterOutlet,FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup = new FormGroup({
    'username': new FormControl(null, Validators.required),
    'password': new FormControl(null, Validators.required)
  })

  ngOnInit() {



  }
  onSubmit(){
    console.log(this.loginForm.value);
  }
}
