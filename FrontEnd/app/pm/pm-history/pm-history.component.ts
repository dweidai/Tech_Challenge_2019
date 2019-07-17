import { Component, OnInit } from '@angular/core';
import { HTTPService } from '../../http.service';

@Component({
  selector: 'app-pm-history',
  templateUrl: './pm-history.component.html',
  styleUrls: ['./pm-history.component.css']
})
export class PmHistoryComponent implements OnInit {

  constructor(private HttpService: HTTPService) { }
  
  currentRotation: any;
  items: any = [];

  ngOnInit() {
    const observable = this.HttpService.populate_PM_history();
    observable.subscribe((response) =>
    {
      console.log(response);
       this.items = response["lead/history"];
       this.currentRotation = this.items[0];
       for (var i = this.items.length; i < 5; i++) {
        (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.color = "Gray";
       }
    });

  }

   //Opens the tab in the rotations box when clicked and hides the unneeded tabs
   openTab(index) {
     if (index < this.items.length) {

     
    for (var i = 0; i < this.items.length; i++) {
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.color = "Black";
      (<HTMLElement>document.getElementsByClassName("tabLink")[i]).style.borderBottom = "none";
    }
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.color = "#508BE4";
    (<HTMLElement>document.getElementsByClassName("tabLink")[index]).style.borderBottom = "3px solid #508BE4";
    
    this.currentRotation = this.items[index];
  }
     
  }

}
