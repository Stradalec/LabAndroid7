package com.example.labandroid7

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class ContactAdapter(private val onClick: (String) -> Unit) : ListAdapter<Contact, ContactAdapter.ContactViewHolder>(ContactDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rview_item, parent, false)
        return ContactViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)
    }

    class ContactViewHolder(itemView: View, private var onClick: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textName)
        private val phoneTextView: TextView = itemView.findViewById(R.id.textPhone)
        private val typeTextView: TextView = itemView.findViewById(R.id.textType)

        fun bind(contact: Contact) {
            nameTextView.text = contact.name
            phoneTextView.text = contact.phone
            typeTextView.text = contact.type
            itemView.setOnClickListener {
                onClick(contact.phone)
            }
        }
    }
}

class ContactDiffCallback : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}