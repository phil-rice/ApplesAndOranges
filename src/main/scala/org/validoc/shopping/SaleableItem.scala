package org.validoc.shopping

case class SaleableItem[M: Money](item: String, cost: M )
