import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FalsoVerdaderoComponent } from './falso-verdadero.component';

describe('FalsoVerdaderoComponent', () => {
  let component: FalsoVerdaderoComponent;
  let fixture: ComponentFixture<FalsoVerdaderoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FalsoVerdaderoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FalsoVerdaderoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
