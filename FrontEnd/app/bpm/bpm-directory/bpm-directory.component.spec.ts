import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmDirectoryComponent } from './bpm-directory.component';

describe('BpmDirectoryComponent', () => {
  let component: BpmDirectoryComponent;
  let fixture: ComponentFixture<BpmDirectoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmDirectoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmDirectoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
