package unit.org.validoc.shopping

import org.scalatest.{FlatSpec, Matchers}
import org.validoc.shopping.{Offer, SaleableItem}

class BogofOfferSpec extends FlatSpec with Matchers with ShoppingCartsFixture {

  val bogOffApples = Offer.bogof(apple)

  val discountedItem = SaleableItem[Int](s"Buy 2 Apples get one free", -60)

  "A BogofOffer" should "return a seq of BogOfOffers" in {
    bogOffApples.find(Seq()) shouldBe Seq()
    bogOffApples.find(Seq(apple, orange)) shouldBe Seq()
    bogOffApples.find(Seq(apple, apple, orange)) shouldBe Seq(discountedItem)
    bogOffApples.find(Seq(apple, apple, apple, orange, orange)) shouldBe Seq(discountedItem)
    bogOffApples.find(Seq(apple, apple, apple, apple, orange, orange)) shouldBe Seq(discountedItem, discountedItem)
  }

}
