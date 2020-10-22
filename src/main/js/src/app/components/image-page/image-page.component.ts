import { Component, OnInit } from '@angular/core';
import {UploadFileService} from "../../services/upload-file.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-image-page',
  templateUrl: './image-page.component.html',
  styleUrls: ['./image-page.component.css']
})
export class ImagePageComponent implements OnInit {

  fileInfos: Observable<any>;
  constructor(private fileService:UploadFileService) { }

  ngOnInit(): void {
    this.fileInfos=this.fileService.getFiles();
  }

  refreshList($event: string) {
    this.fileInfos=this.fileService.getFiles();
  }
}
