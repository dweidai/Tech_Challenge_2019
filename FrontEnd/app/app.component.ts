import { Component, NgZone } from '@angular/core';
import { ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HTTPService } from '../app/http.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
 
})
export class AppComponent {
  title = 'front-end';
  
  constructor() {}

}
