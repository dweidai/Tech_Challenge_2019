import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmAssignmentComponent } from './bpm-assignment.component';

describe('BpmAssignmentComponent', () => {
  let component: BpmAssignmentComponent;
  let fixture: ComponentFixture<BpmAssignmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmAssignmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmAssignmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
