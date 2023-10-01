import { Component, Input, OnInit } from '@angular/core';
import { Enseigne } from '../modele/enseigne.model';

@Component({
  selector: 'app-vue-enseigne',
  templateUrl: './vue-enseigne.component.html',
  styleUrls: ['./vue-enseigne.component.scss'],

})
export class VueEnseigneComponent implements OnInit {
  Math: any = Math
  ngOnInit(): void {

  }
  @Input() enseigne!: Enseigne;

}
