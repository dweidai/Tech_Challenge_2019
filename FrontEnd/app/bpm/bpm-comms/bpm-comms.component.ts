import { Component, OnInit } from '@angular/core';
import { HTTPService } from '../../http.service';

@Component({
  selector: 'app-bpm-comms',
  templateUrl: './bpm-comms.component.html',
  styleUrls: ['./bpm-comms.component.css']
})
export class BpmCommsComponent implements OnInit {
  chosenSubmission = '';
  submissions = [
    {
      date: '06/18/19',
      name: 'David Dai',
      step: 'Feedback'
    },
    {
      date: '06/18/19',
      name: 'Bailey Kaplan',
      step: 'Survey'
    },
    {
      date: '06/18/19',
      name: 'Felipe Vieira',
      step: 'Survey'
    },
    {
      date: '06/18/19',
      name: 'Christine Lee',
      step: 'Feedback'
    },
    {
      date: '06/18/19',
      name: 'Felipe Vieira',
      step: 'Feedback'
    }
  ];
  toDo = [
    {
      task: "Send out surveys to AL's and Program Members",
      checked: true
    },
    {
      task: 'Submit rotations',
      checked: false
    }
  ];

  chosenTab: string;

  constructor(private HttpService: HTTPService) { }

  ngOnInit() {
    const observable = this.HttpService.populate_BPM_communications();
    observable.subscribe((response) =>
    {
      this.toDo = response["bpm/communication"][0]["todolist"];
    })
    this.chosenTab = '';
  }

}
