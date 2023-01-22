package com.example.homework_5_1

class Presenter {
    private val model = Model()
    private lateinit var view: View

    fun increment() {
        model.increment()
        view.changeCount(model.counter)

        when (model.getCounterCondition()) {
            10, -10 -> view.showToast()
            15 -> view.changeColorToGreen()
        }
    }

    fun decrement() {
        model.decrement()
        view.changeCount(model.counter)
    }

    fun attachView(view: View) {
        this.view = view
    }

}