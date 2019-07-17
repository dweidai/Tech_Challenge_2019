import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PmForumComponent } from './pm-forum.component';

describe('PmForumComponent', () => {
  let component: PmForumComponent;
  let fixture: ComponentFixture<PmForumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PmForumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PmForumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
