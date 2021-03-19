package v.abhijeet.mvvmfinal.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModelProvider
import v.abhijeet.mvvmfinal.Interface.LoginResultCallbacks
import v.abhijeet.mvvmfinal.viewmodel.LoginViewModel
import v.abhijeet.mvvmfinal.viewmodel.LoginViewModelFactory
import v.abhijeet.mvvmfinal.R
import v.abhijeet.mvvmfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LoginResultCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        activityMainBinding.viewmodel = ViewModelProvider(this,
            LoginViewModelFactory(this)
        ).get(LoginViewModel::class.java)
    }

    override fun onSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        startActivity(Intent(this,SignupActivity::class.java))
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
