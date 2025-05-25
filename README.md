# Accesa Coding Challenge - Price Comparator Backend

## Tools
IDE: IntelliJ<br>
Language: Java (OpenJDK 17.0.15)<br>
Builder: Gradle (Kotlin)<br>
Framework: Spring Boot<br>
CSVs: BufferedReader, no libs<br>
"Frontend": HTML, Javascript<br>


## Structure
src/<br>
 ├── main/<br>
 │  ├── java/<br>
 │  │  └── org.App/<br>
 │  │    ├── Controllers/<br>
 │  │    │  ├── AlertsController<br>
 │  │    │  ├── BasketController<br>
 │  │    │  ├── DiscountsController<br>
 │  │    │  ├── HomeController<br>
 │  │    │  └── ProductsController<br>
 │  │    ├── Loaders/<br>
 │  │    │  ├── DiscountsLoader<br>
 │  │    │  └── ProductsLoader<br>
 │  │    ├── Models/<br>
 │  │    │  ├── Alerts<br>
 │  │    │  ├── Discounts<br>
 │  │    │  └── Products<br>
 │  │    ├── Service/<br>
 │  │    │  ├── AlertsService<br>
 │  │    │  ├── DiscountsService<br>
 │  │    │  └── ProductsService<br>
 │  │    └── Main<br>
 │  └── resources/<br>
 │    ├── data/<br>
 │    │  ├── kaufland_2025-05-01.csv<br>
 │    │  ├── kaufland_2025-05-08.csv<br>
 │    │  ├── kaufland_discounts_2025-05-01.csv<br>
 │    │  ├── kaufland_discounts_2025-05-08.csv<br>
 │    │  ├── lidl_2025-05-01.csv<br>
 │    │  ├── lidl_2025-05-08.csv<br>
 │    │  ├── lidl_discounts_2025-05-01.csv<br>
 │    │  ├── lidl_discounts_2025-05-08.csv<br>
 │    │  ├── mega_2025-05-20.csv<br>
 │    │  ├── mega_2025-05-23.csv<br>
 │    │  ├── mega_discounts_2025-05-20.csv<br>
 │    │  ├── mega_discounts_2025-05-23.csv<br>
 │    │  ├── profi_2025-05-01.csv<br>
 │    │  ├── profi_2025-05-08.csv<br>
 │    │  ├── profi_discounts_2025-05-01.csv<br>
 │    │  └── profi_discounts_2025-05-08.csv<br>
 │    └── static/<br>
 │      ├── add-alert.html<br>
 │      ├── basket.html<br>
 │      └── delete-alert.html<br>
 └────/ 
 

# Instructions
1. Go to "master" branch, click on "Code", and then "Download ZIP"
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
