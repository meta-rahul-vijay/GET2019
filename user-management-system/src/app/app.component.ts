import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'user-management-system';
}



//import { Component, ViewEncapsulation } from '@angular/core';
//import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

//@Component({
//    selector: 'app-root',
//    templateUrl: './app.component.html',
//    encapsulation: ViewEncapsulation.None,
//    styles: [`
//    .dark-modal .modal-content {
//      background-color: #292b2c;
//      color: white;
//    }
//    .dark-modal .close {
//      color: white;
//    }
//    .light-blue-backdrop {
//      background-color: #5cb3fd;
//    }
//  `]
//})
//export class AppComponent {
//    closeResult: string;

//    constructor(private modalService: NgbModal) { }

//    openBackDropCustomClass(content) {
//        this.modalService.open(content, { backdropClass: 'light-blue-backdrop' });
//    }

//    openWindowCustomClass(content) {
//        this.modalService.open(content, { windowClass: 'dark-modal' });
//    }

//    openSm(content) {
//        this.modalService.open(content, { size: 'sm' });
//    }

//    openLg(content) {
//        this.modalService.open(content, { size: 'lg' });
//    }

//    openXl(content) { this.modalService.open(content, { size: 'xl' }); }

//    openVerticallyCentered(content) {
//        this.modalService.open(content, { centered: true });
//    }

//    openScrollableContent(longContent) {
//        this.modalService.open(longContent, { scrollable: true });
//    }
//}
