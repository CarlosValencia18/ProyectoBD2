import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreguntaMRComponent } from './pregunta-mr.component';

describe('PreguntaMRComponent', () => {
  let component: PreguntaMRComponent;
  let fixture: ComponentFixture<PreguntaMRComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PreguntaMRComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PreguntaMRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
