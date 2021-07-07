package br.com.luizrcs.nbt.core.tag

import br.com.luizrcs.nbt.core.tag.TagType.*
import java.nio.*

class TagByteArray private constructor(name: String? = null) : Tag<ByteArray>(TAG_BYTE_ARRAY, name) {
	
	override val sizeInBytes get() = Int.SIZE_BYTES + _value.size
	
	constructor(value: ByteArray, name: String? = null) : this(name) {
		_value = value
	}
	
	constructor(byteBuffer: ByteBuffer, name: String? = null) : this(name) {
		read(byteBuffer)
	}
	
	override fun read(byteBuffer: ByteBuffer) {
		val length = byteBuffer.int
		
		_value = ByteArray(length)
		byteBuffer.get(_value, 0, length)
	}
	
	override fun write(byteBuffer: ByteBuffer) {
		byteBuffer.putInt(_value.size)
		byteBuffer.put(_value)
	}
	
	override fun clone(name: String?) = TagByteArray(value, name)
	
	override fun valueToString() = "[${_value.joinToString()}]"
}
