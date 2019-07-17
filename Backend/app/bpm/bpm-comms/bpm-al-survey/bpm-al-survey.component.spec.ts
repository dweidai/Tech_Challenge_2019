import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmAlSurveyComponent } from './bpm-al-survey.component';

describe('BpmAlSurveyComponent', () => {
  let component: BpmAlSurveyComponent;
  let fixture: ComponentFixture<BpmAlSurveyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmAlSurveyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmAlSurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
