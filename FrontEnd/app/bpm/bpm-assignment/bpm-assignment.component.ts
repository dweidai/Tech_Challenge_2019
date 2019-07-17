import { Component, OnInit } from '@angular/core';
import { HTTPService } from '../../http.service';

@Component({
  selector: 'app-bpm-assignment',
  templateUrl: './bpm-assignment.component.html',
  styleUrls: ['./bpm-assignment.component.css']
})
export class BpmAssignmentComponent implements OnInit {

  //Declare all variables used in this class

  // -------- HARD CODED DATA --------
  positions: any = [ {
                        "name":"Supply Chain",
                        "program_members": [ {
                          "name": "Laura Cooper",
                          "organization": "Digital Solution",
                          "rank": "1",
                          "rolename": "Supply Chain",
                          "description":"A highly motivated and hardworking individual, who has recently completed their A-Levels, achieving excellent grades in both Maths and Science. Seeking an apprenticeship in the engineering industry to build upon a keen scientific interest and start a career as a maintenance engineer. Eventual career goal is to become a fully-qualified and experienced maintenance or electrical engineer, with the longer-term aspiration of moving into project management."
                        }, 
                        {
                          "description": "Driven Retail Manager with over ten years’ experience in the fashion industry. Proven track record of success, including managing the top performing store in the region, and having the lowest staff turnover rate of all UK outlets. Currently out of work due to company closure, looking for the right opportunity to bring my expertise to a well-established fashion brand in an upper management position.",
                          "experience": "No",
                          "name": "Dan Green",
                          "organization": "Supply Chain",
                          "rank": "2",
                          "rolename": "Electrical Engineer"
                        }]
                      },
                      {
                        "name":"Finance IT",
                        "program_members": [ {
                          "description": "One of the biggest things I struggle with when I put out content is my high energy, extroverted personality - it makes people think that they have to be like me in order to build a brand or put themselves out thereTruth is, introverted entrepreneurs have incredible advantages too!! Lean into what you're good at.",
                          "experience": "No",
                          "name": "William Young",
                          "organization": "Finance IT",
                          "rank": "1",
                          "rolename": "Risk Management"
                        }, 
                        {
                          "description": "Enthusiastic school leaver with five GCSEs looking for an apprenticeship in the engineering field. Possessing good written and verbal communication and an interest in engineering which has spanned my lifetime with a particular passion for electrics. For my GCSE Design & Technology project, I built a working calculator and was awarded an A*. Looking for a start in the exciting world of electrical engineering where I can learn a trade and realise a lifetime ambition.",
                          "experience": "No",
                          "name": "Richard King",
                          "organization": "Research",
                          "rank": "2",
                          "rolename": "Operation Researcher"
                        }]
                      },
                      {
                        "name":"User Experience",
                        "program_members": [ {
                          "name": "Laura Cooper",
                          "organization": "Digital Solutions",
                          "rank": "3",
                          "rolename": "Supply Chain",
                          "description":"An individual recently completed their A-Levels, achieving excellent grades in both Maths and Science. Seeking an apprenticeship in the engineering industry to build upon a keen scientific interest and start a career as a maintenance engineer. Eventual career goal is to become a fully-qualified and experienced maintenance or electrical engineer, with the longer-term aspiration of moving into project management."
                        }, 
                        {
                          "description": "Proven track record of success, including managing the top performing store in the region, and having the lowest staff turnover rate of all UK outlets. Currently out of work due to company closure, looking for the right opportunity to bring my expertise to a well-established fashion brand in an upper management position.",
                          "experience": "No",
                          "name": "John Smith",
                          "organization": "Supply Chain",
                          "rank": "2",
                          "rolename": "Finance IT"
                        }]
                      }
                    
                    ];
  chosen_pm: any;//Example: [{ "name": "position name", "program-member": "person name"}]

  pms_1: any = [];
  pms_2: any = [];
  pms_3: any = [];
  pms_4: any = [];
  selected_pm: any = {};
  current_pms: any = [];
  toDoItems: any = [];
  timeline: any = [];
  userJSON: any = {};


  constructor(private HttpService: HTTPService) { }  

  ngOnInit() { 
    
    //Populates page with details when the page opens.
    const observable = this.HttpService.populate_BPM_assignment();
    observable.subscribe((response) =>
    {
      //Filter the data recieved from the backend into variables to be used later
      
    });

    //Opens the 1st rotation tab when the application starts
    (<HTMLElement>document.getElementsByClassName("tabLink")[0]).click();
  }

  //Saves the program member that was assigned that role
  save_role_member() {
    //Iterates through all possible positions and saves the right program member assigned to it
    for (var i = 0; i < this.positions.length; i++) {
      var program_members = this.positions[i]['program_members'];
      for (var j = 0; j < program_members.length; j++){
        let person = program_members[j];
        let element = (<HTMLInputElement>document.getElementById(person.name));
        if (element.checked) {
          this.chosen_pm.push( {
            "position_name": this.positions[i].name,
            "program-member":person.name
          });
      }
    }
  }
    console.log(this.chosen_pm);
  }


  //Opens the tab in the rotations box when clicked and hides the unneeded tabs
   openTab(index) {
    var tabPages = ['first', 'second', 'third', 'fourth'];
   
    if (index == 0) {
      this.current_pms = this.pms_1;
    } else if (index == 1) {
      this.current_pms = this.pms_2;
    } else if (index == 2) {
      this.current_pms = this.pms_3;
    } else {
      this.current_pms = this.pms_4;
    }

    for (var i = 0; i < 4; i++) {
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.color = "Black";
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.borderBottom = "none";
    }
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.color = "#508BE4";
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.borderBottom = "3px solid #508BE4";
    
     
  } 
  //Highlight the selected user
  select_user(person,all_pm) {
    console.log(person.name, all_pm[0].name);
    for (var i = 0; i < all_pm.length; i++) {
      (<HTMLElement>document.getElementById(all_pm[i].name)).style.backgroundColor= "white";
      (<HTMLElement>document.getElementById(all_pm[i].name)).style.borderLeft= "none";

    }
    (<HTMLElement>document.getElementById(person.name)).style.backgroundColor = '#E7ECF4';
    (<HTMLElement>document.getElementById(person.name)).style.borderLeft = "5px solid #508BE4";

    this.selected_pm = person;
    this.show_assignment_details();
    this.show_past_rotations(person);
  }

  show_assignment_details() {
    
  } 

  show_past_rotations(person) {
    (<HTMLInputElement>document.getElementById("expanded_details")).value = "Get role Description";
  }

  
}
