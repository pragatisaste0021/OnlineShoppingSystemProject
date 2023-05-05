export class Orderdetail {

    constructor(
       public order_Id : number,
       public  order_comment : string,
       public  deliver_date : Date,
       public  order_date : Date,
       public  order_status : string,
       public  track_Id : number,
       public  user_Id : number
    ){

    }
}
