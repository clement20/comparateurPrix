export class Produit {
    constructor(public nom: string,
        public prixMoyen: number,
        public prixMoinsCher: number,
        public nomEnseigneMoinsChere: string,
        public typePrix: string,
        public dateMajReleve: Date,
        public photo: string) {}
    
}