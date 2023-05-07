import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Moderator } from 'src/app/common/moderator';
import { ModeratorserviceService } from 'src/app/service/moderatorservice.service';

@Component({
  selector: 'app-moderatorlogin',
  templateUrl: './moderatorlogin.component.html',
  styleUrls: ['./moderatorlogin.component.css']
})
export class ModeratorloginComponent {

  moderator : Moderator[]
  modName : string;
  modID : number;
  constructor(private service:ModeratorserviceService,private route:Router,private activateroute:ActivatedRoute) { }

 ngOnInit(): void {
  this.activateroute.paramMap.subscribe(()=>{this.moderatorList()})
}

 moderatorList() {
  this.service.getAllModerator().subscribe(data=>{
    console.log(data);
    this.moderator=data
  })
}
validate() {
  const moderators=this.moderator.find((m:any)=>{console.log(this.modName)
    return m.modName===this.modName
  });

  if(moderators){
    alert("Login Success");
    this.route.navigateByUrl('/moderatorwelcome')
  }
  else{
    alert("Invalid User");
  }
}
}
