import { TestBed } from '@angular/core/testing';

import { UserdetailserviceService } from './userdetailservice.service';

describe('UserdetailserviceService', () => {
  let service: UserdetailserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserdetailserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
