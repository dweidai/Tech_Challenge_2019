import { Component, NgZone } from '@angular/core';
import { ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HTTPService } from '../http.service';
import { Observable } from 'rxjs';
import { Router, UrlSegmentGroup, UrlSegment, Route } from '@angular/router';
import { appInjector } from '../../main';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})

//To do:
//Make password and sso field required
export class LoginPageComponent {
  sso: string;  //Number or string depending on how database needs to store it
  userJSON: any = {}
  constructor(private zone: NgZone, private router: Router, private HttpService: HTTPService) {}


  //Function to send SSO to the back end.
  sendSSO() {
    this.sso = (<HTMLInputElement>document.getElementById("sso")).value; 
    //Adds the values we need into a json object
    this.userJSON["sso"] = this.sso;
    this.userJSON["password"] = (<HTMLInputElement>document.getElementById("password")).value;
    //Calls the sendSSO function in Http.Service.ts file
    const observable = this.HttpService.sendSSO(this.userJSON);
    //Prints the output of the backend 
    observable.subscribe((response) =>
    {
      var type = response['type'];
      if (type == "bpm") {  
        this.zone.run(() => { this.router.navigateByUrl("/BPM-home"); });
      } else if (type == "al") {
        this.zone.run(() => { this.router.navigateByUrl("/AL-home"); });
      } else {
        this.zone.run(() => { this.router.navigateByUrl("/PM-home"); });
      }
    })
  
    
  }

}