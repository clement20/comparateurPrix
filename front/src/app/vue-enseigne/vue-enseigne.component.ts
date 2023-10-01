import { Component, Input } from '@angular/core';
import { Enseigne } from '../modele/enseigne.model';

@Component({
  selector: 'app-vue-enseigne',
  templateUrl: './vue-enseigne.component.html',
  styleUrls: ['./vue-enseigne.component.scss']
})
export class VueEnseigneComponent {
  @Input() enseigne!: Enseigne;
}
