import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ALHomeComponent } from './al-home.component';

describe('ALHomeComponent', () => {
  let component: ALHomeComponent;
  let fixture: ComponentFixture<ALHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ALHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ALHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
