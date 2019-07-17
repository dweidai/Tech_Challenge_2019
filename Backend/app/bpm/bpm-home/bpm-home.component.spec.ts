import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BPMHomeComponent } from './bpm-home.component';

describe('BPMHomeComponent', () => {
  let component: BPMHomeComponent;
  let fixture: ComponentFixture<BPMHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BPMHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BPMHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
