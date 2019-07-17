import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PmDirectoryComponent } from './pm-directory.component';

describe('PmDirectoryComponent', () => {
  let component: PmDirectoryComponent;
  let fixture: ComponentFixture<PmDirectoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PmDirectoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PmDirectoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
