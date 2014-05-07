package me.imen.subtitle

/**
 * User: mengmeng.cheng
 * Date: 5/6/14
 * Time: 2:17 PM
 * Email: chengmengmeng@gmail.com
 */
object SrtAdjustTime extends AdjustTime{

  private val delimiter = " --> "

  private val pattern = """\d{2}:\d{2}:\d{2},\d{3}.{5}\d{2}:\d{2}:\d{2},\d{3}"""

  private val df = "HH:mm:ss,SSS"

  override def process(file: String, delayInMills: Int) =
    adjustTime(file, delayInMills, pattern, delimiter, df)

}
