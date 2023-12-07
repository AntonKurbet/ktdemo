package com.example.ktdemo

import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList()

    fun findMessageById(id: String): List<Message> = db.findById(id).toList()

    fun save(message: Message) {
        db.save(message)
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
            if (isPresent) listOf(get()) else emptyList()

    fun deleteMessageById(id: String) = db.deleteById(id)

    fun updateMessageById(message: Message) : List<Message> {
        val m = message.id?.let { db.findById(it) }
        if (m != null) {
            m.get().text = message.text
            db.save(m.get())
            return m.toList()
        }
        return listOf()
    }
}