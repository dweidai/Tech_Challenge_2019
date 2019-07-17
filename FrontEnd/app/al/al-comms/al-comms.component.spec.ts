import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlCommsComponent } from './al-comms.component';

describe('AlCommsComponent', () => {
  let component: AlCommsComponent;
  let fixture: ComponentFixture<AlCommsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlCommsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlCommsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
