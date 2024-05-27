import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MultipleRespuestaComponent } from './multiple-respuesta.component';

describe('MultipleRespuestaComponent', () => {
  let component: MultipleRespuestaComponent;
  let fixture: ComponentFixture<MultipleRespuestaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MultipleRespuestaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MultipleRespuestaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
