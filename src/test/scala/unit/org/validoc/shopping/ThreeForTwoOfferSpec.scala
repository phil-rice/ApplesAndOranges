package unit.org.validoc.shopping

import org.scalatest.{FlatSpec, Matchers}
import org.validoc.shopping.{Offer, SaleableItem}


class ThreeForTwoOfferSpec extends FlatSpec with Matchers with ShoppingCartsFixture {

  val threeForTwoOranges = Offer.threeForThePriceOfTwo[Int](orange)
  val discountedItem = SaleableItem[Int](s"Buy 3 Oranges get one free", -25)

  "A ThreeForTwoOffer" should "return a seq of three for two offers" in {
    threeForTwoOranges.find(Seq()) shouldBe Seq()
    threeForTwoOranges.find(Seq(apple, orange)) shouldBe Seq()
    threeForTwoOranges.find(Seq(apple, orange, orange)) shouldBe Seq()
    threeForTwoOranges.find(Seq(apple, orange, orange, apple, orange)) shouldBe Seq(discountedItem)
    threeForTwoOranges.find(Seq(apple, orange, orange, apple, orange, orange, apple)) shouldBe Seq(discountedItem)
    threeForTwoOranges.find(Seq(apple, orange, orange, apple, orange, orange, apple, orange)) shouldBe Seq(discountedItem)
    threeForTwoOranges.find(Seq(apple, orange, orange, apple, orange, orange, apple, orange, orange)) shouldBe Seq(discountedItem, discountedItem)
  }
}
