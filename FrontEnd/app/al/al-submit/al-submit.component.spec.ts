import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlSubmitComponent } from './al-submit.component';

describe('AlSubmitComponent', () => {
  let component: AlSubmitComponent;
  let fixture: ComponentFixture<AlSubmitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlSubmitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlSubmitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
