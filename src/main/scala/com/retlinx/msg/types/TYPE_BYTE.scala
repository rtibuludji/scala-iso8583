/**
  * Retlinx Message Processor
  *
  *
  * @author Redi Tibuludji
  */
package com.retlinx.msg.types

import com.retlinx.msg.format.charset.{CHARSET_NONE, Charset}
import com.retlinx.msg.format.length.LengthFormat

case object TYPE_BYTE extends Type {
  override def calcLengthInByte(length: Int): Int = length

  override def required(charset: Charset, lengthFormat: LengthFormat): Unit = {
    require(charset == CHARSET_NONE, "invalid charset, must CHARSET_NONE")
    require(lengthFormat.scale == 0, "scale not support in this type")
  }

  override def validate(data: Array[Byte], pos: Int, length: Int, charset: Charset): Boolean = true
  override def validate(data: Array[Byte], charset: Charset): Boolean = true
}
