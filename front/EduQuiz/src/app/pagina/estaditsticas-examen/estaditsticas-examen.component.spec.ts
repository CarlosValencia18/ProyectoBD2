import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstaditsticasExamenComponent } from './estaditsticas-examen.component';

describe('EstaditsticasExamenComponent', () => {
  let component: EstaditsticasExamenComponent;
  let fixture: ComponentFixture<EstaditsticasExamenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EstaditsticasExamenComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EstaditsticasExamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
