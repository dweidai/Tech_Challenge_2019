import { NgModule } from '@angular/core';
import { Routes, RouterModule, RouteConfigLoadEnd } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { PMHomeComponent } from './pm/pm-home/pm-home.component';
import { ALHomeComponent } from './al/al-home/al-home.component';
import { PmRankingComponent } from './pm/pm-ranking/pm-ranking.component';
import { PmCommsComponent } from './pm/pm-comms/pm-comms.component';
import { PmDirectoryComponent } from './pm/pm-directory/pm-directory.component';
import { PmHistoryComponent } from './pm/pm-history/pm-history.component';
import { PmForumComponent } from './pm/pm-forum/pm-forum.component';
import { BPMHomeComponent } from './bpm/bpm-home/bpm-home.component';
import { BpmAssignmentComponent } from './bpm/bpm-assignment/bpm-assignment.component';
import { BpmApprovalComponent } from './bpm/bpm-approval/bpm-approval.component';
import { BpmCommsComponent } from './bpm/bpm-comms/bpm-comms.component';
import { BpmDirectoryComponent } from './bpm/bpm-directory/bpm-directory.component';
import { AlCommsComponent } from './al/al-comms/al-comms.component';
import { AlSubmitComponent } from './al/al-submit/al-submit.component';
import { AlDirectoryComponent } from './al/al-directory/al-directory.component';


const routes: Routes = [
  { path: '', 
    component: LoginPageComponent
  },
  //Routing to different BPM pages
  { path: 'BPM-home',
    component: BPMHomeComponent,
  },
  { path: 'BPM-assignment',
    component: BpmAssignmentComponent
  },
  { path: 'BPM-approval',
    component: BpmApprovalComponent
  },
  { path: 'BPM-comms',
    component: BpmCommsComponent
  }, 
  { path: 'BPM-directory',
    component: BpmDirectoryComponent
  },
  //Routing to different AL pages
  { path: 'AL-home',
    component: ALHomeComponent,
  },
  { path: 'AL-submit',
    component: AlSubmitComponent
  },
  { path: 'AL-comms',
    component: AlCommsComponent
  },
  {
    path: 'AL-directory',
    component: AlDirectoryComponent
  },
  //Routing to different PM pages
  {
    path: 'PM-home',
    component: PMHomeComponent,
  },
  {
    path: 'PM-ranking',
    component: PmRankingComponent,
  },
  {
    path: 'PM-comms',
    component: PmCommsComponent,
  },
  {
    path: 'PM-directory',
    component: PmDirectoryComponent,
  },
  {
    path: 'PM-history',
    component: PmHistoryComponent
  },
  { path: 'PM-forum',
    component: PmForumComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
