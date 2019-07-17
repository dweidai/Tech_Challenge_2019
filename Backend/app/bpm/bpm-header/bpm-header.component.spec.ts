import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmHeaderComponent } from './bpm-header.component';

describe('BpmHeaderComponent', () => {
  let component: BpmHeaderComponent;
  let fixture: ComponentFixture<BpmHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
