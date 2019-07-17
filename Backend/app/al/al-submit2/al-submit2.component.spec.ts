import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlSubmit2Component } from './al-submit2.component';

describe('AlSubmit2Component', () => {
  let component: AlSubmit2Component;
  let fixture: ComponentFixture<AlSubmit2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlSubmit2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlSubmit2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
