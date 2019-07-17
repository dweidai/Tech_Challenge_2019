import { Component, OnInit } from '@angular/core';
import { BpmApprovalService } from 'src/app/bpm-approval.service';
import { HTTPService } from '../../http.service';

@Component({
  selector: 'app-bpm-approval',
  templateUrl: './bpm-approval.component.html',
  styleUrls: ['./bpm-approval.component.css']
})
export class BpmApprovalComponent implements OnInit {
  submissions = [];
  selectedSubmission = {};
  chosenSubmission: string;
  bpmService: BpmApprovalService;

  constructor(bpmService: BpmApprovalService,private HttpService: HTTPService) {
    this.bpmService = bpmService;
    this.submissions = bpmService.getSubmissions();
  }

  ngOnInit() { 
    //Filter the data recieved from the backend into variables to be used later    

    const observable = this.HttpService.populate_BPM_approval();
    observable.subscribe((response) =>
    {
       console.log(response); 
    });
  }

  onChoose(index) {
    this.selectedSubmission = this.submissions[index];
  }

  saveRanking() {
    console.log(this.submissions);
  }
}
