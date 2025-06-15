import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from '../../../core/services/api.service';
import { PersonRecord } from '../../../core/models/person-record.model';

@Injectable({ providedIn: 'root' })
export class PersonRecordService {
  constructor(private api: ApiService) { }

  getRecords(): Observable<{ data: PersonRecord[]; lastUpdate: string }> {
    return this.api.get<{ data: PersonRecord[]; lastUpdate: string }>('persons');
  }
}