import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModeratorformComponent } from './moderatorform.component';

describe('ModeratorformComponent', () => {
  let component: ModeratorformComponent;
  let fixture: ComponentFixture<ModeratorformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModeratorformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModeratorformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
