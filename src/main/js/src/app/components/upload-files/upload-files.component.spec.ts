import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadFIlesComponent } from './upload-files.component';

describe('UploadFIlesComponent', () => {
  let component: UploadFIlesComponent;
  let fixture: ComponentFixture<UploadFIlesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UploadFIlesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadFIlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
