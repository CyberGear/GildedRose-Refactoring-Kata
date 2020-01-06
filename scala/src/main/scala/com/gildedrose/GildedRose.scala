package com.gildedrose

class GildedRose(val items: Array[Item]) {

  private val strategies: List[QualityUpdater] = List(
    AgedBrieUpdater(),
    SulfurasUpdater(),
    BackstagePassesUpdater(),
    ConjuredUpdater()
  )

  def updateQuality(): Unit = items.foreach(updateQuality)

  def updateQuality(item: Item): Unit =
    strategies
      .find { updater => item.name.matches(updater.pattern) }
      .getOrElse(DefaultUpdater())
      .updateQuality(item)

}