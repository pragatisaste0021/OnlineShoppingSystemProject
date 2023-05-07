import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDetail } from 'src/app/common/user-detail';
import { UserloginserviceService } from 'src/app/service/userloginservice.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent {

  userdetail: UserDetail = new UserDetail(0, "", "", "", "", "", "")
  userdetails: any
  password: string
  uname: string
  searchuser: string

  users: UserDetail = JSON.parse(sessionStorage.getItem("userdetail"))
  constructor(private userservices: UserloginserviceService, private route: Router, public activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
  }
  Getlogin(): void {

    this.userservices.getlogin(this.userdetail).subscribe(data => {
      alert("Login Successfully"),
        console.log("login response" + data)

      sessionStorage.setItem("user", JSON.stringify(data))

      this.route.navigateByUrl("/userwelcome")

    },
      error => alert("Sorry Please Enter correct Username And Password"));

  }
  newregistration(){
    this.route.navigateByUrl("/register")
  }
  onSubmit() {
    this.route.navigateByUrl("/userlogin");

  }
  
}
