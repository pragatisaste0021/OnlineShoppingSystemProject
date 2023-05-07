import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModeratorloginComponent } from './moderatorlogin.component';

describe('ModeratorloginComponent', () => {
  let component: ModeratorloginComponent;
  let fixture: ComponentFixture<ModeratorloginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModeratorloginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModeratorloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
