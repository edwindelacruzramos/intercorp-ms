import { Component, OnInit } from '@angular/core';
import { PersonRecordService } from '../services/person-record.service';
import { PersonRecord } from '../../../core/models/person-record.model';
import { PersonListComponent } from '../components/person-list/person-list.component';

@Component({
  selector: 'app-person-record-page',
  standalone: true,
  imports: [PersonListComponent],
  template: '<app-person-list [records]="records" [lastUpdate]="lastUpdate"></app-person-list>',
})
export class PersonRecordPageComponent implements OnInit {
  records: PersonRecord[] = [];
  lastUpdate: string = '';

  constructor(private personService: PersonRecordService) {}

  ngOnInit(): void {
    this.personService.getRecords().subscribe(res => {
      this.records = res.data;
      this.lastUpdate = res.lastUpdate;
    });
  }
}
