package my.project.dagger2.presentation

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.project.dagger2.AppComponent
import my.project.dagger2.R
import my.project.dagger2.appComponent
import my.project.dagger2.data.Analytics
import javax.inject.Inject


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        appComponent.inject(this)


    }
}


