# Product Catalog - Kotlin Multiplatform

A Kotlin Multiplatform application built using Compose Multiplatform and Clean Architecture. The app fetches products from the DummyJSON API, supports searching, and displays product details.

## Features

- Product List
- Product Search
- Product Detail Screen
- Clean Architecture
- Kotlin Multiplatform
- Compose Multiplatform UI
- Ktor Networking
- StateFlow for UI State
- Coroutines

## Tech Stack

- Kotlin Multiplatform
- Compose Multiplatform
- Ktor Client
- Kotlinx Serialization
- Coroutines
- StateFlow

## Project Structure

shared
│
├── data
│ ├── dto
│ ├── remote
│ └── repository
│
├── domain
│ ├── model
│ ├── repository
│ └── usecase
│
├── presentation
│ ├── productlist
│ └── productdetail
│
└── di

## Architecture

UI (Compose)
↓
ViewModel
↓
Use Cases
↓
Repository
↓
Ktor API
↓
DummyJSON API

## API

https://dummyjson.com/products

## Screens

- Product List
- Search Products
- Product Details

## Future Improvements

- Product Images
- Pagination
- Pull to Refresh
- Offline Caching
