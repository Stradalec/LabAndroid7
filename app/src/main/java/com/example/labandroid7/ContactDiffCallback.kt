package com.example.labandroid7

import androidx.recyclerview.widget.DiffUtil

class ContactDiffCallback : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        // Сравниваем идентификаторы контактов
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        // Сравниваем содержимое контактов
        return oldItem.name == newItem.name && oldItem.phone == newItem.phone
    }
}
