import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmLeadMetricsComponent } from './bpm-lead-metrics.component';

describe('BpmLeadMetricsComponent', () => {
  let component: BpmLeadMetricsComponent;
  let fixture: ComponentFixture<BpmLeadMetricsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmLeadMetricsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmLeadMetricsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
