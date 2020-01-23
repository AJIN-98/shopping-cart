import { Injectable, OnInit } from '@angular/core';
import { Cart } from '../model/cart';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, Subject, BehaviorSubject } from 'rxjs';
import { CartProduct } from '../model/cart-product';
import { ToastrService } from './toastr.service';
import { Item } from '../model/item';

@Injectable({
  providedIn: 'root'
})
export class CartService implements OnInit {
  API_URL = environment.apiUrl.concat('cart')

  constructor(private http: HttpClient, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.updateCurrentCart()
  }

  public get current(): Cart {
    if (!localStorage.getItem('currentCart')) {
      this.updateCurrentCart()
    }
    return JSON.parse(localStorage.getItem('currentCart'))
  }

  getCurrentCart(): Observable<Cart> {
    return this.http.get<Cart>(this.API_URL.concat('/current'))
  }

  updateCurrentCart() {
    this.getCurrentCart().subscribe(cart => {
      this.getCurrentCart().subscribe(cart => { localStorage.setItem('currentCart', JSON.stringify(cart)) })
    })
  }

  async putProductOnCurrentCart(item: Item) {
    this.http.get(this.API_URL.concat(`/put-product/${item.id}`)).subscribe((cart) => {
      localStorage.setItem('currentCart', JSON.stringify(cart));
      this.toastr.success(`Product ${item.name} was added!`);
    })
  }

  async decreaseProductOnCurrentCart(item: Item) {
    this.http.get(this.API_URL.concat(`/decrease-product/${item.id}`)).subscribe((cart) => {
      localStorage.setItem('currentCart', JSON.stringify(cart));
      this.toastr.success(`Product ${item.name} was decreased!`);
    })
  }

  async removeProductOnCurrentCart(item: Item) {
    this.http.get(this.API_URL.concat(`/remove-product/${item.id}`)).subscribe((cart) => {
      localStorage.setItem('currentCart', JSON.stringify(cart));
      this.toastr.success(`Product ${item.name} was removed!`);
    })
  }

  finishCart() {
    this.http.get(this.API_URL.concat('/finish')).subscribe(() => {
      localStorage.setItem('currentCart', JSON.stringify(new Cart()))
      this.toastr.success(`Cart finalized!`)
    })
  }

}
