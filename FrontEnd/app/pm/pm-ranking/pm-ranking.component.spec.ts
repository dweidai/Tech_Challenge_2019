import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PmRankingComponent } from './pm-ranking.component';

describe('PmRankingComponent', () => {
  let component: PmRankingComponent;
  let fixture: ComponentFixture<PmRankingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PmRankingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PmRankingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
