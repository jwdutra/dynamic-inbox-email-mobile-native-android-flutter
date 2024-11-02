package com.example.recyclerview.model

data class Email(
    val user: String,
    val subject: String,
    val preview: String,
    val message: String,
    val date: String,
    val isImportant: Boolean = false,
    val isRead: Boolean = false,
    val isSelected: Boolean = false
)

class EmailBuilder {
    var user: String = ""
    var subject: String = ""
    var preview: String = ""
    var message: String = ""
    var date: String = ""
    var isImportant: Boolean = false
    var isRead: Boolean = false
    private var isSelected: Boolean = false

    fun build(): Email {
        return Email(user, subject, preview, message, date, isImportant, isRead, isSelected)
    }
}

fun email(block: EmailBuilder.() -> Unit): Email {
    return EmailBuilder().apply(block).build()
}

fun fakeEmails(): MutableList<Email> = mutableListOf(
    email {
        user = "Mary Doe"
        subject = "Hello"
        preview = "Hello, how are you?"
        message = "Hello, how are you? I hope you are doing well."
        date = "7 nov"
        isImportant = true
        isRead = true
    },
    email {
        user = "John Doe"
        subject = "Meeting"
        preview = "Meeting at 2:00 PM"
        message = "Meeting at 2:00 PM. Don't forget to bring the report."
        date = "10 out"
        isImportant = true
        isRead = false
    },
    email {
        user = "Day Doe"
        subject = "Re: Hello"
        preview = "Re: Hello, how are you?"
        message = "Re: Hello, how are you? I am doing well."
        date = "02 out"
        isImportant = false
        isRead = true
    },
    email {
        user = "Peter Doe"
        subject = "Re: Meeting"
        preview = "Re: Meeting at 2:00 PM"
        message = "Re: Meeting at 2:00 PM. I will bring the report."
        date = "20 set"
        isImportant = false
        isRead = false
    },
    email {
        user = "Jane Doe"
        subject = "Re: Hello"
        preview = "Re: Hello, how are you?"
        message = "Re: Hello, how are you? I am doing well."
        date = "18 set"
        isImportant = false
        isRead = true
    },
    email {
        user = "John Doe"
        subject = "Re: Meeting"
        preview = "Re: Meeting at 2:00 PM"
        message = "Re: Meeting at 2:00 PM. I will bring the report."
        date = "12 set"
        isImportant = false
        isRead = false
    },
    email {
        user = "Baby Doe"
        subject = "Re: Hello"
        preview = "Re: Hello, how are you?"
        message = "Re: Hello, how are you? I am doing well."
        date = "2 set"
        isImportant = false
        isRead = true
    },
    email {
        user = "Baby Doe"
        subject = "Re: Hello"
        preview = "Re: Hello, how are you?"
        message = "Re: Hello, how are you? I am doing well."
        date = "22 ago"
        isImportant = false
        isRead = true
    },
    email {
        user = "Baby Doe"
        subject = "Re: Hello"
        preview = "Re: Hello, how are you?"
        message = "Re: Hello, how are you? I am doing well."
        date = "19 jul"
        isImportant = false
        isRead = true
    },
    email {
        user = "Baby Doe"
        subject = "Re: Hello"
        preview = "Re: Hello, how are you?"
        message = "Re: Hello, how are you? I am doing well."
        date = "8:00 AM"
        isImportant = false
        isRead = true
    },
)