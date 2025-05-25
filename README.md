# Accesa Coding Challenge - Price Comparator Backend

## Tools
IDE: IntelliJ
Language: Java (OpenJDK 17.0.15)
Builder: Gradle (Kotlin)
Framework: Spring Boot
CSVs: BufferedReader, no libs
"Frontend": HTML, Javascript


## Structure

src/
├── main/
│   ├── java/
│   │   └── org.App/
│   │       ├── Controllers/
│   │       │   ├── AlertsController
│   │       │   ├── BasketController
│   │       │   ├── DiscountsController
│   │       │   ├── HomeController
│   │       │   └── ProductsController
│   │       ├── Loaders/
│   │       │   ├── DiscountsLoader
│   │       │   └── ProductsLoader
│   │       ├── Models/
│   │       │   ├── Alerts
│   │       │   ├── Discounts
│   │       │   └── Products
│   │       ├── Service/
│   │       │   ├── AlertsService
│   │       │   ├── DiscountsService
│   │       │   └── ProductsService
│   │       └── Main
│   └── resources/
│       ├── data/
│       │   ├── kaufland_2025-05-01.csv
│       │   ├── kaufland_2025-05-08.csv
│       │   ├── kaufland_discounts_2025-05-01.csv
│       │   ├── kaufland_discounts_2025-05-08.csv
│       │   ├── lidl_2025-05-01.csv
│       │   ├── lidl_2025-05-08.csv
│       │   ├── lidl_discounts_2025-05-01.csv
│       │   ├── lidl_discounts_2025-05-08.csv
│       │   ├── mega_2025-05-20.csv
│       │   ├── mega_2025-05-23.csv
│       │   ├── mega_discounts_2025-05-20.csv
│       │   ├── mega_discounts_2025-05-23.csv
│       │   ├── profi_2025-05-01.csv
│       │   ├── profi_2025-05-08.csv
│       │   ├── profi_discounts_2025-05-01.csv
│       │   └── profi_discounts_2025-05-08.csv
│       └── static/
│           ├── add-alert.html
│           ├── basket.html
│           └── delete-alert.html
└─────/


# Instructions
1. Go to the "master" branch, click on "Code", and then "Download ZIP"
2. Unzip the file, right-click the folder and select "Open Folder as IntelliJ IDEA Project"
3. Click "Trust Project" on the pop-up
4. Click "SetupSDK" in the top-right corner on the yellow ribbon, and select "ms-17" (OpenJDK 17)
5. Click "Load" in the bottom-right corner when prompted to load gradle build files
6. Navigate to "src/main/java/org.App/Main" and click "Run" (green arrow)
7. Go To: "http://localhost:8080/home"
8. Take a look at all the available addresses, copy any of them into your search bar to navigate them
Note: for "localhost:8080/products/store/{storeName}", you replace {storeName} with one of the options: lidl/kaufland/profi/mega, same thing with {categoryName}.


# Assumptions
IntelliJ & OpenJDK 17 have to be installed, I used ms-17, JDK version 17.0.15.
