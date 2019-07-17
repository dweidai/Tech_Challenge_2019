import { Component, OnInit } from '@angular/core';
import { HTTPService } from '../../http.service';


@Component({
  selector: 'app-pm-comms',
  templateUrl: './pm-comms.component.html',
  styleUrls: ['./pm-comms.component.css']
})
export class PmCommsComponent implements OnInit {
  feedback: string;
  toDo = [
    {
      task: 'Submit rotation form for the next roud of rotations',
      checked: true
    },
    {
      task: 'Fill out survey',
      checked: false
    }
  ];

  constructor(private HttpService: HTTPService) { }

  ngOnInit() { 
    const observable = this.HttpService.populate_PM_communications();
    observable.subscribe((response) => {
      console.log(response);
      this.toDo = response["lead/communications"][0]["todolist"];
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
