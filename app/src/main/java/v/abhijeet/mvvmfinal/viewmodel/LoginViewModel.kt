package v.abhijeet.mvvmfinal.viewmodel



import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import v.abhijeet.mvvmfinal.Interface.LoginResultCallbacks
import v.abhijeet.mvvmfinal.Model.User
import v.abhijeet.mvvmfinal.view.SignupActivity


class LoginViewModel(private val listener: LoginResultCallbacks): ViewModel() {

    private val user: User
    init {
        this.user = User("", "")
    }


    val emailTextWatcher: TextWatcher
    get() = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            user.setEmail(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    }


    val passwordTextWatcher: TextWatcher
    get() = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            user.setPassword(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }

    fun onLoginClicked(@Suppress("UNUSED_PARAMETER")view: View) {


        val errorCode:Int = user.isDataValid()
        if (errorCode == 0) {
            listener.onError("Email must not me null")
        } else if (errorCode == 1) {
            listener.onError("Your email is invalid")
        } else if (errorCode == 2) {
            listener.onError("Password length must greater then 6 characters")
        } else {
            listener.onSuccess("Login Success")


        }

    }

    fun onSignUpClicked(view: View){
        Intent(view.context, SignupActivity::class.java).also {
            view.context.startActivity(it)
        }
    }


}