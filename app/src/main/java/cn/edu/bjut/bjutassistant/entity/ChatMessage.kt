package cn.edu.bjut.bjutassistant.entity

data class ChatMessage(var content: String, var isRequest: Boolean = false, var isImage: Boolean = false)
