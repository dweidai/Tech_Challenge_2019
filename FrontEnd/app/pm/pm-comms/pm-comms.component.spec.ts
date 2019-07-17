import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PmCommsComponent } from './pm-comms.component';

describe('PmCommsComponent', () => {
  let component: PmCommsComponent;
  let fixture: ComponentFixture<PmCommsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PmCommsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PmCommsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
