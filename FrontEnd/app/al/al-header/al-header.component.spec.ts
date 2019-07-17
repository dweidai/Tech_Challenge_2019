import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlHeaderComponent } from './al-header.component';

describe('AlHeaderComponent', () => {
  let component: AlHeaderComponent;
  let fixture: ComponentFixture<AlHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
