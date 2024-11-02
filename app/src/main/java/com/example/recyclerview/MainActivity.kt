package com.example.recyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.email
import com.example.recyclerview.model.fakeEmails
import com.mooveit.library.Fakeit
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fakeit.init()
        //enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = EmailAdapter(fakeEmails())
        binding.recyclerViewMain.adapter = adapter
        binding.recyclerViewMain.layoutManager = LinearLayoutManager(this)

        binding.fab.setOnClickListener {
            addEmail()
            binding.recyclerViewMain.scrollToPosition(0)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun addEmail() {

        val sdf: Date? = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).parse(
            Fakeit.dateTime().dateFormatter()
        )

        val newEmail = email {
            user = Fakeit.name().firstName()
            subject = Fakeit.company().name()

            date = SimpleDateFormat("d MMM", Locale("pt", "BR")).format(sdf)
            isImportant = false
            isRead = false
            message = "dsfg sdfg sdfgsdfg s"

            preview = Fakeit.lorem().words().split(" ").take(10).joinToString(" ")
        }
        adapter.emails.add(0, newEmail)
        adapter.notifyItemInserted(0)
        Log.d("EmailLog", adapter.emails.toString())
        Log.d("count", adapter.emails.size.toString())

    }
}