import {Component, OnInit} from '@angular/core'
import {AuthenticationService} from 'src/app/services/authentication.service'
import {CartService} from 'src/app/services/cart.service'
import {Cart} from 'src/app/model/cart'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  usernameLogged: string = ''

  constructor(private authService: AuthenticationService,
              private cartService: CartService) {
  }

  ngOnInit() {
    this.authService.currentUser.subscribe(u =>
      this.usernameLogged = u.username)
  }

  logout() {
    this.authService.logout()
  }

  public get itensOnCart(): number {
    return (this.currentCart.cartProducts || []).reduce((sum, cartProduct) => {
      return sum + cartProduct.amount
    }, 0)
  }

  public get currentCart(): Cart {
    return this.cartService.current
  }


}
