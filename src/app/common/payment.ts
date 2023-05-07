export class Payment {

    constructor(
        public payment_Id : number,
        public payment_mode : string,
        public payment_date : Date,
        public cvv : number,
        public pincode : number
    )
    {
        
    }
}
