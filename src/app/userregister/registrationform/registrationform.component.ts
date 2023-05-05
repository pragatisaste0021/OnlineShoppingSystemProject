import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDetail } from 'src/app/common/user-detail';
import { UserloginserviceService } from 'src/app/service/userloginservice.service';

@Component({
  selector: 'app-registrationform',
  templateUrl: './registrationform.component.html',
  styleUrls: ['./registrationform.component.css']
})
export class RegistrationformComponent {

  userdetail: UserDetail = new UserDetail(0, "", "", "", "", "", "")
  userdetails: any
  password: string
  uname: string
  searchuser: string
  isEditable: boolean;
  users: UserDetail = JSON.parse(sessionStorage.getItem("userdetail"))
  constructor(private userservices: UserloginserviceService, private route: Router, public activateRoute: ActivatedRoute) { }

  ngOnInit(): void
   {
    this.activateRoute.paramMap.subscribe(()=>this.getuserbyuid())
  }
  getuserbyuid(): void {
    const uid  = parseFloat(this.activateRoute.snapshot.paramMap.get("uid"));
    console.log(uid)
    if(uid>0)
    {
      this.isEditable=true;
      this.userservices.getuserbyid(uid).subscribe(data=>{
        this.userdetail=data;
        console.log(this.userdetail);
      });
    }
  }

  SaveUsers(){
    if(this.isEditable){
      this.userservices.updateUser(this.userdetail).subscribe(data=>{
        alert("Successfully updated "+this.userdetail.username)
        sessionStorage.clear()
        localStorage.clear()
        this.route.navigateByUrl("")});
    }
    else{
      
    this.userservices.saveUser(this.userdetail).subscribe(data =>{
      alert("Successfully Register ")
      this.route.navigateByUrl("/userlogin")
    },
    error => alert("enter the user data ")
      );
      
  }
}
}
