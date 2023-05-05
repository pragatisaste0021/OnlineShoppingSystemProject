import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductserviceService } from 'src/app/service/productservice.service';

@Component({
  selector: 'app-productform',
  templateUrl: './productform.component.html',
  styleUrls: ['./productform.component.css']
})
export class ProductformComponent {

  product : Product = new Product(0, "", "", 0, 0, "", "", "", "");
  isEditable: boolean;
  constructor(private productservice : ProductserviceService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.product);
    this.activateRoute.paramMap.subscribe(()=>this.getProductById());
  }

  onSubmit(){
    console.log(this.product);
    if(this.isEditable){
      this.productservice.updateUser(this.product).subscribe(data=>
        this.router.navigateByUrl("/productlist"));

    }
    else{
    this.productservice.saveProduct( this.product).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/productlist");
  }
}
getProductById(){
  const productID  = parseFloat(this.activateRoute.snapshot.paramMap.get("id"));
  
console.log(productID);
if(productID> 0)
{
  this.isEditable = true;
  this.productservice.getProductByID(productID).subscribe(data=>{
    this.product = data;
    console.log(this.product)
  });
}

}
}
