select program_member.pm_fname, program_member.pm_lname, rotation_preference.Name_1, rotation_preference.Name_2, rotation_preference.Name_3, rotation_preference.Reasoning
from rotation_preference, submits, program_member
where rotation_preference.Name_1=submits.name_1 and submits.PM_SSO=program_member.PM_SSO  and program_member.PM_SSO="input"
group by program_member.PM_SSO;
/*returns the rotation preferences and reasoning for each program member*/

select assigned_to.Rotation_Number
from assigned_to, rotation
where assigned_to.rid=rotation.RID and rotation.Status="In Progress" and assigned_to.PM_SSO="input"
order by assigned_to.Rotation_Number desc
limit 1;
/*returns the current rotation number of the program member*/

select program_member.PM_FName, program_member.PM_LName, program_member.Hire_Date
from program_member, assigned_to
where assigned_to.PM_SSO=program_member.PM_SSO and assigned_to.Rotation_Number="1";
/*returns a list of all rotation 1 program members*/

select rotation.name, rotation.location, rotation.Department, rotation.description, rotation.Start_Date, rotation.End_Date, rotation.updates, al.AL_FName, al.AL_LName
from rotation, assigned_to, al
where rotation.RID=assigned_to.rid and al.AL_SSO=rotation.AL_SSO and assigned_to.Rotation_Number="1" and assigned_to.PM_SSO="input";
/*a specific program member's rotation 1*/

select program_member.PM_FName, program_member.PM_LName, program_member.Hire_Date
from program_member, assigned_to
where assigned_to.PM_SSO=program_member.PM_SSO and assigned_to.Rotation_Number="2";
/*returns a list of all rotation 2 program members*/

select rotation.name, rotation.location, rotation.Department, rotation.description, rotation.Start_Date, rotation.End_Date, rotation.updates, al.AL_FName, al.AL_LName
from rotation, assigned_to, al
where rotation.RID=assigned_to.rid and al.AL_SSO=rotation.AL_SSO and assigned_to.Rotation_Number="2" and assigned_to.PM_SSO="input";
/*a specific program member's rotation 2*/

select program_member.PM_FName, program_member.PM_LName, program_member.Hire_Date
from program_member, assigned_to
where assigned_to.PM_SSO=program_member.PM_SSO and assigned_to.Rotation_Number="3";
/*returns a list of all rotation 3 program members*/

select rotation.name, rotation.location, rotation.Department, rotation.description, rotation.Start_Date, rotation.End_Date, rotation.updates, al.AL_FName, al.AL_LName
from rotation, assigned_to, al
where rotation.RID=assigned_to.rid and al.AL_SSO=rotation.AL_SSO and assigned_to.Rotation_Number="3" and assigned_to.PM_SSO="input";
/*a specific program member's rotation 3*/

select program_member.PM_FName, program_member.PM_LName, program_member.Hire_Date
from program_member, assigned_to
where assigned_to.PM_SSO=program_member.PM_SSO and assigned_to.Rotation_Number="4";
/*returns a list of all rotation 4 program members*/

select rotation.name, rotation.location, rotation.Department, rotation.description, rotation.Start_Date, rotation.End_Date, rotation.Updates, al.AL_FName, al.AL_LName
from rotation, assigned_to, al
where rotation.RID=assigned_to.rid and al.AL_SSO=rotation.AL_SSO and assigned_to.Rotation_Number="4" and assigned_to.PM_SSO="input";
/*a specific program member's rotation 4*/ 

select rotation.Updates
from rotation, assigned_to
where rotation.RID=assigned_to.RID and assigned_to.PM_SSO="input"
order by assigned_to.Rotation_Number desc
limit 1;
/*returns any updates to a PMs current rotation*/

select PM_Feedback
from rotation;

select Email
from program_member
where PM_SSO="input";

select AL_Feedback
from rotation;

select track
from program_member
where PM_SSO="input";

select rotation.rid
from rotation, assigned_to
where assigned_to.RID=rotation.RID and rotation.Status="In Progress" and assigned_to.PM_SSO="input";
/*rotation ID for the PM's current rotation*/

select rotation.RID, rotation.name, rotation.Department, rotation.location, rotation.Description, al.AL_FName, al.AL_LName
from rotation, al
where rotation.AL_SSO=al.AL_SSO and rotation.Status="In Progress";
/*info about all current rotations*/

select rotation.name, rotation.Department, rotation.location, rotation.Description, al.AL_FName, al.AL_LName
from rotation, al, assigned_to
where rotation.AL_SSO=al.AL_SSO and assigned_to.rid=rotation.RID and rotation.Status="In Progress" and assigned_to.PM_SSO="input";
/*info about a PM's current rotation*/

select notes
from rotation_preference, submits
where rotation_preference.Name_1=submits.Name_1;
/*returns notes made on a PM's preferences*/
 
select al.AL_FName, al.AL_LName, al.Title, rotation_submission.Submission_Date, rotation_submission.Approval_Status
from rotation_submission, al
where rotation_submission.AL_SSO=al.AL_SSO;
/*list of rotation submissions from ALs*/

select rotation_submission.name, rotation_submission.Location, rotation_submission.Department, rotation_submission.Department, rotation_submission.Past_Experience, rotation_submission.Mentor_Name, rotation_submission.Coleader, rotation_submission.Travel_Amount, rotation_submission.Sub_Functional_Areas, rotation_submission.Description, rotation_submission.additional_learning, rotation_submission.functional_capabilities, rotation_submission.Outcomes, rotation_submission.Approval_Status
from rotation_submission, al
where rotation_submission.AL_SSO=al.AL_SSO and rotation_submission.AL_SSO="input";
/*individual rotation submission info*/

select pm_survey.Date, pm_survey.Rotation_Number, pm_survey.Current_Work, pm_survey.Department, pm_survey.Question_1, pm_survey.Question_2, pm_survey.Question_3, pm_survey.Current_Work, completes.PM_SSO
from pm_survey, completes
where pm_survey.Date=completes.date;
/*returns all survey results for program members*/

select al_survey.Date, al_survey.PM_Name, al_survey.Department, al_survey.Current_Work, al_survey.Question_1, al_survey.Question_2, al_survey.Question_3, al_survey.Current_Work, fulfills.AL_SSO
from al_survey, fulfills
where al_survey.Date=fulfills.date;
/*returns all survey results for ALs*/

select todo.Action_Name, todo.Action_Status
from todo, program_member
where program_member.Action_Name=todo.Action_Name and program_member.PM_SSO="input";
/*todo items for a specific program member*/

select todo.Action_Name, todo.Action_Status
from todo, al
where al.Action_Name=todo.Action_Name and al.AL_SSO="input";
/*todo items for a specific AL*/

select todo.Action_Name, todo.Action_Status
from todo, bpm
where bpm.Action_Name=todo.Action_Name and bpm.BPM_SSO="input";
/*todo items for a specific BPM*/ 

select Deadline_Date, Deadline_Name
from timeline;