import { Component, OnInit } from '@angular/core';
import { Enseigne } from '../modele/enseigne.model';
import { Observable } from 'rxjs/internal/Observable';
import { EnseigneService } from '../services/enseigne.service';

@Component({
  selector: 'app-liste-enseignes',
  templateUrl: './liste-enseignes.component.html',
  styleUrls: ['./liste-enseignes.component.scss']
})
export class ListeEnseignesComponent implements OnInit {
  constructor(private enseigneService: EnseigneService) { }
  enseignes$!: Observable<Enseigne[]>;
  ngOnInit(): void {

    this.enseignes$=this.enseigneService.getAllEnseignes();
  }
}
 