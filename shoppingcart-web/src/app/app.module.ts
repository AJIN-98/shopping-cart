import {BrowserModule} from '@angular/platform-browser'
import {NgModule} from '@angular/core'
import {SweetAlert2Module} from '@sweetalert2/ngx-sweetalert2'
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import {AppComponent} from './app.component'
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http'
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'

import {ToastrModule} from 'ngx-toastr'
import {CommonModule} from '@angular/common'
import {ToastrService} from './services/toastr.service'
import {HomeModule} from './home/home.module'
import {AppRoutingModule} from './app.routes'
import {LoginComponent} from './login/login.component'
import {PageNotFoundComponent} from './page-not-found/page-not-found.component'
import {ItemService} from './services/item.service'
import {UserService} from './services/user.service'
import {AuthenticationService} from './services/authentication.service'
import {AuthGuard} from './auth/auth.guard'
import {TokenInterceptor} from './auth/token.interceptor'
import {CartService} from './services/cart.service'
import {PipeModule} from './pipe/pipe.module'

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PageNotFoundComponent
  ],
  imports: [
    CommonModule,
    HomeModule,
    FormsModule,
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    ToastrModule.forRoot({
      maxOpened: 2,
      autoDismiss: true,
      preventDuplicates: true,
      countDuplicates: true
    }),
    BrowserAnimationsModule,
    SweetAlert2Module.forRoot(),
    AppRoutingModule,
    PipeModule
  ],
  providers: [
    UserService,
    ItemService,
    ToastrService,
    AuthenticationService,
    CartService,
    AuthGuard,
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
