package unit.org.validoc.shopping

import org.validoc.shopping.{ItemFinder, SaleableItem}

trait ShoppingCartsFixture {
  val apple = SaleableItem("Apple", 60)
  val orange = SaleableItem("Orange", 25)

  val nameToSaleableItem = Map("Apple" -> apple, "Orange" -> orange)



}
