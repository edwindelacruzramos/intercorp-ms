import { Component, Input } from '@angular/core';
import { PersonRecord } from '../../../../core/models/person-record.model';
import { NgFor, NgIf, DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-person-list',
  standalone: true,
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.scss'],
  imports: [NgFor, NgIf, FormsModule, DatePipe]
})
export class PersonListComponent {
  @Input() records: PersonRecord[] = [];
  @Input() lastUpdate: string = '';
  searchTerm: string = '';
  currentPage = 1;
  pageSize = 20;
  darkMode = false;

  toggleDarkMode() {
    this.darkMode = !this.darkMode;
  }

  get filteredRecords(): PersonRecord[] {
    const term = this.searchTerm.toLowerCase();
    return this.records.filter(r =>
      Object.values(r).some(val =>
        val?.toString().toLowerCase().includes(term)
      )
    );
  }

  get pages(): number[] {
    return Array(this.totalPages).fill(0).map((_, i) => i + 1);
  }

  get totalPages(): number {
    return Math.ceil(this.filteredRecords.length / this.pageSize);
  }

  trackPage(index: number): number {
    return Math.abs(this.currentPage - (index + 1));
  }

  get paginatedRecords(): PersonRecord[] {
    const start = (this.currentPage - 1) * this.pageSize;
    return this.filteredRecords.slice(start, start + this.pageSize);
  }

  exportToExcel() {
    const worksheet = XLSX.utils.json_to_sheet(this.filteredRecords);
    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, 'Personas');
    XLSX.writeFile(workbook, 'personas.xlsx');
  }
}
