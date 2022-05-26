import enums.Status

class Product() {
    var title: String=""
    var description: String=""
    var sku: Int=0
    var price: Long= 0
    var status: Status = Status.PREORDER
    companion object {
        fun toProduct(line: String, separator: Char): Product {
            /////////// convert a line of string to array and convert to product

            val product = Product()
            try {
                val arr = line.split(separator).toTypedArray()

                product.title=arr[0]
                product.description=arr[1]
                product.sku = arr[2].toInt()
                product.price = arr[3].toLong()
                product.status = when(arr[4]){
                    "AVAILABLE"-> Status.AVAILABLE
                    "UNAVAILABLE"->Status.UNAVAILABLE
                    "PREORDER"->Status.PREORDER
                    else -> Status.PREORDER
                }
            }catch (e:Exception){
                e.printStackTrace()
            }

            return product

        }
    }

    override fun toString(): String {
        return "$title|$description|$sku|$price|${status.toString()}"

    }
}