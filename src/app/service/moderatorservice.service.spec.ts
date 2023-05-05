import { TestBed } from '@angular/core/testing';

import { ModeratorserviceService } from './moderatorservice.service';

describe('ModeratorserviceService', () => {
  let service: ModeratorserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModeratorserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
