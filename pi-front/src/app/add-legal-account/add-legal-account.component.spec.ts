import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLegalAccountComponent } from './add-legal-account.component';

describe('AddLegalAccountComponent', () => {
  let component: AddLegalAccountComponent;
  let fixture: ComponentFixture<AddLegalAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddLegalAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLegalAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
