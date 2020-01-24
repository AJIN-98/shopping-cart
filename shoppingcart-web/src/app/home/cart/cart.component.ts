import {Component, OnInit} from '@angular/core'
import {CartService} from 'src/app/services/cart.service'
import {Cart} from 'src/app/model/cart'
import {Router} from '@angular/router'
import {Item} from 'src/app/model/item'

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  currentCart: Cart

  constructor(private service: CartService,
              private router: Router) {
  }

  ngOnInit() {
    this.service.getCurrentCart().subscribe(cart => {
      this.currentCart = cart
    })
  }

  get getTotalValue() {
    return this.currentCart.cartProducts.reduce((sum, cartProduct) => {
      return sum + (cartProduct.amount * cartProduct.product.value)
    }, 0)
  }

  updateCurrentCart() {
    this.currentCart = JSON.parse(localStorage.getItem('currentCart'))
  }

  async increase(item: Item) {
    await this.service.putProductOnCurrentCart(item)
    this.updateCurrentCart()
  }

  async decrease(item: Item) {
    await this.service.decreaseProductOnCurrentCart(item)
    this.updateCurrentCart()
  }

  async remove(item: Item) {
    await this.service.removeProductOnCurrentCart(item)
    this.updateCurrentCart()
  }

  finish() {
    this.service.finishCart()
    this.router.navigate(['/app'])
  }

}
