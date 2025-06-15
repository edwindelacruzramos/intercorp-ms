import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { PersonListComponent } from './components/person-list/person-list.component';
import { PersonRecordPageComponent } from './pages/person-record-page.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    PersonListComponent,
    PersonRecordPageComponent
  ],
  exports: [
    PersonRecordPageComponent
  ]
})
export class PersonRecordModule { }
