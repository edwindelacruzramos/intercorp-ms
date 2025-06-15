import { Routes } from '@angular/router';

export const routes: Routes = [
    {
    path: '',
    redirectTo: 'records',
    pathMatch: 'full'
  },
  {
    path: 'records',
    loadComponent: () => import('./modules/person-record/pages/person-record-page.component').then(m => m.PersonRecordPageComponent)
  }

];
