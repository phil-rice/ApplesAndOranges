package org.validoc.shopping

class PriceCalculator[M](itemFinder: ItemFinder[M])(implicit val money: Money[M]) {
  import money._

  def calculatePayment(items: Item*): M = items.map(itemFinder).map(_.cost).foldLeft(zero)(sum)

}