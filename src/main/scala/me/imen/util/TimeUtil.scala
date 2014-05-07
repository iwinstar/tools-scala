package me.imen.util

import java.util.Calendar
import java.text.SimpleDateFormat

/**
 * User: mengmeng.cheng
 * Date: 5/7/14
 * Time: 3:15 PM
 * Email: chengmengmeng@gmail.com
 */
object TimeUtil {

  def adjustTime(time: String, delayInMills: Int, sdf: SimpleDateFormat) = {
    val cal = Calendar.getInstance

    cal.setTime(sdf.parse(time))
    cal.add(Calendar.MILLISECOND, delayInMills)

    sdf.format(cal.getTime)
  }

}
