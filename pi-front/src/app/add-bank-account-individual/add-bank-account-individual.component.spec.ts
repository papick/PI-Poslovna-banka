import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBankAccountIndividualComponent } from './add-bank-account-individual.component';

describe('AddBankAccountIndividualComponent', () => {
  let component: AddBankAccountIndividualComponent;
  let fixture: ComponentFixture<AddBankAccountIndividualComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddBankAccountIndividualComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddBankAccountIndividualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
