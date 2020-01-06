package com.gildedrose

sealed trait QualityUpdater {
  def pattern: String = ""

  def updateQuality(item: Item): Unit = item.sellIn = item.sellIn - 1
}

case class DefaultUpdater(step: Int = 1) extends QualityUpdater {
  override def updateQuality(item: Item): Unit = {
    super.updateQuality(item)
    item.quality = math.max(item.quality - (if (item.sellIn >= 0) 1 * step else 2 * step), 0)
  }
}

case class AgedBrieUpdater() extends QualityUpdater {
  override val pattern: String = "Aged Brie"

  override def updateQuality(item: Item): Unit = {
    super.updateQuality(item)
    item.quality = math.min(item.quality + 1, 50)
  }
}

case class SulfurasUpdater() extends QualityUpdater {
  override val pattern: String = "Sulfuras.*"

  override def updateQuality(item: Item): Unit = ()
}

case class BackstagePassesUpdater() extends QualityUpdater {
  override val pattern: String = "Backstage passes.*"

  override def updateQuality(item: Item): Unit = {
    super.updateQuality(item)
    val quality =
      if (item.sellIn < 0) 0
      else if (item.sellIn <= 5) item.quality + 3
      else if (item.sellIn <= 11) item.quality + 2
      else item.quality + 1

    item.quality = quality
  }
}

case class ConjuredUpdater() extends QualityUpdater {
  override val pattern: String = "Conjured.*"
  private val default = DefaultUpdater(2)

  override def updateQuality(item: Item): Unit = default.updateQuality(item)
}