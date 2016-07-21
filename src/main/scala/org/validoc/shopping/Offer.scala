package org.validoc.shopping


trait Offer[M] {
  def find(items: Seq[SaleableItem[M]]): Seq[SaleableItem[M]]
}

class BogofOffer[M](item: SaleableItem[M])(implicit money: Money[M]) extends Offer[M] {
  val discountItem: SaleableItem[M] = SaleableItem[M](s"Buy one ${item.item} get one free", money.negate(item.cost))

  override def find(items: Seq[SaleableItem[M]]): List[SaleableItem[M]] = {
    val theseItems = items.filter(_ == item)
    val numberOfBogofOffers = theseItems.size / 2
    List.fill(numberOfBogofOffers)(discountItem)
  }

}

class ThreeForTwoOffer[M](item: SaleableItem[M])(implicit money: Money[M]) extends Offer[M] {
  val discountItem: SaleableItem[M] = SaleableItem[M](s"Buy two ${item.item} get one free", money.negate(item.cost))

  override def find(items: Seq[SaleableItem[M]]): Seq[SaleableItem[M]] = {
    val theseItems = items.filter(_ == item)
    val numberOfOffers = theseItems.size  / 3
    List.fill(numberOfOffers)(discountItem)
  }
}
