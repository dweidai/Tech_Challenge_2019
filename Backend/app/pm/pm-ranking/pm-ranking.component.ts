import { Component, OnInit, Output, EventEmitter, ViewEncapsulation } from '@angular/core';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { PmRankingService } from '../../pm-ranking.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PmModalComponent } from './pm-modal/pm-modal.component';
import { HTTPService } from '../../http.service';

@Component({
  selector: 'app-pm-ranking',
  templateUrl: './pm-ranking.component.html',
  styleUrls: ['./pm-ranking.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class PmRankingComponent implements OnInit {
  rotations = [];
  selectedRotation = {};
  notes: string;
  pmService: PmRankingService;

  constructor(private modalService: NgbModal, private HttpService: HTTPService,pmService: PmRankingService) {
    this.pmService = pmService;
    this.rotations = this.pmService.getRotations();
  }

  ngOnInit() {  
    const observable = this.HttpService.populate_PM_rotations();
    observable.subscribe((response) => {
      console.log(response);
    });
  }

  drop(event: CdkDragDrop<string[]>) {
    moveItemInArray(this.rotations, event.previousIndex, event.currentIndex);
  }

  onChoose(index) {
    this.selectedRotation = this.rotations[index];
  }

  removeRotation(index) {
    this.rotations.splice(index, 1);
  }

  open() {
    const modalRef = this.modalService.open(PmModalComponent, { centered: true, size: 'lg' });
    modalRef.componentInstance.rotations = this.rotations.slice(0, 3);
  }

  saveRanking() {
    console.log(this.notes);
  }
}
