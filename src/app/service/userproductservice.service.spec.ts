import { TestBed } from '@angular/core/testing';

import { UserproductserviceService } from './userproductservice.service';

describe('UserproductserviceService', () => {
  let service: UserproductserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserproductserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
