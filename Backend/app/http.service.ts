import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class HTTPService {
<<<<<<< HEAD
  
  //This json is what is send to the back end with all the user details
  userJSON: any = {}

=======
  //Backend servers that front end will be communicating with
  private url = 'http://localhost:8080';
  private bpmHomeUrl = 'http://localhost:8080/BPM-home';
  sso:string =  "-1";//Change to number??
>>>>>>> master

  //This json is what is send to the back end with all the user details
  //The values are null to begin with. They will change as needed
  UserJSON: any = 
    { type: null,
      sso: this.sso, 
      password: null,
      name: null
    };

<<<<<<< HEAD
  //Sends the SSO and password from the login page to the backend
  //Those values are embedded in the UserJSON.
  sendSSO(userJSON) {
    //ADD LOGINNNNNN
    const observable = this.http.post('http://localhost:8080/login', userJSON,{responseType: 'json'});
 //const observable = this.http.post('http://10.232.169.96:8080/login', userJSON,{responseType: 'json'});
 
   this.userJSON = userJSON;
    return observable;
  }

  //  ---------- BPM HTTP Requests ----------  //

  //Populate all the information in the BPM home page
  populate_BPM_home() {
    const observable = this.http.get('http://localhost:8080/bpm/home'); 
    return observable;
  }

  //Populates all the information in BPM role assignment page
  populate_BPM_assignment() {
    const observable = this.http.get('http://localhost:8080/bpm/rotation_assignment'); 
    return observable;
  }  

  //Populates all the information in BPM communications page
  populate_BPM_communications() {
    const observable = this.http.get('http://localhost:8080/bpm/communications'); 
    return observable;
  }  

  //Populates all the information in BPM rotation approval page
  populate_BPM_approval() {
    const observable = this.http.get('http://localhost:8080/bpm/rotation_approval'); 
    return observable;
  } 
  
  // ----- AL HTTP requests ----- //
  //Populates all the information in AL home page
  populate_AL_home() {
    const observable = this.http.get('http://localhost:8080/al/home'); 
    return observable;
  } 

  //Populates all the information in AL communications page
  populate_AL_communications() {
    const observable = this.http.get('http://localhost:8080/al/communication'); 
    return observable;
  } 


  // ----- PM HTTP requests ----- //

  //Populates all the information in PM home page
  populate_PM_home() {
    const observable = this.http.get('http://localhost:8080/lead/home'); 
    return observable;
  } 

  //Populates all the information in PM rotation submission page
  populate_PM_rotations() {
    const observable = this.http.get('http://localhost:8080/lead/assignment'); 
    return observable;
  } 

  //Populates all the information in PM communications page
  populate_PM_communications() {
    const observable = this.http.get('http://localhost:8080/lead/communications'); 
    return observable;
  } 

  //Populates all the information in PM History page
  populate_PM_history() {
    const observable = this.http.get('http://localhost:8080/lead/history'); 
    return observable;
  } 


  
=======

  constructor(private http: HttpClient) { }

  //Sends the SSO and password from the login page to the backend
  //Those values are embedded in the UserJSON.
  //Doesn't need a response from the backend
  sendSSO(SSO) {
    this.sso = SSO;
    const observable = this.http.post(this.url, this.sso, {responseType:'text'});
    return observable;
  }

  get_PM_by_rotation(rotationNum) {
    const observable = this.http.post(this.bpmHomeUrl, this.UserJSON); //send user details to backend and recieve it.
    return observable;
  }

>>>>>>> master


}
