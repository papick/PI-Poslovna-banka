import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransferCheckComponent } from './transfer-check.component';

describe('TransferCheckComponent', () => {
  let component: TransferCheckComponent;
  let fixture: ComponentFixture<TransferCheckComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransferCheckComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransferCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
