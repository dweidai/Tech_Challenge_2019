import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmApprovalCardComponent } from './bpm-approval-card.component';

describe('BpmApprovalCardComponent', () => {
  let component: BpmApprovalCardComponent;
  let fixture: ComponentFixture<BpmApprovalCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmApprovalCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmApprovalCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
