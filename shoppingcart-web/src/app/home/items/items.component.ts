import { Component, OnInit } from '@angular/core'
import { ItemService } from 'src/app/services/item.service'
import { ActivatedRoute, Router } from '@angular/router'
import { Item } from 'src/app/model/item'
import { ToastrService } from 'src/app/services/toastr.service'
import { CartService } from 'src/app/services/cart.service'

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  constructor(private service: ItemService,
    private toastr: ToastrService,
    private router: Router,
    private route: ActivatedRoute,
    private cartService: CartService) { }

  items: Item[] = []

  ngOnInit() {
    this.populateItems()
  }

  populateItems() {
    this.service.listProducts().subscribe((items) => {
      this.items = items
    })
  }

  addToCart(item: Item) {
    this.cartService.putProductOnCurrentCart(item)
  }

}
