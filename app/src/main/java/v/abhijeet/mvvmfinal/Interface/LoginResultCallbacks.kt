package v.abhijeet.mvvmfinal.Interface

interface LoginResultCallbacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}