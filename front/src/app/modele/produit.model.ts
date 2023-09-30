import {  Prix } from "./enseigne.model";

export class Produit {
    constructor(public nom: string,
        public prixMoyen: number,
        public prixMoinsCher: number,
        public nomEnseigneMoinsChere: string,
        public photoEnseigneMoinsChere: string,
        public prixPlusChers: Array<Prix>,
        public typePrix: string,
        public dateMajReleve: Date,
        public photo: string) {}
    
}