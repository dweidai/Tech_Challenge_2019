import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmCommsComponent } from './bpm-comms.component';

describe('BpmCommsComponent', () => {
  let component: BpmCommsComponent;
  let fixture: ComponentFixture<BpmCommsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmCommsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmCommsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
