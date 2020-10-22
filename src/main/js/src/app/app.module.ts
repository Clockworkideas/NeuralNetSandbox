import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UploadedImageGalleryComponent } from './components/uploaded-image-gallery/uploaded-image-gallery.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ImagePageComponent } from './components/image-page/image-page.component';
import { UploadFIlesComponent } from './components/upload-files/upload-files.component';


@NgModule({
  declarations: [
    AppComponent,
    UploadedImageGalleryComponent,
    ImagePageComponent,
    UploadFIlesComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
