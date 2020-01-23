import { Component, OnInit } from '@angular/core';
import { ItemService } from 'src/app/services/item.service';
import { Item } from 'src/app/model/item';
import { ToastrService } from 'src/app/services/toastr.service';
import { Router, ActivatedRoute } from '@angular/router';
import { SearchPipe } from 'src/app/pipe/search.pipe';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  constructor(private service: ItemService, private toastr: ToastrService, private router: Router, private route: ActivatedRoute) { }

  products: Item[] = []

  ngOnInit() {
    this.populateItems()
  }

  populateItems() {
    this.service.listProducts().subscribe((items) => {
      this.products = items
    })
  }

  removeItem(item) {
    this.service.deleteProduct(item).subscribe(() => {
      this.toastr.success(`Product ${item.name} deleted!`)
      this.populateItems()
    })
  }

  toEdition(item) {
    this.router.navigate([`/products/form/${item.id}`], { relativeTo: this.route })
  }

}
