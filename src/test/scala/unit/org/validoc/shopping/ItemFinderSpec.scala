package unit.org.validoc.shopping

import org.scalatest.{FlatSpec, Matchers}
import org.validoc.shopping.{ItemFinder, ItemNotFoundException}


class ItemFinderSpec extends FlatSpec with Matchers with ShoppingCartsFixture {
  val itemFinder = new ItemFinder(nameToSaleableItem)

  "An item finder" should "find the item specified by its name" in {
     itemFinder("Apple") shouldBe apple
     itemFinder("Orange") shouldBe orange
  }

  it should "throw ItemNotFoundException if the item was not found " in {
    intercept[ItemNotFoundException](itemFinder("not legal")).getMessage shouldBe "Item [not legal] was not found"
  }

}
