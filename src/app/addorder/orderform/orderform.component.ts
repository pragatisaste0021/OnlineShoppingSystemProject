import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Orderdetail } from 'src/app/common/orderdetail';
import { OrderserviceService } from 'src/app/service/orderservice.service';

@Component({
  selector: 'app-orderform',
  templateUrl: './orderform.component.html',
  styleUrls: ['./orderform.component.css']
})
export class OrderformComponent implements OnInit{

  order : Orderdetail = new Orderdetail(0, "", new Date(), new Date(), "", 0, 0);
  isEditable: boolean;
  constructor(private orderservice : OrderserviceService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.order);
    this.activateRoute.paramMap.subscribe(()=>this.getOrderById());
  }

  onSubmit(){
    console.log(this.order);
    if(this.isEditable){
      this.orderservice.updateOrder(this.order).subscribe(data=>
        this.router.navigateByUrl("/orderlist"));

    }
    else{
    this.orderservice.saveOrder( this.order).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/orderlist");
  }
}
getOrderById(){
  const orderID  = parseFloat(this.activateRoute.snapshot.paramMap.get("id"));
  
console.log(orderID);
if(orderID> 0)
{
  this.isEditable = true;
  this.orderservice.getOrderByID(orderID).subscribe(data=>{
    this.order = data;
    console.log(this.order)
  });
}

}
}
