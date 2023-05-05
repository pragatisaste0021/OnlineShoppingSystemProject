import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDetail } from 'src/app/common/user-detail';
import { UserloginserviceService } from 'src/app/service/userloginservice.service';
import { UserproductserviceService } from 'src/app/service/userproductservice.service';

@Component({
  selector: 'app-userlogout',
  templateUrl: './userlogout.component.html',
  styleUrls: ['./userlogout.component.css']
})
export class UserlogoutComponent {

  userdetail: UserDetail = new UserDetail(0, "", "", "", "", "", "")
  userdetails: any
  password: string
  uname: string
  searchuser: string
  isActive : boolean

  users: UserDetail = JSON.parse(sessionStorage.getItem("userdetail"))
  constructor(private userservices: UserloginserviceService, private route: Router, public activateRoute: ActivatedRoute) { }
  Getlogin(): void {

    this.userservices.getlogin(this.userdetail).subscribe(data => {
      alert("Login Successfully"),
        console.log("login response" + data)
        this.isActive = true;

      sessionStorage.setItem("user", JSON.stringify(data))

      this.route.navigateByUrl("/adduserproduct")

    },
      error => alert("Sorry Please Enter correct Username And Password"));

  }

  logout(){
    if(this.isActive){
      alert("Logout successfully");
      this.route.navigateByUrl('/homepage')
    }
    else{
      alert("User not logged in");
    }
  }
}
