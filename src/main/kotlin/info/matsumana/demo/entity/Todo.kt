package info.matsumana.demo.entity

data class Todo(
        var id: Int = 0,
        var title: String = "",
        var detail: String? = null,
        var finished: Boolean = false
)
