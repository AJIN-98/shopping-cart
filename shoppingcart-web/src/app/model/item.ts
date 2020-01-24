export class Item {

  public constructor(init?: Partial<Item>) {
    Object.assign(this, init)
  }

  public id: string = ''
  public name: string = ''
  public value: number = 0.00
}
