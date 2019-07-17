import { Component, OnInit, Input } from '@angular/core';
import { PmRankingService } from 'src/app/pm-ranking.service';

@Component({
  selector: 'app-rotation-card',
  templateUrl: './rotation-card.component.html',
  styleUrls: ['./rotation-card.component.css']
})
export class RotationCardComponent implements OnInit {

  @Input() rotation: object;
  pmService: PmRankingService;

  constructor(pmService: PmRankingService) {
    this.pmService = pmService;
  }

  ngOnInit() {
  }

}
