import enums.Status

class Product(
    var title: String,
    var description: String,
    var sku: Int,
    var price: Long,
    var status: Status = Status.PREORDER

) {
    companion object {
        fun toProduct(line: String, separator: Char): Product {
            /////////// convert a line of string to array and convert to product
            val arr = line.split(separator).toTypedArray()

            val product = Product(
                arr[0], arr[1], arr[2].toInt(), arr[3].toLong(), when (arr[4]) {
                    "AVAILABLE" -> Status.AVAILABLE
                    "UNAVAILABLE" -> Status.UNAVAILABLE
                    "PREORDER" -> Status.PREORDER
                    else -> Status.PREORDER
                }
            )
            return product
        }
    }
}