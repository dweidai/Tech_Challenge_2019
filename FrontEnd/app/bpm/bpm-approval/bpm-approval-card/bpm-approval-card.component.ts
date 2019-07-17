import { Component, OnInit, Input } from '@angular/core';
import { BpmApprovalService } from 'src/app/bpm-approval.service';

@Component({
  selector: 'app-bpm-approval-card',
  templateUrl: './bpm-approval-card.component.html',
  styleUrls: ['./bpm-approval-card.component.css']
})
export class BpmApprovalCardComponent implements OnInit {

  @Input() submission: object;
  bpmService: BpmApprovalService;

  constructor(bpmService: BpmApprovalService) {
    this.bpmService = bpmService;
  }

  ngOnInit() {
  }

}
