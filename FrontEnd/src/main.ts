import { enableProdMode,Injector } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import 'hammerjs';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';
export let appInjector: Injector;

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));


platformBrowserDynamic().bootstrapModule(AppModule).then(
(componentRef) => {
  appInjector = componentRef.injector;
})
