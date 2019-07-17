import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlDirectoryComponent } from './al-directory.component';

describe('AlDirectoryComponent', () => {
  let component: AlDirectoryComponent;
  let fixture: ComponentFixture<AlDirectoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlDirectoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlDirectoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
