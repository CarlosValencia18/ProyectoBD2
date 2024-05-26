import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearBancoPreguntasComponent } from './crear-banco-preguntas.component';

describe('CrearBancoPreguntasComponent', () => {
  let component: CrearBancoPreguntasComponent;
  let fixture: ComponentFixture<CrearBancoPreguntasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrearBancoPreguntasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrearBancoPreguntasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
