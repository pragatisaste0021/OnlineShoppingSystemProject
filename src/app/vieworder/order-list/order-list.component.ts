import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Orderdetail } from 'src/app/common/orderdetail';
import { OrderserviceService } from 'src/app/service/orderservice.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit{

  order : Orderdetail[]
  constructor(public route : Router, private service : OrderserviceService, activateRoute : ActivatedRoute){
    
  }
  ngOnInit() : void{
    this.getAllOrders();
  }

  getAllOrders(){
    this.service.getAllOrder().subscribe(data =>{
      console.log(data);
      this.order = data;
    });
  }

  addOrder():void{
    this.route.navigateByUrl('/orderform');
  }

  updateOrder(id:number)
  {
    this.route.navigateByUrl("/updateOrder/"+id);
  }

  deleteOrder(id:number):void
  {
    console.log(id);
    if(confirm("Do you want to delete ?")){
      this.service.deleteOrder(id).subscribe(data=>{
        console.log(data);
        this.getAllOrders();
      })
    };
  }
}
