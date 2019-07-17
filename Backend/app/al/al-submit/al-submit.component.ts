import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-al-submit',
  templateUrl: './al-submit.component.html',
  styleUrls: ['./al-submit.component.css']
})
export class AlSubmitComponent implements OnInit {
  checkboxes: any = ["Architecture","Cyber Security", "Data & Analytics", "Design & User Experience", "Digital Engineering", "Digital Operations", "Program Management", "Rist & Compliance", "Technical Product Management"];
  constructor() { }

  ngOnInit() {
  }

  nextPage() {
    document.getElementById('nextPage').style.display = 'block';
    (<HTMLElement>document.getElementsByClassName('content')[0]).style.display = 'none';
  }

}
