package org.validoc.shopping


trait Offer[M] {
  def find(items: Seq[SaleableItem[M]]): Seq[SaleableItem[M]]
}

object Offer {
  def bogof[M: Money](item: SaleableItem[M]) = new BuyNGetOneFreeOffer[M](item, 2)

  def threeForThePriceOfTwo[M: Money](item: SaleableItem[M]) = new BuyNGetOneFreeOffer[M](item, 3)
}

class BuyNGetOneFreeOffer[M](item: SaleableItem[M], n: Int)(implicit money: Money[M]) extends Offer[M] {
  val discountItem: SaleableItem[M] = SaleableItem[M](s"Buy $n ${item.item}s get one free", money.negate(item.cost))

  override def find(items: Seq[SaleableItem[M]]): List[SaleableItem[M]] = {
    val theseItems = items.filter(_ == item)
    val numberOfOffers = theseItems.size / n
    List.fill(numberOfOffers)(discountItem)
  }

}

