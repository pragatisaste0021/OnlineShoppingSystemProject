import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserproductlistComponent } from './userproductlist.component';

describe('UserproductlistComponent', () => {
  let component: UserproductlistComponent;
  let fixture: ComponentFixture<UserproductlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserproductlistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserproductlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
