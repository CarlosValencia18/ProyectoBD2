import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreguntaFVComponent } from './pregunta-fv.component';

describe('PreguntaFVComponent', () => {
  let component: PreguntaFVComponent;
  let fixture: ComponentFixture<PreguntaFVComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PreguntaFVComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PreguntaFVComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
