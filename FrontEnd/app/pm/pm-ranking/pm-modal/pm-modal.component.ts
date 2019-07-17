import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-pm-modal',
  templateUrl: './pm-modal.component.html',
  styleUrls: ['./pm-modal.component.css']
})
export class PmModalComponent implements OnInit {

  @Input() rotations = [];
  why: string;

  constructor(public activeModal: NgbActiveModal) { }

  ngOnInit() {
  }

  submitRotation() {
    console.log(this.why);
    this.activeModal.close();
  }
}
