import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { HTTPService } from '../../http.service';
import { Observable } from 'rxjs';
import { analyzeAndValidateNgModules } from '@angular/compiler';

//Shows which html and css files this component will use
@Component({
  selector: 'app-bpm-home',
  templateUrl: './bpm-home.component.html',
  styleUrls: ['./bpm-home.component.css'],
})

//This class includes all functions used in this page
export class BPMHomeComponent implements OnInit {

  //Declare all variables used in this class
  pms_1: any = [];
  pms_2: any = [];
  pms_3: any = [];
  pms_4: any = [];
  current_pms: any = [];
  toDoItems: any = [];
  bpm_items: any = [];
  timeline: any = [];
  userJSON: any = {};
  selected_person: any = {};
 
  constructor(private HttpService: HTTPService) { }  

  ngOnInit() { 
    
    //Populates page with details when the page opens.
    const observable = this.HttpService.populate_BPM_home();
    
    observable.subscribe((response) =>
    {
      //Filter the data recieved from the backend into variables to be used later    
       console.log(response);  
       this.bpm_items = response['bpm/home'];  
       this.toDoItems = this.bpm_items[0]["todolist"];
       this.timeline = this.bpm_items[1]["timeline"];
       for (var i = 2; i < 6;i++) {
         this.pms_1.push(this.bpm_items[i]);
       }
       for (var i = 4; i < 6;i++) {
        this.pms_2.push(this.bpm_items[i]);
      }
      for (var i = 4; i < 8;i++) {
        this.pms_3.push(this.bpm_items[i]);
      }
      for (var i = 8; i < 14;i++) {
        this.pms_4.push(this.bpm_items[i]);
      }
       this.current_pms = this.pms_1;
       this.selected_person = this.current_pms[0];
       this.timeline = ["6/7 Rotations released", "7/15 Preferances due","7/30 Assign rotations"]
      this.toDoItems.push("Send out surveys to program members and assignment leaders");
    });

    //Opens the 1st rotation tab when the application starts
    (<HTMLElement>document.getElementsByClassName("tabLink")[0]).click(); 
  }


  //Opens the tab in the rotations box when clicked and hides the unneeded tabs
  openTab(index) {
    var tabPages = ['first', 'second', 'third', 'fourth'];
   
     if (index == 0) {
      this.current_pms = this.pms_1;
    } else if (index == 1) {
      this.current_pms = this.pms_2;
    } else if (index == 3) {
      this.current_pms = this.pms_3;
    } else if (index == 4) {
      this.current_pms = this.pms_4;
    } 

    for (var i = 0; i < 4; i++) {
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.color = "Black";
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.borderBottom = "none";
    }
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.color = "#508BE4";
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.borderBottom = "3px solid #508BE4";
   
  }
  //Show the expanded details of the selected program member
  showDescription(person) {
    console.log(person);
    this.selected_person = person;
    for (var i = 0; i < this.current_pms.length; i++) {
      (<HTMLElement>document.getElementById(this.current_pms[i].name)).style.backgroundColor= "white";
      (<HTMLElement>document.getElementById(this.current_pms[i].name)).style.borderLeft= "none";
    } 
    (<HTMLElement>document.getElementById(person.name)).style.borderLeft = "5px solid #508BE4";
    (<HTMLElement>document.getElementById(person.name)).style.backgroundColor = "#E7ECF4";
    (<HTMLInputElement>document.getElementById("expanded_details")).value = person.description;
   
  }

  //Shows the input field to add a to do item
  open_tab() {
    document.getElementById('add_todo').style.display = 'flex';
  }
<<<<<<< HEAD
  //Shows the input field to add a rotation item
  open_timeline_tab(){
    document.getElementById('add_timeline').style.display = 'flex';
  }

  //Adds a to-do item to the list and sends it to the backend to save for future use
  save_todo_item(){
    this.toDoItems.push((<HTMLInputElement>document.getElementById('todoInput')).value);
    console.log(this.toDoItems)
  }
 
=======
   //Shows the input field to add a rotation item
  open_rotation_tab(){
    document.getElementById('add_timeline').style.display = 'flex';
  }

  //Gets the current to do items and the timeline details from the backend and prints on the page when it opens.
  get_todo_items() {

  }

  get_timeline_details() {

  }

  //Adds a to-do item to the list and sends it to the backend to save for future use
  save_todo_item(){
    document.getElementById('add_todo').style.display = 'None';

  }
  //Adds a timeline item to the list and sends it to the backend to save for future use
  save_timeline_item() {
    document.getElementById('add_timeline').style.display = 'None';
  }
  

  
>>>>>>> master

}


