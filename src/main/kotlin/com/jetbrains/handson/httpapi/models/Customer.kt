import kotlinx.serialization.Serializable

val customerStorage: MutableList<Customer> = mutableListOf(
    Customer("1", "Владос", "Бабарыкин", "", "fff"),
    Customer("2", "Димас", "Абрашкин", "", "dff"),
    Customer("3", "Еще кто- то", "-", "", "ewf"),
)

@Serializable
data class Customer(
    val id: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val email: String? = null
)
