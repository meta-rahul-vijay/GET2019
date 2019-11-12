export class Todo{

    constructor(public id:number,
        public title:string,
        public description:string,
        public status:string,
        public creationDate:Date,
        public completionDate:Date,
        public priority:string){
    }
}