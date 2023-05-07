import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/common/admin';
import { AdminserviceService } from 'src/app/service/adminservice.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {

  admin : Admin[]
  admin_name : string;
  admin_Id : number;
  constructor(private service:AdminserviceService,private route:Router,private activateroute:ActivatedRoute) { }

 ngOnInit(): void {
  this.activateroute.paramMap.subscribe(()=>{this.adminList()})
}

 adminList() {
  this.service.getAllAdmin().subscribe(data=>{
    console.log(data);
    this.admin=data
  })
}

validate() {
  const admins=this.admin.find((a:any)=>{console.log(this.admin_name)
    return a.admin_name===this.admin_name 
  });

  if(admins){
    alert("Login Success");
    this.route.navigateByUrl('/welcome')
  }
  else{
    alert("Invalid User");
  }
}
}
