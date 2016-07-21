package unit.org.validoc.shopping

import org.scalatest.{FlatSpec, Matchers}
import org.validoc.shopping.{ItemFinder, Offer, PriceCalculator}

class PriceCalculatorSpec extends FlatSpec with Matchers with ShoppingCartsFixture {

  "A shopping trolley price calculator, with no offers" should "add up the values of the items in a cart" in {
    val itemFinder = new ItemFinder(nameToSaleableItem)
    val priceCalculator = new PriceCalculator[Int](itemFinder)
    priceCalculator.calculatePayment("Apple") shouldBe 60
    priceCalculator.calculatePayment("Orange") shouldBe 25
    priceCalculator.calculatePayment("Apple", "Orange") shouldBe 85
    priceCalculator.calculatePayment("Apple", "Apple", "Orange", "Apple") shouldBe 205
  }

  "A shopping trolley price calculator with Bogof offers" should "add up the values of the items, including the discounts added by the offer calculator" in {
    val itemFinder = new ItemFinder(nameToSaleableItem)
    val priceCalculator = new PriceCalculator[Int](itemFinder, List(Offer.bogof(apple)))
    priceCalculator.calculatePayment("Apple") shouldBe 60
    priceCalculator.calculatePayment("Orange") shouldBe 25
    priceCalculator.calculatePayment("Apple", "Orange") shouldBe 85
    priceCalculator.calculatePayment("Apple", "Apple", "Orange", "Apple") shouldBe 145
  }
}
