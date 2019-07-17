import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatCheckboxModule } from '@angular/material';
import { AppRoutingModule } from './app-routing.module';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

// Components
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';

// Services
import { PmRankingService } from './pm-ranking.service';

// Program Member pages
import { PMHomeComponent } from './pm/pm-home/pm-home.component';
import { PmRankingComponent } from './pm/pm-ranking/pm-ranking.component';
import { PmCommsComponent } from './pm/pm-comms/pm-comms.component';
import { PmDirectoryComponent } from './pm/pm-directory/pm-directory.component';
import { PmHistoryComponent } from './pm/pm-history/pm-history.component';
import { PmForumComponent } from './pm/pm-forum/pm-forum.component';
import { PmHeaderComponent } from './pm/pm-header/pm-header.component';
import { PmModalComponent } from './pm/pm-ranking/pm-modal/pm-modal.component';
import { RotationCardComponent } from './pm/pm-ranking/rotation-card/rotation-card.component';

// BPM pages
import { BPMHomeComponent } from './bpm/bpm-home/bpm-home.component';
import { BpmAssignmentComponent } from './bpm/bpm-assignment/bpm-assignment.component';
import { BpmApprovalComponent } from './bpm/bpm-approval/bpm-approval.component';
import { BpmApprovalCardComponent } from './bpm/bpm-approval/bpm-approval-card/bpm-approval-card.component';
import { BpmCommsComponent } from './bpm/bpm-comms/bpm-comms.component';
import { BpmDirectoryComponent } from './bpm/bpm-directory/bpm-directory.component';
import { BpmAlSurveyComponent } from './bpm/bpm-comms/bpm-al-survey/bpm-al-survey.component';
import { BpmLeadSurveyComponent } from './bpm/bpm-comms/bpm-lead-survey/bpm-lead-survey.component';
import { BpmAlMetricsComponent } from './bpm/bpm-comms/bpm-al-metrics/bpm-al-metrics.component';
import { BpmLeadMetricsComponent } from './bpm/bpm-comms/bpm-lead-metrics/bpm-lead-metrics.component';

// AL Pages
import { ALHomeComponent } from './al/al-home/al-home.component';
import { AlCommsComponent } from './al/al-comms/al-comms.component';
import { AlSubmitComponent } from './al/al-submit/al-submit.component';
import { AlDirectoryComponent } from './al/al-directory/al-directory.component';
import { AlHeaderComponent } from './al/al-header/al-header.component';
import { BpmHeaderComponent } from './bpm/bpm-header/bpm-header.component';
import { AlSubmit2Component } from './al/al-submit2/al-submit2.component';

@NgModule({
  declarations: [
    BpmAlMetricsComponent,
    BpmAlSurveyComponent,
    BpmLeadMetricsComponent,
    BpmLeadSurveyComponent,
    AppComponent,
    BPMHomeComponent,
    LoginPageComponent,
    ALHomeComponent,
    PMHomeComponent,
    PmRankingComponent,
    BpmApprovalCardComponent,
    PmModalComponent,
    RotationCardComponent,
    PmCommsComponent,
    PmDirectoryComponent,
    PmHistoryComponent,
    PmForumComponent,
    BpmAssignmentComponent,
    BpmApprovalComponent,
    BpmCommsComponent,
    BpmDirectoryComponent,
    AlCommsComponent,
    PmRankingComponent,
    AlSubmitComponent,
    AlDirectoryComponent,
    PmHeaderComponent,
    AlHeaderComponent,
    BpmHeaderComponent,
    AlSubmit2Component
  ],
  imports: [
    NgbModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    DragDropModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [PmModalComponent]
})
export class AppModule { }
