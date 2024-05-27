import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreguntaOMComponent } from './pregunta-om.component';

describe('PreguntaOMComponent', () => {
  let component: PreguntaOMComponent;
  let fixture: ComponentFixture<PreguntaOMComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PreguntaOMComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PreguntaOMComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
