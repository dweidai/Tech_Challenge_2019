import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RotationCardComponent } from './rotation-card.component';

describe('RotationCardComponent', () => {
  let component: RotationCardComponent;
  let fixture: ComponentFixture<RotationCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RotationCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RotationCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
