import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadedImageGalleryComponent } from './uploaded-image-gallery.component';

describe('UploadedImageGalleryComponent', () => {
  let component: UploadedImageGalleryComponent;
  let fixture: ComponentFixture<UploadedImageGalleryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UploadedImageGalleryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadedImageGalleryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
