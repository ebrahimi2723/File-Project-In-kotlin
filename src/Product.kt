import enums.Status

class Product(
    var title:String,
    var description:String,
    var sku:Int,
    var price:Long,
    var status: Status = Status.PREORDER

) {
}