import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeleccionarExamenComponent } from './seleccionar-examen.component';

describe('SeleccionarExamenComponent', () => {
  let component: SeleccionarExamenComponent;
  let fixture: ComponentFixture<SeleccionarExamenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SeleccionarExamenComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SeleccionarExamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
