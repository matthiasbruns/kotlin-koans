package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    return customers.filter { it -> it.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders.filter { it -> it.isDelivered }
            .flatMap { (products) -> products }
            .maxBy { product -> product.price }

}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return customers
            .filter { allOrderedProducts.contains(product) } // check if the customer has ever ordered the product
            .flatMap { customer -> customer.orders }
            .flatMap { order -> order.products }
            .filter { it -> it == product } // find the product
            .count() // count the product
}
