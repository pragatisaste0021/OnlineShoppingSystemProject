import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Payment } from 'src/app/common/payment';
import { PaymentserviceService } from 'src/app/service/paymentservice.service';

@Component({
  selector: 'app-paymentform',
  templateUrl: './paymentform.component.html',
  styleUrls: ['./paymentform.component.css']
})
export class PaymentformComponent {

  payment : Payment = new Payment(0,"", new Date(),0, 0 );
  isEditable: boolean;
  constructor(private service : PaymentserviceService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.payment);
    
  }

  onSubmit(){
    console.log(this.payment);
    this.service.savePayment( this.payment).subscribe(data =>
      console.log(data));
      alert("Payment done Successfully");
      this.router.navigateByUrl('/userwelcome');
  }
}
