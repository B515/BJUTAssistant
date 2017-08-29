package cn.edu.bjut.bjutassistant.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import cn.edu.bjut.bjutassistant.R
import cn.edu.bjut.bjutassistant.entity.ChatMessage
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import java.util.*

class ChatActivity : AppCompatActivity() {

    lateinit var adapter: ChatMessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        setSupportActionBar(toolbar)

        recycler.layoutManager = LinearLayoutManager(this)
        adapter = ChatMessageAdapter(this, ArrayList<ChatMessage>())
        adapter.add(ChatMessage(getString(R.string.welcome)))
        recycler.adapter = adapter

        button_submit.setOnClickListener(View.OnClickListener {
            val message = edit_question.text.toString()
            if (TextUtils.isEmpty(message)) {
                return@OnClickListener
            }
            sendMessage(message)
            edit_question.setText("")
        })
    }

    private fun sendMessage(message: String) {
        val chatMessage = ChatMessage(message, true, false)
        adapter.add(chatMessage)

        recycler.scrollToPosition(adapter.itemCount - 1)
        getResult(message)
    }

    private fun getResult(message: String) = async(UI) {
        // TODO get results from API
        async(CommonPool) {
            delay(400)
        }.await()

        val chatMessage = ChatMessage("<结果>", false, false)
        adapter.add(chatMessage)

        recycler.scrollToPosition(adapter.itemCount - 1)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
