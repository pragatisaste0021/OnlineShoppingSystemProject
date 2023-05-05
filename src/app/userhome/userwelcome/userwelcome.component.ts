import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDetail } from 'src/app/common/user-detail';

@Component({
  selector: 'app-userwelcome',
  templateUrl: './userwelcome.component.html',
  styleUrls: ['./userwelcome.component.css']
})
export class UserwelcomeComponent {

  constructor(public activateroute:ActivatedRoute,private route:Router) { }
  userdetail:UserDetail
  ngOnInit(): void 
  {
    this.activateroute.paramMap.subscribe(()=>this.userdetail=JSON.parse(sessionStorage.getItem("userdetail")))

  }
  logout() {
    if (sessionStorage.getItem("userdetail")) {
      sessionStorage.clear()
      localStorage.clear()
      alert("Logout Successfully")
      this.route.navigateByUrl("/userlogin")
    }
    else {
      alert("No user loged in")
    }
  }
}
