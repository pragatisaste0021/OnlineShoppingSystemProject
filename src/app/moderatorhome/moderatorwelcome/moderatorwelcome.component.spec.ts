import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModeratorwelcomeComponent } from './moderatorwelcome.component';

describe('ModeratorwelcomeComponent', () => {
  let component: ModeratorwelcomeComponent;
  let fixture: ComponentFixture<ModeratorwelcomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModeratorwelcomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModeratorwelcomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
