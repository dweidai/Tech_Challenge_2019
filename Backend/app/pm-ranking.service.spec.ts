import { TestBed } from '@angular/core/testing';

import { PmRankingService } from './pm-ranking.service';

describe('PmRankingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PmRankingService = TestBed.get(PmRankingService);
    expect(service).toBeTruthy();
  });
});
