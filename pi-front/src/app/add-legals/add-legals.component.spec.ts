import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBankAccountLegalsComponent } from './add-legals.component';

describe('AddBankAccountLegalsComponent', () => {
  let component: AddBankAccountLegalsComponent;
  let fixture: ComponentFixture<AddBankAccountLegalsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddBankAccountLegalsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddBankAccountLegalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
