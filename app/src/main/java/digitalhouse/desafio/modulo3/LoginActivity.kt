package digitalhouse.desafio.modulo3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btn_login).setOnClickListener(openActivity(HomeActivity::class.java))
        findViewById<TextView>(R.id.tv_createAccout).setOnClickListener(openActivity(RegisterActivity::class.java))
    }

    fun openActivity(activity: Class<out Activity>): View.OnClickListener? {
        return View.OnClickListener {
            startActivity(Intent(this, activity))
        }
    }
}