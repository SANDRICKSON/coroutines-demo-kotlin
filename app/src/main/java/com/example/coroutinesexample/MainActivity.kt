package com.example.coroutinesexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val userIds = listOf<Long>(
        53214,
        33333,
        444453,
        222222
    )

    private val myRepository = MyRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {

            lifecycleScope.launch {

                for (userId in userIds) {

                    val user = myRepository.getUserById(userId)

                    println("User loaded: $userId")

                }
            }
        }
    }
}

class MyRepository {

    suspend fun getUserById(userId: Long): User {
        delay(3000)
        return User()
    }
}

class User