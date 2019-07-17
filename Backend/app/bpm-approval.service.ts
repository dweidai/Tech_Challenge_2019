import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BpmApprovalService {
  private submissions = [
    {
      assignmentName: 'UX Producer',
      organization: 'Digital Solutions',
      mentor: 'n/a',
      travel: 'Medium',
      location: 'Chicago',
      subFunctional: 'Design & User Experience',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.',
      date: '06/18/19',
      name: 'David Dai',
      step: 'UX Producer'
    },
    {
      assignmentName: 'Programmer',
      organization: 'Shared Services',
      mentor: 'n/a',
      travel: 'Medium',
      location: 'Erie',
      subFunctional: 'Design & User Experience',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.',
      date: '06/18/19',
      name: 'Bailey Kaplan',
      step: 'Programmer'
    },
    {
      assignmentName: 'UX Producer',
      organization: 'E Services',
      mentor: 'n/a',
      travel: 'Low',
      location: 'Erie',
      subFunctional: 'Design & User Experience',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.',
      date: '06/18/19',
      name: 'Felipe Vieira',
      step: 'UX Producer'
    },
    {
      assignmentName: 'UI Programmer',
      organization: 'Business',
      mentor: 'n/a',
      travel: 'Medium',
      location: 'Chicago',
      subFunctional: 'Design & User Experience',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.',
      date: '06/18/19',
      name: 'Christine Lee',
      step: 'Feedback'
    },
    {
      assignmentName: 'UX Producer',
      organization: 'Intelligence',
      mentor: 'n/a',
      travel: 'Medium',
      location: 'Chicago',
      subFunctional: 'Design & User Experience',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.',
      date: '06/18/19',
      name: 'Felipe Vieira',
      step: 'Feedback'
    },
  ];

  constructor() { }

  getSubmissions() {
    return this.submissions.slice();
  }

  getSubmissionsDetails(index) {
    return this.submissions[index];
  }
}
