package me.imen.util

import java.io.File
import me.imen.common.Keys

/**
 * User: mengmeng.cheng
 * Date: 5/6/14
 * Time: 1:33 PM
 * Email: chengmengmeng@gmail.com
 */
object FileUtil {

  def getFiles(dir: File): Iterator[File] = {
    val files = dir.listFiles

    if (files != null) {
      val children = dir.listFiles.filter(_.isDirectory)

      files.filter(!_.isDirectory).toIterator ++ children.toIterator.flatMap(getFiles _)
    } else {
      Array(dir).toIterator
    }
  }

  def getExtension(file: File) = {
    val name = file.getName
    name.substring(name.lastIndexOf(Keys.FILE_EXT_DELIMITER) + 1)
  }

  def addSuffix(file: String, suffix: String) = {
    file.substring(0, file.lastIndexOf(Keys.FILE_EXT_DELIMITER)) + suffix + file.substring(file.lastIndexOf(Keys.FILE_EXT_DELIMITER))
  }

}
