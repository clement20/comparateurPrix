import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import { ListeProduitsComponent } from './liste-produits/liste-produits.component';
import { ListeEnseignesComponent } from './liste-enseignes/liste-enseignes.component';

const routes: Routes = [
{path: 'listeProduits', component: ListeProduitsComponent},
{path: 'listeEnseignes', component: ListeEnseignesComponent}
];
@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule{}