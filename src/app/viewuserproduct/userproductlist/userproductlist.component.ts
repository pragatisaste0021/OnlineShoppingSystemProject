import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductserviceService } from 'src/app/service/productservice.service';

@Component({
  selector: 'app-userproductlist',
  templateUrl: './userproductlist.component.html',
  styleUrls: ['./userproductlist.component.css']
})
export class UserproductlistComponent {

  product : Product[]
  constructor(public route : Router, private service : ProductserviceService, activateRoute : ActivatedRoute){
    
  }
  ngOnInit() : void{
    this.getAllProducts();
  }

  getAllProducts(){
    this.service.getAllProduct().subscribe(data =>{
      console.log(data);
      this.product = data;
    });
  }

  buyProduct(){
    this.route.navigateByUrl('/payment');
  }
}
