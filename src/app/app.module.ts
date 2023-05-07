import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrderListComponent } from './vieworder/order-list/order-list.component';
import { OrderformComponent } from './addorder/orderform/orderform.component';
import { FormsModule } from '@angular/forms';
import { UserListComponent } from './viewuser/user-list/user-list.component';
import { UserformComponent } from './adduser/userform/userform.component';
import { WelcomeComponent } from './adminhome/welcome/welcome.component';
import { ModeratorListComponent } from './viewmoderator/moderator-list/moderator-list.component';
import { ModeratorformComponent } from './addmoderator/moderatorform/moderatorform.component';
import { ProductListComponent } from './viewproduct/product-list/product-list.component';
import { ProductformComponent } from './addproduct/productform/productform.component';
import { AdminloginComponent } from './adminLogin/adminlogin/adminlogin.component';
import { ModeratorloginComponent } from './moderatorLogin/moderatorlogin/moderatorlogin.component';
import { ModeratorwelcomeComponent } from './moderatorhome/moderatorwelcome/moderatorwelcome.component';
import { UserproductformComponent } from './adduserproduct/userproductform/userproductform.component';
import { PaymentformComponent } from './addpayment/paymentform/paymentform.component';
import { UserwelcomeComponent } from './userhome/userwelcome/userwelcome.component';
import { UserloginComponent } from './userlogin/userlogin/userlogin.component';
import { UserproductlistComponent } from './viewuserproduct/userproductlist/userproductlist.component';
import { UserlogoutComponent } from './userlogout/userlogout/userlogout.component';
import { RegistrationformComponent } from './userregister/registrationform/registrationform.component';

@NgModule({
  declarations: [
    AppComponent,
    OrderListComponent,
    OrderformComponent,
    UserListComponent,
    UserformComponent,
    WelcomeComponent,
    ModeratorListComponent,
    ModeratorformComponent,
    ProductListComponent,
    ProductformComponent,
    AdminloginComponent,
    ModeratorloginComponent,
    ModeratorwelcomeComponent,
    UserproductformComponent,
    PaymentformComponent,
    UserwelcomeComponent,
    UserloginComponent,
    UserproductlistComponent,
    UserlogoutComponent,
    RegistrationformComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
