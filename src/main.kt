import java.io.File

fun main() {
        var listProduct = mutableListOf<Product>()
        File("C:\\\\Users\\a\\IdeaProjects\\File Project In kotlin\\inventory.txt").forEachLine {
                ///send a line from file to convert product
             listProduct.add(Product.toProduct(it,'|'))
//                toProduct(it,'|')
        }

}
//fun toProduct(line: String, separator: Char) {
//        /////////// convert a line of string to array and convert to product
//        val arr = line.split(separator).toTypedArray()
//        for (item in arr) {
//                println("${item.indexOf(item)} is $item")
//
//        }
//}