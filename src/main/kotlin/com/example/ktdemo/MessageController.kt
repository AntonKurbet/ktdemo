package com.example.ktdemo

import org.springframework.web.bind.annotation.*

@RestController
class MessageController(val service: MessageService) {
    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> =
            service.findMessageById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) =
        service.save(message)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
            service.deleteMessageById(id)

    @PutMapping("/")
    fun update(@RequestBody message: Message): List<Message> =
            service.updateMessageById(message)
}