package org.validoc.shopping

class PriceCalculator[M](itemFinder: ItemFinder[M], offers: List[Offer[M]] = List())(implicit val money: Money[M]) {

  import money._

  def calculatePayment(items: Item*): M = {
    val saleableItems: Seq[SaleableItem[M]] = items.map(itemFinder)
    val discountedItems = offers.flatMap(offer => offer.find(saleableItems))
    (saleableItems ++ discountedItems).map(_.cost).foldLeft(zero)(sum)
  }

}