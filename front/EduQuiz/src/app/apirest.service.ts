import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiRestService {
  constructor(private http: HttpClient) {}

  getGreeting(): Observable<any> {
    return this.http.get<any>('api/');
  }
}
