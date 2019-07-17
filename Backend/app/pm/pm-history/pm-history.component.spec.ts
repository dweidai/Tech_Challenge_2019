import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PmHistoryComponent } from './pm-history.component';

describe('PmHistoryComponent', () => {
  let component: PmHistoryComponent;
  let fixture: ComponentFixture<PmHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PmHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PmHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
