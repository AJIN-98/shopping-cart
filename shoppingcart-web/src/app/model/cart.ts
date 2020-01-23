import { User } from './user'
import { CartProduct } from './cart-product'

export class Cart {
    id: string
    user: User
    createdAt: string
    status: string = ''
    cartProducts: CartProduct[] = []
}