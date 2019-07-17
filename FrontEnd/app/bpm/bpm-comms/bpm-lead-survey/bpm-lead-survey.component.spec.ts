import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmLeadSurveyComponent } from './bpm-lead-survey.component';

describe('BpmLeadSurveyComponent', () => {
  let component: BpmLeadSurveyComponent;
  let fixture: ComponentFixture<BpmLeadSurveyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmLeadSurveyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmLeadSurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
