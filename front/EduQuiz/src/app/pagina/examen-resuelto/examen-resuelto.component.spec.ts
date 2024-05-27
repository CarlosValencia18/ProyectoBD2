import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamenResueltoComponent } from './examen-resuelto.component';

describe('ExamenResueltoComponent', () => {
  let component: ExamenResueltoComponent;
  let fixture: ComponentFixture<ExamenResueltoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExamenResueltoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ExamenResueltoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
