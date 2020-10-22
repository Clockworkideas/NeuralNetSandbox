import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ImagePageComponent} from "./components/image-page/image-page.component";


const routes: Routes = [
  {
    path: '' , component: ImagePageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
