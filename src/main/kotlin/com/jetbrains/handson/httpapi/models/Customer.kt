import kotlinx.serialization.Serializable

val customerStorage: MutableList<Customer> = mutableListOf(
    Customer("1", "Владос", "Бабарыкин", ""),
    Customer("2", "Димас", "Абрашкин", ""),
    Customer("3", "Еще кто- то", "-", ""),
)

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)
