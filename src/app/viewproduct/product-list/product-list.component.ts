import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductserviceService } from 'src/app/service/productservice.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit{

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

  addProduct():void{
    this.route.navigateByUrl('/productform');
  }

  updateProduct(id:number)
  {
    this.route.navigateByUrl("/updateProduct/"+id);
  }

  deleteProduct(id:number):void
  {
    console.log(id);
    if(confirm("Do you want to delete ?")){
      this.service.deleteProduct(id).subscribe(data=>{
        console.log(data);
        this.getAllProducts();
      })
    };
  }

}
