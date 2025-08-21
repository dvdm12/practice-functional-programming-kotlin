package excercises

// ---------- 5) Lazy Evaluation ----------

val config: String by lazy {
    println("Loading config...")
    "https://api.myapp.com"   
}


fun fetchData(endpoint: String): String {
    return "Fetching from $config$endpoint"
}

