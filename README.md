# IndexNet-Engine

IndexNet-Engine is a sophisticated Java-based web crawler and indexer that simulates a search engine using robust object-oriented programming principles. At the core of this application is the `NotGPT.java` class, which encapsulates the primary functionalities including web page indexing, searching, and ranking. This class is crucial not only for its functionality but also as a demonstration of high-quality software design.

## Project Structure

The project is meticulously organized into several key directories and files:

-   `src`: This directory contains all source files for the application, structured for optimal maintainability and scalability.

    -   `main`: Hosts the Java source files, clearly separated for better manageability.
        -   `java`: Directory for Java classes, showcasing exemplary use of package structuring.
            -   `edu/aav66`: Main package containing all crucial Java classes.
                -   `NotGPT.java`: The backbone of the search engine, implementing sophisticated data handling and processing.
                -   Additional supportive classes that leverage well-defined interfaces and inheritance.
                -   `DataStructures`: Dedicated package for custom data structures used by `NotGPT.java`, exemplifying encapsulation and abstraction.
                -   `GUI`: Contains classes for the graphical user interface, facilitating user interaction with the search engine using the MVC architecture.

-   `pom.xml`: Maven configuration file for managing dependencies, building, and running the application efficiently.

## Key Components

-   **`NotGPT.java`**: A testament to solid software engineering, this class manages web crawling, data collection, and indexing processes. It demonstrates advanced OOP concepts by implementing the `SearchEngine` interface, providing methods for indexing web pages, conducting searches, and ranking results based on intricate algorithms.
-   `BetterBrowser.java`: Simulates a web browser, abstracting the complexities of web fetching and rendering.
-   `Browser.java`: An interface that defines browser functionalities, promoting loose coupling and high cohesion.
-   `Collect.java`: Manages the collection and processing of web pages, illustrating effective exception handling and data parsing.
-   `Search.java`, `Rank.java`: Utilize the infrastructure provided by `NotGPT.java` to implement search and ranking functionalities, showing the power of inheritance and polymorphism.

## Input and Output Files

**Input Files**:

-   `worddisk-mary.txt`
-   `pagedisk-1-ranked.txt`
-   `pagedisk-1.txt`
-   `pagedisk-mary-ranked.txt`
-   `pagedisk-mary.txt`
-   `worddisk-1.txt`

**Output Files**:

-   Essential operational files such as `0.txt`, `fast.txt`, `slow.txt`, and various `tempa*` and `tempb*` files, demonstrating the application's data processing capabilities.
-   `sorted-votes.txt`
-   `unsorted-votes.txt`

## Building the Project

Ensure Maven is installed and execute the following command in the project root:

```bash
mvn clean install
```

## Running the Project

Execute the project using Maven or through your IDE by running `Rank.java` and `Search.java` as the main classes to fully utilize its capabilities:

```bash
mvn exec:java -Dexec.mainClass="edu.aav66.Rank"
mvn exec:java -Dexec.mainClass="edu.aav66.Search"
```
