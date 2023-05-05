import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserproductformComponent } from './userproductform.component';

describe('UserproductformComponent', () => {
  let component: UserproductformComponent;
  let fixture: ComponentFixture<UserproductformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserproductformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserproductformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
