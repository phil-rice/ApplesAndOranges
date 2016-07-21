package org.validoc.shopping

class ItemNotFoundException(item: Item) extends Exception(s"Item [$item] was not found")

class ItemFinder[M: Money](nameToSaleableItem: Map[Item, SaleableItem[M]]) extends (Item => SaleableItem[M]) {

  def apply(item: Item) = nameToSaleableItem.getOrElse(item, throw new ItemNotFoundException(item))
}
