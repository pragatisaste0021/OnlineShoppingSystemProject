import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { UserProduct } from 'src/app/common/user-product';
import { ProductserviceService } from 'src/app/service/productservice.service';
import { UserproductserviceService } from 'src/app/service/userproductservice.service';

@Component({
  selector: 'app-userproductform',
  templateUrl: './userproductform.component.html',
  styleUrls: ['./userproductform.component.css']
})
export class UserproductformComponent {
  userproduct : UserProduct = new UserProduct(0,"", "", 0, 0);
  isActive: boolean;
  product : Product = new Product(0, "", "", 0, 0, "", "", "", "");
  pdt_Id : number;
  constructor(private productservice : ProductserviceService,private service : UserproductserviceService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.userproduct);
    
    
  }

  onSubmit(){
    console.log(this.userproduct);
    this.service.saveUserProduct( this.userproduct).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/payment");
    
    
  }

  getProductById(){
    const productID  = parseFloat(this.activateRoute.snapshot.paramMap.get("id"));
    console.log(productID);
    if(this.userproduct.pdt_Id == this.product.pdt_Id){
      this.isActive = true;
    this.productservice.getProductByID(productID).subscribe(data=>{
      this.product = data;
      console.log(this.product)
      
    });
  }
}
  
}
