package me.imen.subtitle

import org.apache.log4j.Logger
import me.imen.util.FileUtil
import java.io.File

/**
 * User: mengmeng.cheng
 * Date: 5/6/14
 * Time: 11:23 AM
 * Email: chengmengmeng@gmail.com
 */
object SubtitleAdjustTime {
  val logger = Logger.getLogger(SubtitleAdjustTime.getClass)

  def main (args: Array[String]) {
    if (args.length != 2) {
      println("Usage: java -jar tools-1.0-SNAPSHOT.jar {subtitleFilePath} {delayInMills}")
      System.exit(-1)
    }

    val path = args(0)
    val delayInMills = args(1).toInt

    logger.info("begin to process")

    val fileList = FileUtil.getFiles(new File(path))

    if (fileList != null && !fileList.isEmpty) {
      fileList.foreach(f => {
        FileUtil.getExtension(f) match {
          case "ass" => AssAdjustTime.process(f.getAbsolutePath, delayInMills)
          case "srt" => SrtAdjustTime.process(f.getAbsolutePath, delayInMills)
          case _ => logger.error("unsupport subtitle: " + f.getName)
        }

        logger.info("processed: " + f + "\t" + delayInMills)
      })
    }

    logger.info("finish process ...")
  }

}
