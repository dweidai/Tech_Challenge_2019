import { Component, OnInit } from '@angular/core';
import { HTTPService } from '../../http.service';


@Component({
  selector: 'app-al-comms',
  templateUrl: './al-comms.component.html',
  styleUrls: ['./al-comms.component.css']
})
export class AlCommsComponent implements OnInit {
  feedback: string;
  toDo = [
    {
      task: 'Submit rotation form for the next round of rotations',
      checked: true
    },
    {
      task: 'Fill out survey',
      checked: false
    }
  ];
  pms = [
    'David Dai',
    'Bailey Kaplan',
    'Felipe Vieira',
    'Christine Lee',
    'Saranya Tadikonda'
  ]

  constructor(private HttpService: HTTPService) { }

  ngOnInit() {
    const observable = this.HttpService.populate_AL_communications();
    observable.subscribe((response) => {
      this.toDo = response["al/communication"][0]["todolist"];
    })
  }

  onSubmit(form) {
    const survey = {
      ...form.value,
      feedback: this.feedback
    };
    console.log(survey);
  }
}
