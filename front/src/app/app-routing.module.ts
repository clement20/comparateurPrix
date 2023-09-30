import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import { ListeProduitsComponent } from './liste-produits/liste-produits.component';

const routes: Routes = [
{path: 'listeProduits', component: ListeProduitsComponent}
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