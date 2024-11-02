package com.example.recyclerview

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.EmailItemBinding
import com.example.recyclerview.model.Email

class EmailAdapter(val emails: MutableList<Email>): RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val binding = EmailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmailViewHolder(binding)
    }

    override fun getItemCount(): Int = emails.size

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }

    inner class EmailViewHolder(private val binding: EmailItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(email: Email) {
            with(email) {
                val hash = user.hashCode()
                val red = (hash and 0xFF0000) shr 16
                val green = (hash and 0x00FF00) shr 8
                val blue = hash and 0x0000FF

                binding.txtIcon.text = user.first().toString()
                binding.txtIcon.background = itemView.oval(Color.rgb(red, green, blue))

                binding.txtUser.text = user
                binding.txtSubject.text = subject
                binding.txtPreview.text = preview
                binding.txtDate.text = date

                binding.imgStar.setImageResource(
                    if(isImportant) R.drawable.baseline_bookmark_24 else R.drawable.baseline_bookmark_border_24
                )

                setTypefaceBasedOnReadStatus(binding.txtUser, isRead)
                setTypefaceBasedOnReadStatus(binding.txtSubject, isRead)
                setTypefaceBasedOnReadStatus(binding.txtPreview, isRead)
                setTypefaceBasedOnReadStatus(binding.txtDate, isRead)

            }

        }

    }

}

fun setTypefaceBasedOnReadStatus(view: View, isRead: Boolean) {
    if (view is TextView) {
        view.setTypeface(Typeface.DEFAULT, if (isRead) Typeface.NORMAL else Typeface.BOLD)
    }
}

fun View.oval(@ColorInt color: Int): ShapeDrawable {
    val oval = ShapeDrawable(OvalShape())
    with(oval) {
        intrinsicWidth = width
        intrinsicHeight = height
        paint.color = color
    }
    return oval
}