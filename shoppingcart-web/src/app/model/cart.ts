import {User} from './user'
import {CartProduct} from './cart-product'

export class Cart {
  id: string = null
  user: User = new User()
  createdAt: string = ''
  status: string = ''
  cartProducts: CartProduct[] = []
}
