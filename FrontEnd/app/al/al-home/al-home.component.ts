import { Component, OnInit } from '@angular/core';
import { HTTPService } from '../../http.service';

@Component({
  selector: 'app-al-home',
  templateUrl: './al-home.component.html',
  styleUrls: ['./al-home.component.css']
})
export class ALHomeComponent implements OnInit {

  //This array will come from backend. 
  //Need to write a function in HTTP Service to recieve it
  people: any[] = [ { "name": "Saranya Tadikonda",
                      "position":"Programmer",
                      "track": "IT",
                      "location":"Chicago",
                      "hiredDate": "8/8/8"
                    }
                  ];
  toDoItems: any = [];
  timeline: any = [];
  allItems:any = [];
  current: any = [];
  first: any = [];
  second: any = [];
  third: any = [];
  fourth: any = [];
  
  constructor(private HttpService: HTTPService) { }

  ngOnInit() {
    const observable = this.HttpService.populate_AL_home();
    observable.subscribe((response) =>
    {
      console.log(response);
      
      this.allItems = response["al/home"];
     // this.toDoItems = this.allItems[0]["todolist"];
      //this.timeline = this.allItems[1]["timeline"];
      this.first = this.allItems[2];
      this.allItems[3].description = "Make project specifications and cost estimates. Design and execute engineering experiments to create workable solutions. Develop engineering calculations, diagrams and technical reports. Complete required technical and regulatory documents. Ensure projects are completed on-time and within the specified budget. Present analysis results and project solutions to technical leads, senior leaders and clients as necessary.";
      this.second = this.allItems[3];
      this.third = this.allItems[4];
      this.fourth = this.allItems[5];
      this.current = this.first;
       
    });
    this.current = this.first;

    this.timeline = ["6/7 Rotations released", "7/15 Preferances due","7/30 Assign rotations"]
    this.toDoItems.push("Meet with program member");
    this.toDoItems.push("Submit a rotation");
    (<HTMLElement>document.getElementsByClassName("tabLink")[0]).click();

  }



  openTab(tabName,index) {
   
    if (index == 0) {
      this.current = this.first;
    } else if (index = 1) {
      this.current = this.second;
    } else if (index = 2) {
      this.current = this.third;
    } else if (index = 3) {
      this.current = this.fourth;
    }
    
    for (var i = 0; i < 4; i++) {
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.color = "Black";
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.borderBottom = "none";
    }
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.color = "#508BE4";
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.borderBottom = "3px solid #508BE4";
    
   // this.person = pm_2 EQUALS TO NEW ROTATION PM
  }

  
   //Shows the input field to add a rotation item
  open_timeline_tab(){
    document.getElementById('add_timeline').style.display = 'flex';
  }

  save_todo_item(){
    this.toDoItems.push((<HTMLInputElement>document.getElementById('todoInput')).value);
    console.log(this.toDoItems);
  }

  openTab(tabName,index) {
    var tabPages = ['first', 'second', 'third', 'fourth'];
    for (var i = 0; i < tabPages.length; i++) {
      document.getElementById(tabPages[i]).style.display = 'None';
    }
    document.getElementById(tabName).style.display = 'Block';

    for (var i = 0; i < 4; i++) {
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.color = "Black";
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.borderBottom = "none";
    }
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.color = "#508BE4";
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.borderBottom = "3px solid #508BE4";
    
  }

  

}
