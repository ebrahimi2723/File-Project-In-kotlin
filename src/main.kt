import enums.Status
import java.io.File
import java.io.PrintWriter






fun main() {

    ////////////list of product that content all product ---> deserialize
    val listProduct = mutableListOf<Product>()
    /////////////// url file that save all information
    val url = "D:\\\\\\\\Project\\\\KOTLIN\\\\File-Project-In-kotlin\\\\inventory.txt"



    var loop = true
    updateListOfProduct(listProduct,url)

    do {






            println("Welcome to inventory App Please select an option")
            println("[1] list of product")
            println("[2] add new product")
            println("[3] delete product")
            println("[4] find with sku ")
            println("[0] Exit ")
            val switch = readLine()?.toInt()

            when(switch){
                1-> {
                    println("List of Product is:")
                    show(url)

                }
                2-> {
                    addProduct(listProduct,url)
                }
                3->{
                    deleteProduct(listProduct,url)
                }
                4-> {
                    findProduct()
                }
                0 ->{
                    loop = false
                    println("SEE YOU AROUND")

                }
            }

    }while (loop)

}

fun findProduct() {



}



fun deleteProduct(listProduct: MutableList<Product>,url: String) {
    println("enter sku that you want remove")
    val value = readLine()?.toInt()
    listProduct.removeIf {
        it.sku == value
    }
    saveProductInFle(listProduct,url)
}

fun addProduct(listProduct:MutableList<Product>,url: String) {
    val newProduct = Product()
    println("For add product please to answer this question")
    println("what is name of new Product?")
    newProduct.title = readLine().toString()
    println("writ some description for ${newProduct.title}")
    newProduct.description = readLine().toString()
    println("enter a code for ${newProduct.title}")
    newProduct.sku = readLine()?.toInt()?: 0
    println("enter price of ${newProduct.price}")
    newProduct.price = readLine()?.toLong()?: 0
    println("what is  ${newProduct.title} ' status")
    println("[1] AVAILABLE")
    println("[2] UNAVAILABLE")
    println("[3] PREORDER")
    when(readLine()?.toInt()?:0){
        1->newProduct.status = Status.AVAILABLE
        2->newProduct.status = Status.UNAVAILABLE
        3->newProduct.status = Status.PREORDER
        else -> println("invalid input")
    }
    listProduct.add(newProduct)
    saveProductInFle(listProduct,url)


}



fun show(url:String) {
   File(url).forEachLine { println(it) }
}
fun saveProductInFle(listProduct:MutableList<Product>,url:String) {

            File(url).bufferedWriter().use { out ->
                for (product in listProduct){
                    out.write(product.toString()+"\n")
                }
               }
             updateListOfProduct(listProduct,url)
}
fun updateListOfProduct(listProduct:MutableList<Product> ,url: String){
    listProduct.clear()
    File(url).forEachLine {
        ///send a line from file to convert product
        listProduct.add(Product.toProduct(it, '|'))
    }
}