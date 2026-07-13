package data.dto


import domain.model.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        brand = brand ?: "Unknown",
        price = price,
        rating = rating,
        thumbnail = thumbnail
    )
}