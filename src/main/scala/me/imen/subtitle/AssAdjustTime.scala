package me.imen.subtitle

import java.io.File

/**
 * User: mengmeng.cheng
 * Date: 5/6/14
 * Time: 2:17 PM
 * Email: chengmengmeng@gmail.com
 */
object AssAdjustTime extends AdjustTime {

  private val delimiter = ","

  private val pattern = """\d{1}:\d{2}:\d{2}\.\d{2},\d{1}:\d{2}:\d{2}\.\d{2}"""

  private val df = "H:mm:ss.SS"

  override def process(file: String, delayInMills: Int) =
    adjustTime(file, delayInMills, pattern, delimiter, df)

}
