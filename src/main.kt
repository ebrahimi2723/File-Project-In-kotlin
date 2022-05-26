import java.io.File

fun main() {
        var productList= mutableListOf<Product>()
        File("C:\\\\Users\\a\\IdeaProjects\\File Project In kotlin\\inventory.txt").forEachLine {
                println(it)
        }

}