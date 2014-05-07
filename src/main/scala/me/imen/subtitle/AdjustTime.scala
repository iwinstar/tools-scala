package me.imen.subtitle

import java.io.{File, FileWriter, BufferedWriter}
import scala.io.Source
import java.text.SimpleDateFormat
import me.imen.common.Keys
import me.imen.util.{TimeUtil, FileUtil}

/**
 * User: mengmeng.cheng
 * Date: 5/7/14
 * Time: 8:31 PM
 * Email: chengmengmeng@gmail.com
 */
abstract class AdjustTime {
  def process(file: String, delayInMills: Int)

  def adjustTime(file: String, delayInMills: Int, pattern: String, delimiter: String, df: String) {
    val regex = pattern.r
    val sdf = new SimpleDateFormat(df)
    val output = new BufferedWriter(new FileWriter(FileUtil.addSuffix(file, Keys.SUFFIX)))

    Source.fromFile(file).getLines().foreach(line => {
      val result = regex.findFirstIn(line) match {
        case Some(time) =>
          val tokens = time.split(delimiter)

          if (tokens.length == 2) {
            val adjusted = TimeUtil.adjustTime(tokens(0), delayInMills, sdf) + delimiter + TimeUtil.adjustTime(tokens(1), delayInMills, sdf)
            line.replace(time, adjusted)
          } else {
            line
          }

        case _ => line
      }

      output.write(result + Keys.NEWLINE)
    }
    )
  }

}
