package mystudent.diary.presentation.abstractions

interface IPresenter<TView> {

    fun onViewCreated(view : TView)

    fun onStart(){}

    fun onResume(){}

    fun onPause(){}

    fun onStop(){}

    fun onDestroy()
}