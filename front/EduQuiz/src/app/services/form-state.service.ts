import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class FormStateService {
  private formState: any;

  saveFormState(form: FormGroup) {
    this.formState = form.value;
  }

  getFormState() {
    return this.formState;
  }
}
