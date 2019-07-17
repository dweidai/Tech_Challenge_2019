import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PmRankingService {
  private rotations = [
    {
      role: 'UX Producer',
      location: 'Chicago',
      al: 'Richard Baker',
      department: 'UX',
      pastLead: 'Bailey Kaplan, Allison Heithoff, David Dai',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare. Aliquam sollicitudin est non ipsum volutpat venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum vitae odio congue sapien blandit tempus ac sit amet neque. Nunc at consectetur diam.',
      opportunities: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.'
    },
    {
      role: 'Programmer',
      location: 'Erie',
      al: 'Andrew McVeagh',
      department: 'Shared Services',
      pastLead: 'Bailey Kaplan, Allison Heithoff, David Dai',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare. Aliquam sollicitudin est non ipsum volutpat venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum vitae odio congue sapien blandit tempus ac sit amet neque. Nunc at consectetur diam.',
      opportunities: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.'
    },
    {
      role: 'Programmer',
      location: 'Chicago',
      al: 'Sophia Burbano',
      department: 'Finance IT',
      pastLead: 'Bailey Kaplan, Allison Heithoff, David Dai',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare. Aliquam sollicitudin est non ipsum volutpat venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum vitae odio congue sapien blandit tempus ac sit amet neque. Nunc at consectetur diam.',
      opportunities: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.'
    },
    {
      role: 'UI Programmer',
      location: 'Erie',
      al: 'Kathy Reed',
      department: 'E Services',
      pastLead: 'Bailey Kaplan, Allison Heithoff, David Dai',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare. Aliquam sollicitudin est non ipsum volutpat venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum vitae odio congue sapien blandit tempus ac sit amet neque. Nunc at consectetur diam.',
      opportunities: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.'
    },
    {
      role: 'Project',
      location: 'Erie',
      al: 'Tom Chill',
      department: 'Supply Chain',
      pastLead: 'Bailey Kaplan, Allison Heithoff, David Dai',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare. Aliquam sollicitudin est non ipsum volutpat venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum vitae odio congue sapien blandit tempus ac sit amet neque. Nunc at consectetur diam.',
      opportunities: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.'
    },
    {
      role: 'Manager',
      location: 'Erie',
      al: 'Jeff Zavada',
      department: 'Supply Chain',
      pastLead: 'Bailey Kaplan, Allison Heithoff, David Dai',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare. Aliquam sollicitudin est non ipsum volutpat venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum vitae odio congue sapien blandit tempus ac sit amet neque. Nunc at consectetur diam.',
      opportunities: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.'
    },
    {
      role: 'Programmer',
      location: 'Erie',
      al: 'Carrie Zavada',
      department: 'Business',
      pastLead: 'Bailey Kaplan, Allison Heithoff, David Dai',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare. Aliquam sollicitudin est non ipsum volutpat venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum vitae odio congue sapien blandit tempus ac sit amet neque. Nunc at consectetur diam.',
      opportunities: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.'
    },
    {
      role: 'Analyst',
      location: 'Chicago',
      al: 'Richard Baker',
      department: 'Intelligence',
      pastLead: 'Bailey Kaplan, Allison Heithoff, David Dai',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare. Aliquam sollicitudin est non ipsum volutpat venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum vitae odio congue sapien blandit tempus ac sit amet neque. Nunc at consectetur diam.',
      opportunities: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel ligula nec turpis sagittis malesuada a in libero. Ut sagittis velit ac enim finibus egestas. Ut urna odio, varius vitae velit id, dignissim hendrerit lacus. In semper pellentesque mauris, laoreet dignissim orci sollicitudin quis. Vestibulum vulputate fermentum nisi. Donec placerat purus ac viverra rutrum. Proin scelerisque, nibh ac dapibus ornare, ligula turpis tristique enim, eget interdum orci nulla ac mi. Nulla egestas varius ipsum at lacinia. Sed id nulla eu enim blandit imperdiet id sit amet magna. Donec consequat turpis eros, fringilla laoreet libero gravida sed. Nulla laoreet erat ut posuere ornare.'
    }
  ];

  constructor() { }

  getRotations() {
    return this.rotations.slice();
  }

  getRotationDetails(index) {
    return this.rotations[index];
  }
}
