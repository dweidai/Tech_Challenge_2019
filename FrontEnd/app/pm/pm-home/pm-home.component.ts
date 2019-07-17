import { Component, OnInit } from '@angular/core';
import { HTTPService } from '../../http.service';

@Component({
  selector: 'app-pm-home',
  templateUrl: './pm-home.component.html',
  styleUrls: ['./pm-home.component.css']
})
export class PMHomeComponent implements OnInit {

 //This array will come from backend. 
  //Need to write a function in HTTP Service to recieve it
  people: any[] = [ { "name": "Saranya Tadikonda",
  "position":"Programmer",
  "track": "IT",
  "location":"Chicago",
  "hiredDate": "8/8/8"
}
];
items: any;
toDoItems: any = ["Submit Assignments"];
timeline: any = ["6/7 Rotations released", "7/15 Preferences due"];
first: any;
second: any;
third: any;
fourth: any;
current: any;

  constructor(private HttpService: HTTPService) { }

  ngOnInit() {
    const observable = this.HttpService.populate_PM_home();
    observable.subscribe((response) => {
      console.log(response);
      this.items = response["lead/history"];
     // this.toDoItems = this.items[0]["todolist"];
     // this.timeline = this.items[1]["timeline"];
      this.first = this.items[2];
      this.second = this.items[3];
      this.third = this.items[4];
      this.fourth = this.items[5];
      this.current = this.first;
    });
    
    this.toDoItems = ["Rank rotations","Meet with Assignment Leader"]
    this.timeline = ["6/7 Rotations released", "7/15 Preferances due","7/30 Assign rotations"];

    (<HTMLElement>document.getElementsByClassName("tabLink")[0]).click();


  }

  get_rotation_details() {
    //Call the function in HTTP service 
  }

  openTab(tabName,index) {
    if (index == 0) {
      this.current = this.first;
    } else if (index == 1) {
      this.current = this.second;
    } else if (index == 2) {
      this.current = this.third;
    }

    for (var i = 0; i < 4; i++) {
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.color = "Black";
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.borderBottom = "none";
    }
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.color = "#508BE4";
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.borderBottom = "3px solid #508BE4";
   // this.person = ??;
    this.get_rotation_details(); 
  }

   //Shows the input field to add a to do item
  open_tab() {
    document.getElementById('add_todo').style.display = 'flex';
  }
   //Shows the input field to add a rotation item
  open_timeline_tab(){
    document.getElementById('add_timeline').style.display = 'flex';
  }


  //Adds a to-do item to the list and sends it to the backend to save for future use
  save_todo_item(){
    this.toDoItems.push((<HTMLInputElement>document.getElementById('todoInput')).value);
    console.log(this.toDoItems);
  }



  
  

}
