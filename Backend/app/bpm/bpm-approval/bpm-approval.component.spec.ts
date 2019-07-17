import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmApprovalComponent } from './bpm-approval.component';

describe('BpmApprovalComponent', () => {
  let component: BpmApprovalComponent;
  let fixture: ComponentFixture<BpmApprovalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmApprovalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
