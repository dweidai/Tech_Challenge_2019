import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmAlMetricsComponent } from './bpm-al-metrics.component';

describe('BpmAlMetricsComponent', () => {
  let component: BpmAlMetricsComponent;
  let fixture: ComponentFixture<BpmAlMetricsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmAlMetricsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmAlMetricsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
