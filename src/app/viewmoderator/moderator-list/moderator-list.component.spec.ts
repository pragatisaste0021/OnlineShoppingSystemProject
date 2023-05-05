import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModeratorListComponent } from './moderator-list.component';

describe('ModeratorListComponent', () => {
  let component: ModeratorListComponent;
  let fixture: ComponentFixture<ModeratorListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModeratorListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModeratorListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
