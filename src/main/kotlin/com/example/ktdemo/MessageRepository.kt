package com.example.ktdemo

import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String>