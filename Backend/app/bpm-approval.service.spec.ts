import { TestBed } from '@angular/core/testing';

import { BpmApprovalService } from './bpm-approval.service';

describe('BpmApprovalService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BpmApprovalService = TestBed.get(BpmApprovalService);
    expect(service).toBeTruthy();
  });
});
