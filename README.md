## Table of Contents

1.  [Introduction](#indexnet-engine)
2.  [Project Overview](#project-overview)
    -   Main Package Directory
    -   Key Classes and Their Functionalities
    -   Supportive Classes and Packages
3.  [Input and Output Files](#input-and-output-files)
4.  [Building the Project](#building-the-project)
5.  [Running the Project](#running-the-project)
6.  [Demonstration Output Explanation](#demonstration-output)
    -   [Simple Output](#simple-output)
    -   [Complex Output](#complex-output)
7.  [License](#license)

# IndexNet-Engine

**IndexNet-Engine** is a sophisticated Java-based web crawler and search engine simulator that leverages robust object-oriented programming principles to deliver a comprehensive solution for web indexing and searching. Central to this application is the `NotGPT.java` class, which orchestrates the core functionalities such as web crawling, data indexing, searching, and ranking of web pages. This class is pivotal not only for its direct functionalities but also for its role in integrating various components that enhance the system's efficiency and scalability.

The architecture of IndexNet-Engine is designed to maximize maintainability and extensibility:

-   **Modular Design**: Each component of the system, from web page collection (`Collect.java`) to user interaction (`GUI.java`), is encapsulated in a modular fashion, allowing for isolated development and testing which enhances system reliability and ease of updates.
-   **Data Handling**: Custom data structures and advanced sorting mechanisms (`BTree.java`, `ExternalSort.java`) are implemented to efficiently manage large datasets, ensuring quick access and manipulation of data, which is critical for performance in real-time search queries.
-   **User Interface**: The system includes a graphical user interface managed by `GUI.java`, which provides intuitive interaction for users, making the complex operations of web crawling and data retrieval accessible to end-users.

Overall, IndexNet-Engine is not just a testament to solid software engineering principles but also a robust framework that demonstrates advanced data handling, algorithmic efficiency, and user-centered design. This makes it an excellent educational tool for understanding the inner workings of search engines and a solid foundation for further research and development in information retrieval technologies.

## Project Overview

### `src/main/java/edu/aav66` - Main Package Directory

#### Key Classes and Their Functionalities:

-   **`NotGPT.java`**: Core class responsible for web crawling, data collection, and indexing. Implements the `SearchEngine` interface to define essential operations like indexing web pages and executing search queries with ranking algorithms.
-   **`BetterBrowser.java`**: Simulates a browser by managing web fetching and rendering processes. Provides utility functions to access and retrieve web content, abstracting the complexities of HTTP requests and HTML parsing.
-   **`Browser.java`**: Interface that outlines the functionalities expected from a browser-like class, ensuring that any implementing class adheres to the specified web browsing operations.
-   **`Collect.java`**: Handles the gathering and initial processing of web pages. This class is crucial for extracting text and other data from HTML content, which is then prepared for indexing and searching.
-   **`Rank.java`**: Utilizes `NotGPT.java` to perform ranking of indexed pages based on various criteria such as relevance to search queries. This class demonstrates the application of sorting algorithms and heuristics in search engine ranking.
-   **`Search.java`**: Works closely with `NotGPT.java` to handle search queries from users, showcasing effective use of data retrieval methods and search algorithms to fetch relevant results.
-   **`SearchEngine.java`**: Interface that defines the blueprint for search engine operations, ensuring compliance and standard functionality in classes like `NotGPT.java`.
-   **`Main.java`**: The entry point of the application, which orchestrates the flow between user inputs, browser simulation, data collection, and response generation.

### Supportive Classes and Packages:

-   **`DataStructures`**: Contains custom data structures such as `BTree.java`, `ArrayMap.java`, and `FileMap.java` that are optimized for specific functionalities within the search engine, like efficient data storage and retrieval.

    -   **`BTree.java`**: Implements a balanced tree data structure for efficient sorting and retrieval, ideal for maintaining ordered data with high performance for operations.
    -   **`ArrayMap.java`**: Provides a map-based data structure using arrays, suited for scenarios where key-based data access is required.
    -   **`FileMap.java`**: Manages mapping of data to file-based storage, facilitating persistent storage of large datasets.

-   **`ExternalSort.java`**: Implements external sorting algorithms, which are essential for handling large volumes of data that do not fit into main memory, ensuring efficient sorting without memory overflow.
-   **`GUI.java` and `UserInterface.java`**:

    -   **`GUI.java`**: Manages the graphical user interface of the application, facilitating interactive and user-friendly engagement with the system.
    -   **`UserInterface.java`**: Interface to ensure that the GUI adheres to certain standards and functionalities, making the application consistent and reliable in its user interactions.

-   **`HardDisk.java` and `InfoFile.java`**:

    -   **`HardDisk.java`**: Simulates hard disk operations, handling the reading and writing processes to the disk, crucial for data persistence.
    -   **`InfoFile.java`**: Used for managing metadata and information files that are critical for the operation and state management of the search engine.

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

    Note: All output files are displayed in the root directory for easy reference for project viewers.

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

## Demonstration Output:

### Demonstration Output Explanation

**`Rank.java`**:

-   The output of `Rank.java` primarily displays mappings and rankings associated with web pages.
    -   **Map from URL to Page Index**: Lists each page URL with its respective index in the system, providing a straightforward reference to each page's position.
    -   **Map from Page Index to Page Disk**: Details which pages correspond to specific disk locations, ensuring the efficient storage and retrieval of page data.
    -   **Rank Outputs**: Shows the ranking of each page based on computed metrics, which are crucial for understanding the relevance of pages in search results.

**`Search.java`**:

-   The output here involves responses from both GUI and Terminal, showing the search results.
    -   **GUI Output**: Presents a user-friendly display of found URLs containing the search terms, directly showing the relevance and accessibility of results.
    -   **Terminal Output**: Provides detailed mappings like URL to page index, mirroring the structure seen in `Rank.java`. It reinforces how the system organizes and accesses data, emphasizing the backend operations supporting the search functionality.

These outputs validate the effectiveness of the IndexNet-Engine in processing and retrieving data in a structured and user-friendly manner, showcasing its robust search and ranking capabilities within the web crawling and indexing domain.

### Output

#### **SIMPLE OUTPUT**:

    -   `Rank.java`:

    ```
    map from URL to page index
    {edu.miami.cs.www/home/vjm/csc220/google/fleece.html=20, edu.miami.cs.www/home/vjm/csc220/google/hill.html=11, edu.miami.cs.www/home/vjm/csc220/google/jack.html=19, e
    du.miami.cs.www/home/vjm/csc220/google/jill.html=7, edu.miami.cs.www/home/vjm/csc220/google/lamb.html=16, edu.miami.cs.www/home/vjm/csc220/google/little.html=23, edu.
    miami.cs.www/home/vjm/csc220/google/mary.html=0, edu.miami.cs.www/home/vjm/csc220/google/snow.html=3, edu.miami.cs.www/home/vjm/csc220/google/water.html=14, edu.miami
    .cs.www/home/vjm/csc220/google/white.html=8}
    map from page index to page disk
    {0=edu.miami.cs.www/home/vjm/csc220/google/mary.html[3, 7, 8, 11, 14, 16, 19]0.0, 3=edu.miami.cs.www/home/vjm/csc220/google/snow.html[8, 11, 20, 7, 23, 0]0.0, 7=edu.m
    iami.cs.www/home/vjm/csc220/google/jill.html[11, 23, 20, 14, 16, 8, 7]0.0, 8=edu.miami.cs.www/home/vjm/csc220/google/white.html[11, 23, 3, 14, 7, 8, 20, 19]0.0, 11=ed
    u.miami.cs.www/home/vjm/csc220/google/hill.html[14, 7, 20, 23, 11, 16, 19, 0, 3]0.0, 14=edu.miami.cs.www/home/vjm/csc220/google/water.html[0, 3, 11, 16, 23, 14]0.0, 1
    6=edu.miami.cs.www/home/vjm/csc220/google/lamb.html[3, 7, 0, 16, 19, 11, 8]0.0, 19=edu.miami.cs.www/home/vjm/csc220/google/jack.html[11, 0, 19, 23, 8, 3]0.0, 20=edu.m
    iami.cs.www/home/vjm/csc220/google/fleece.html[0, 19, 11, 3, 14, 16, 23]0.0, 23=edu.miami.cs.www/home/vjm/csc220/google/little.html[19, 0, 8, 11, 7, 3, 20, 14]0.0}
    map from word to word index
    {hill=0, white=7, snow=16, fleece=3, lamb=11, mary=20, water=14, jack=8, jill=19, little=23}
    map from word index to word file
    {0=hill[0, 7, 8, 11, 16, 20]0.0, 3=fleece[0, 3, 7, 14, 16, 19, 20, 23]0.0, 7=white[0, 3, 7, 16, 20, 23]0.0, 8=jack[0, 3, 8, 11, 14, 19, 20, 23]0.0, 11=lamb[0, 3, 7, 8
    , 14, 16, 23]0.0, 14=water[0, 3, 8, 11, 14, 16, 19, 23]0.0, 16=snow[3, 7, 8, 11, 14, 16, 19, 23]0.0, 19=jill[3, 7, 14, 16, 20]0.0, 20=mary[3, 7, 8, 11, 14, 16, 23]0.0
    , 23=little[8, 19, 20]0.0}
    page disk after slow rank
    edu.miami.cs.www/home/vjm/csc220/google/mary.html[3, 7, 8, 11, 14, 16, 19]1.0076844523972401
    edu.miami.cs.www/home/vjm/csc220/google/snow.html[8, 11, 20, 7, 23, 0]1.0937805924784265
    edu.miami.cs.www/home/vjm/csc220/google/jill.html[11, 23, 20, 14, 16, 8, 7]0.9975631010289547
    edu.miami.cs.www/home/vjm/csc220/google/white.html[11, 23, 3, 14, 7, 8, 20, 19]0.9955038697857829
    edu.miami.cs.www/home/vjm/csc220/google/hill.html[14, 7, 20, 23,11, 16, 19, 0, 3]1.4185863723242054
    edu.miami.cs.www/home/vjm/csc220/google/water.html[0, 3, 11, 16, 23, 14]0.9624703903279224
    edu.miami.cs.www/home/vjm/csc220/google/lamb.html[3, 7, 0, 16, 19, 11, 8]0.8278041785325262
    edu.miami.cs.www/home/vjm/csc220/google/jack.html[11, 0, 19, 23, 8, 3]0.9333688607571062
    edu.miami.cs.www/home/vjm/csc220/google/fleece.html[0, 19, 11, 3, 14, 16, 23]0.7353504394675593
    edu.miami.cs.www/home/vjm/csc220/google/little.html[19, 0, 8, 11, 7, 3, 20, 14]1.027887742900276
    page disk after fast rank
    edu.miami.cs.www/home/vjm/csc220/google/mary.html[3, 7, 8, 11, 14, 16, 19]1.00768445239724
    edu.miami.cs.www/home/vjm/csc220/google/snow.html[8, 11, 20, 7, 23, 0]1.093780592478426
    edu.miami.cs.www/home/vjm/csc220/google/jill.html[11, 23, 20, 14, 16, 8, 7]0.9975631010289546
    edu.miami.cs.www/home/vjm/csc220/google/white.html[11, 23, 3, 14, 7, 8, 20, 19]0.9955038697857828
    edu.miami.cs.www/home/vjm/csc220/google/hill.html[14, 7, 20, 23, 11, 16, 19, 0, 3]1.4185863723242051
    edu.miami.cs.www/home/vjm/csc220/google/water.html[0, 3, 11, 16, 23, 14]0.9624703903279223
    edu.miami.cs.www/home/vjm/csc220/google/lamb.html[3, 7, 0, 16, 19, 11, 8]0.8278041785325261
    edu.miami.cs.www/home/vjm/csc220/google/jack.html[11, 0, 19, 23, 8, 3]0.933368860757106
    edu.miami.cs.www/home/vjm/csc220/google/fleece.html[0, 19, 11, 3, 14, 16, 23]0.7353504394675591
    edu.miami.cs.www/home/vjm/csc220/google/little.html[19, 0, 8, 11, 7, 3, 20, 14]1.0278877429002757
    ```

    -   `Search.java`:

    ```
    map from URL to page index
    {edu.miami.cs.www/home/vjm/csc220/google/fleece.html=20, edu.miami.cs.www/home/vjm/csc220/google/hill.html=11, edu.miami.cs.www/home/vjm/csc220/google/jack.html=19, e
    du.miami.cs.www/home/vjm/csc220/google/jill.html=7, edu.miami.cs.www/home/vjm/csc220/google/lamb.html=16, edu.miami.cs.www/home/vjm/csc220/google/little.html=23, edu.
    miami.cs.www/home/vjm/csc220/google/mary.html=0, edu.miami.cs.www/home/vjm/csc220/google/snow.html=3, edu.miami.cs.www/home/vjm/csc220/google/water.html=14, edu.miami
    .cs.www/home/vjm/csc220/google/white.html=8}
    map from page index to page disk
    {0=edu.miami.cs.www/home/vjm/csc220/google/mary.html[3, 7, 8, 11, 14, 16, 19]1.00768445239724, 3=edu.miami.cs.www/home/vjm/csc220/google/snow.html[8, 11, 20, 7, 23, 0
    ]1.093780592478426, 7=edu.miami.cs.www/home/vjm/csc220/google/jill.html[11, 23, 20, 14, 16, 8, 7]0.9975631010289546, 8=edu.miami.cs.www/home/vjm/csc220/google/white.h
    tml[11, 23, 3, 14, 7, 8, 20, 19]0.9955038697857828, 11=edu.miami.cs.www/home/vjm/csc220/google/hill.html[14, 7, 20, 23, 11, 16, 19, 0, 3]1.4185863723242051, 14=edu.mi
    ami.cs.www/home/vjm/csc220/google/water.html[0, 3, 11, 16, 23, 14]0.9624703903279223, 16=edu.miami.cs.www/home/vjm/csc220/google/lamb.html[3, 7, 0, 16, 19, 11, 8]0.82
    78041785325261, 19=edu.miami.cs.www/home/vjm/csc220/google/jack.html[11, 0, 19, 23, 8, 3]0.933368860757106, 20=edu.miami.cs.www/home/vjm/csc220/google/fleece.html[0,
    19, 11, 3, 14, 16, 23]0.7353504394675591, 23=edu.miami.cs.www/home/vjm/csc220/google/little.html[19, 0, 8, 11, 7, 3, 20, 14]1.0278877429002757}
    map from word to word index
    {hill=0, white=7, snow=16, fleece=3, lamb=11, mary=20, water=14, jack=8, jill=19, little=23}
    map from word index to word file
    {0=hill[0, 7, 8, 11, 16, 20]0.0, 3=fleece[0, 3, 7, 14, 16, 19, 20, 23]0.0, 7=white[0, 3, 7, 16, 20, 23]0.0, 8=jack[0, 3, 8, 11, 14, 19, 20, 23]0.0, 11=lamb[0, 3, 7, 8
    , 14, 16, 23]0.0, 14=water[0, 3, 8, 11, 14, 16, 19, 23]0.0, 16=snow[3, 7, 8, 11, 14, 16, 19, 23]0.0, 19=jill[3, 7, 14, 16, 20]0.0, 20=mary[3, 7, 8, 11, 14, 16, 23]0.0
    , 23=little[8, 19, 20]0.0}
    Match found: edu.miami.cs.www/home/vjm/csc220/google/snow.html Impact: 1.093780592478426
    Match found: edu.miami.cs.www/home/vjm/csc220/google/water.html Impact: 0.9624703903279223
    Found [mary, jack, jill] on
    http://www.cs.miami.edu/home/vjm/csc220/google/snow.html
    http://www.cs.miami.edu/home/vjm/csc220/google/water.html
    ```

#### **COMPLEX OUTPUT**:

    `Rank.java`:

    ```
    map from URL to page index
    {edu.miami.cs.www/home/vjm/csc220/google2/1.html=0, edu.miami.cs.www/home/vjm/csc220/google2/10.html=23, edu.miami.cs.www/home/vjm/csc220/google2/11.html=27, edu.miam
    i.cs.www/home/vjm/csc220/google2/12.html=29, edu.miami.cs.www/home/vjm/csc220/google2/13.html=31, edu.miami.cs.www/home/vjm/csc220/google2/14.html=33, edu.miami.cs.ww
    w/home/vjm/csc220/google2/15.html=36, edu.miami.cs.www/home/vjm/csc220/google2/16.html=40, edu.miami.cs.www/home/vjm/csc220/google2/17.html=44, edu.miami.cs.www/home/
    vjm/csc220/google2/18.html=48, edu.miami.cs.www/home/vjm/csc220/google2/19.html=49, edu.miami.cs.www/home/vjm/csc220/google2/2.html=3, edu.miami.cs.www/home/vjm/csc22
    0/google2/20.html=53, edu.miami.cs.www/home/vjm/csc220/google2/21.html=54, edu.miami.cs.www/home/vjm/csc220/google2/22.html=56, edu.miami.cs.www/home/vjm/csc220/googl
    e2/23.html=58, edu.miami.cs.www/home/vjm/csc220/google2/24.html=59, edu.miami.cs.www/home/vjm/csc220/google2/25.html=61, edu.miami.cs.www/home/vjm/csc220/google2/26.h
    tml=62, edu.miami.cs.www/home/vjm/csc220/google2/27.html=65, edu.miami.cs.www/home/vjm/csc220/google2/28.html=66, edu.miami.cs.www/home/vjm/csc220/google2/29.html=67,
     edu.miami.cs.www/home/vjm/csc220/google2/3.html=7, edu.miami.cs.www/home/vjm/csc220/google2/30.html=70, edu.miami.cs.www/home/vjm/csc220/google2/31.html=71, edu.miam
    i.cs.www/home/vjm/csc220/google2/32.html=75, edu.miami.cs.www/home/vjm/csc220/google2/33.html=78, edu.miami.cs.www/home/vjm/csc220/google2/34.html=79, edu.miami.cs.ww
    w/home/vjm/csc220/google2/35.html=81, edu.miami.cs.www/home/vjm/csc220/google2/36.html=84, edu.miami.cs.www/home/vjm/csc220/google2/37.html=86, edu.miami.cs.www/home/
    vjm/csc220/google2/38.html=88, edu.miami.cs.www/home/vjm/csc220/google2/39.html=89, edu.miami.cs.www/home/vjm/csc220/google2/4.html=8, edu.miami.cs.www/home/vjm/csc22
    0/google2/40.html=93, edu.miami.cs.www/home/vjm/csc220/google2/41.html=97, edu.miami.cs.www/home/vjm/csc220/google2/42.html=101, edu.miami.cs.www/home/vjm/csc220/goog
    le2/43.html=104, edu.miami.cs.www/home/vjm/csc220/google2/44.html=106, edu.miami.cs.www/home/vjm/csc220/google2/45.html=110, edu.miami.cs.www/home/vjm/csc220/google2/
    46.html=113, edu.miami.cs.www/home/vjm/csc220/google2/47.html=117, edu.miami.cs.www/home/vjm/csc220/google2/48.html=120, edu.miami.cs.www/home/vjm/csc220/google2/49.h
    tml=123, edu.miami.cs.www/home/vjm/csc220/google2/5.html=11, edu.miami.cs.www/home/vjm/csc220/google2/50.html=127, edu.miami.cs.www/home/vjm/csc220/google2/51.html=12
    8, edu.miami.cs.www/home/vjm/csc220/google2/52.html=132, edu.miami.cs.www/home/vjm/csc220/google2/53.html=134, edu.miami.cs.www/home/vjm/csc220/google2/54.html=137, e
    du.miami.cs.www/home/vjm/csc220/google2/55.html=140, edu.miami.cs.www/home/vjm/csc220/google2/56.html=144, edu.miami.cs.www/home/vjm/csc220/google2/57.html=148, edu.m
    iami.cs.www/home/vjm/csc220/google2/58.html=149, edu.miami.cs.www/home/vjm/csc220/google2/59.html=152, edu.miami.cs.www/home/vjm/csc220/google2/6.html=14, edu.miami.c
    s.www/home/vjm/csc220/google2/60.html=153, edu.miami.cs.www/home/vjm/csc220/google2/61.html=154, edu.miami.cs.www/home/vjm/csc220/google2/62.html=158, edu.miami.cs.ww
    w/home/vjm/csc220/google2/63.html=160, edu.miami.cs.www/home/vjm/csc220/google2/64.html=163, edu.miami.cs.www/home/vjm/csc220/google2/65.html=166, edu.miami.cs.www/ho
    me/vjm/csc220/google2/66.html=169, edu.miami.cs.www/home/vjm/csc220/google2/67.html=170, edu.miami.cs.www/home/vjm/csc220/google2/68.html=171, edu.miami.cs.www/home/v
    jm/csc220/google2/69.html=173, edu.miami.cs.www/home/vjm/csc220/google2/7.html=16, edu.miami.cs.www/home/vjm/csc220/google2/70.html=175, edu.miami.cs.www/home/vjm/csc
    220/google2/71.html=177, edu.miami.cs.www/home/vjm/csc220/google2/72.html=178, edu.miami.cs.www/home/vjm/csc220/google2/73.html=181, edu.miami.cs.www/home/vjm/csc220/
    google2/74.html=182, edu.miami.cs.www/home/vjm/csc220/google2/75.html=185, edu.miami.cs.www/home/vjm/csc220/google2/76.html=187, edu.miami.cs.www/home/vjm/csc220/goog
    le2/77.html=191, edu.miami.cs.www/home/vjm/csc220/google2/78.html=193, edu.miami.cs.www/home/vjm/csc220/google2/79.html=196, edu.miami.cs.www/home/vjm/csc220/google2/
    8.html=19, edu.miami.cs.www/home/vjm/csc220/google2/80.html=200, edu.miami.cs.www/home/vjm/csc220/google2/81.html=204, edu.miami.cs.www/home/vjm/csc220/google2/82.htm
    l=208, edu.miami.cs.www/home/vjm/csc220/google2/83.html=211, edu.miami.cs.www/home/vjm/csc220/google2/84.html=215, edu.miami.cs.www/home/vjm/csc220/google2/85.html=21
    8, edu.miami.cs.www/home/vjm/csc220/google2/86.html=221, edu.miami.cs.www/home/vjm/csc220/google2/87.html=222, edu.miami.cs.www/home/vjm/csc220/google2/88.html=223, e
    du.miami.cs.www/home/vjm/csc220/google2/89.html=225, edu.miami.cs.www/home/vjm/csc220/google2/9.html=20, edu.miami.cs.www/home/vjm/csc220/google2/90.html=226, edu.mia
    mi.cs.www/home/vjm/csc220/google2/91.html=227, edu.miami.cs.www/home/vjm/csc220/google2/92.html=231, edu.miami.cs.www/home/vjm/csc220/google2/93.html=232, edu.miami.c
    s.www/home/vjm/csc220/google2/94.html=233, edu.miami.cs.www/home/vjm/csc220/google2/95.html=235, edu.miami.cs.www/home/vjm/csc220/google2/96.html=238, edu.miami.cs.ww
    w/home/vjm/csc220/google2/97.html=240, edu.miami.cs.www/home/vjm/csc220/google2/98.html=244, edu.miami.cs.www/home/vjm/csc220/google2/99.html=248}
    map from page index to page disk
    {0=edu.miami.cs.www/home/vjm/csc220/google2/1.html[3, 7, 8, 11, 14, 16, 19, 20, 23, 27, 29, 31, 33, 36, 40, 44, 48, 49, 53, 54, 56, 58, 59, 61, 62, 65, 66, 67, 70, 71
    , 75, 78, 79, 81, 84, 86, 88, 89, 93, 97, 101, 104, 106, 110, 113, 117, 120, 123, 127, 128, 132, 134, 137, 140, 144, 148, 149, 152, 153, 154, 158, 160, 163, 166, 169,
     170, 171, 173, 175, 177, 178, 181, 182, 185, 187, 191, 193, 196, 200, 204, 208, 211, 215, 218, 221, 222, 223, 225, 226, 227, 231, 232, 233, 235, 238, 240, 244]0.0, 3
    =edu.miami.cs.www/home/vjm/csc220/google2/2.html[8, 14, 19, 23, 29, 33, 40, 48, 53, 56, 59, 62, 66, 70, 75, 79, 84, 88, 93, 101, 106, 113, 120, 127, 132, 137, 144, 14
    9, 153, 158, 163, 169, 171, 175, 178, 182, 187, 193, 200, 208, 215, 221, 223, 226, 231, 233, 238, 244]0.0, 7=edu.miami.cs.www/home/vjm/csc220/google2/3.html[14, 20, 2
    9, 36, 48, 54, 59, 65, 70, 78, 84, 89, 101, 110, 120, 128, 137, 148, 153, 160, 169, 173, 178, 185, 193, 204, 215, 222, 226, 232, 238, 248]0.0, 8=edu.miami.cs.www/home
    /vjm/csc220/google2/4.html[19, 29, 40, 53, 59, 66, 75, 84, 93, 106, 120, 132, 144, 153, 163, 171, 178, 187, 200, 215, 223, 231, 238]0.0, 11=edu.miami.cs.www/home/vjm/
    csc220/google2/5.html[23, 36, 53, 61, 70, 81, 93, 110, 127, 140, 153, 166, 175, 185, 200, 218, 226, 235]0.0, 14=edu.miami.cs.www/home/vjm/csc220/google2/6.html[29, 48
    , 59, 70, 84, 101, 120, 137, 153, 169, 178, 193, 215, 226, 238]0.0, 16=edu.miami.cs.www/home/vjm/csc220/google2/7.html[33, 54, 66, 81, 101, 123, 144, 160, 175, 191, 2
    15, 227, 244]0.0, 19=edu.miami.cs.www/home/vjm/csc220/google2/8.html[40, 59, 75, 93, 120, 144, 163, 178, 200, 223, 238]0.0, 20=edu.miami.cs.www/home/vjm/csc220/google
    2/9.html[48, 65, 84, 110, 137, 160, 178, 204, 226, 248]0.0, 23=edu.miami.cs.www/home/vjm/csc220/google2/10.html[53, 70, 93, 127, 153, 175, 200, 226]0.0, 27=edu.miami.
    cs.www/home/vjm/csc220/google2/11.html[56, 78, 106, 140, 169, 191, 223, 248]0.0, 29=edu.miami.cs.www/home/vjm/csc220/google2/12.html[59, 84, 120, 153, 178, 215, 238]0
    .0, 31=edu.miami.cs.www/home/vjm/csc220/google2/13.html[62, 89, 132, 166, 193, 227]0.0, 33=edu.miami.cs.www/home/vjm/csc220/google2/14.html[66, 101, 144, 175, 215, 24
    4]0.0, 36=edu.miami.cs.www/home/vjm/csc220/google2/15.html[70, 110, 153, 185, 226]0.0, 40=edu.miami.cs.www/home/vjm/csc220/google2/16.html[75, 120, 163, 200, 238]0.0,
     44=edu.miami.cs.www/home/vjm/csc220/google2/17.html[79, 128, 171, 218]0.0, 48=edu.miami.cs.www/home/vjm/csc220/google2/18.html[84, 137, 178, 226]0.0, 49=edu.miami.cs
    .www/home/vjm/csc220/google2/19.html[88, 148, 187, 235]0.0, 53=edu.miami.cs.www/home/vjm/csc220/google2/20.html[93, 153, 200]0.0, 54=edu.miami.cs.www/home/vjm/csc220/
    google2/21.html[101, 160, 215]0.0, 56=edu.miami.cs.www/home/vjm/csc220/google2/22.html[106, 169, 223]0.0, 58=edu.miami.cs.www/home/vjm/csc220/google2/23.html[113, 173
    , 231]0.0, 59=edu.miami.cs.www/home/vjm/csc220/google2/24.html[120, 178, 238]0.0, 61=edu.miami.cs.www/home/vjm/csc220/google2/25.html[127, 185]0.0, 62=edu.miami.cs.ww
    w/home/vjm/csc220/google2/26.html[132, 193]0.0, 65=edu.miami.cs.www/home/vjm/csc220/google2/27.html[137, 204]0.0, 66=edu.miami.cs.www/home/vjm/csc220/google2/28.html[
    144, 215]0.0, 67=edu.miami.cs.www/home/vjm/csc220/google2/29.html[149, 222]0.0, 70=edu.miami.cs.www/home/vjm/csc220/google2/30.html[153, 226]0.0, 71=edu.miami.cs.www/
    home/vjm/csc220/google2/31.html[158, 232]0.0, 75=edu.miami.cs.www/home/vjm/csc220/google2/32.html[163, 238]0.0, 78=edu.miami.cs.www/home/vjm/csc220/google2/33.html[16
    9, 248]0.0, 79=edu.miami.cs.www/home/vjm/csc220/google2/34.html[171]0.0, 81=edu.miami.cs.www/home/vjm/csc220/google2/35.html[175]0.0, 84=edu.miami.cs.www/home/vjm/csc
    220/google2/36.html[178]0.0, 86=edu.miami.cs.www/home/vjm/csc220/google2/37.html[182]0.0, 88=edu.miami.cs.www/home/vjm/csc220/google2/38.html[187]0.0, 89=edu.miami.cs
    .www/home/vjm/csc220/google2/39.html[193]0.0, 93=edu.miami.cs.www/home/vjm/csc220/google2/40.html[200]0.0, 97=edu.miami.cs.www/home/vjm/csc220/google2/41.html[208]0.0
    , 101=edu.miami.cs.www/home/vjm/csc220/google2/42.html[215]0.0, 104=edu.miami.cs.www/home/vjm/csc220/google2/43.html[221]0.0, 106=edu.miami.cs.www/home/vjm/csc220/goo
    gle2/44.html[223]0.0, 110=edu.miami.cs.www/home/vjm/csc220/google2/45.html[226]0.0, 113=edu.miami.cs.www/home/vjm/csc220/google2/46.html[231]0.0, 117=edu.miami.cs.www
    /home/vjm/csc220/google2/47.html[233]0.0, 120=edu.miami.cs.www/home/vjm/csc220/google2/48.html[238]0.0, 123=edu.miami.cs.www/home/vjm/csc220/google2/49.html[244]0.0,
    127=edu.miami.cs.www/home/vjm/csc220/google2/50.html[]0.0, 128=edu.miami.cs.www/home/vjm/csc220/google2/51.html[]0.0, 132=edu.miami.cs.www/home/vjm/csc220/google2/52.
    html[]0.0, 134=edu.miami.cs.www/home/vjm/csc220/google2/53.html[]0.0, 137=edu.miami.cs.www/home/vjm/csc220/google2/54.html[]0.0, 140=edu.miami.cs.www/home/vjm/csc220/
    google2/55.html[]0.0, 144=edu.miami.cs.www/home/vjm/csc220/google2/56.html[]0.0, 148=edu.miami.cs.www/home/vjm/csc220/google2/57.html[]0.0, 149=edu.miami.cs.www/home/
    vjm/csc220/google2/58.html[]0.0, 152=edu.miami.cs.www/home/vjm/csc220/google2/59.html[]0.0, 153=edu.miami.cs.www/home/vjm/csc220/google2/60.html[]0.0, 154=edu.miami.c
    s.www/home/vjm/csc220/google2/61.html[]0.0, 158=edu.miami.cs.www/home/vjm/csc220/google2/62.html[]0.0, 160=edu.miami.cs.www/home/vjm/csc220/google2/63.html[]0.0, 163=
    edu.miami.cs.www/home/vjm/csc220/google2/64.html[]0.0, 166=edu.miami.cs.www/home/vjm/csc220/google2/65.html[]0.0, 169=edu.miami.cs.www/home/vjm/csc220/google2/66.html
    []0.0, 170=edu.miami.cs.www/home/vjm/csc220/google2/67.html[]0.0, 171=edu.miami.cs.www/home/vjm/csc220/google2/68.html[]0.0, 173=edu.miami.cs.www/home/vjm/csc220/goog
    le2/69.html[]0.0, 175=edu.miami.cs.www/home/vjm/csc220/google2/70.html[]0.0, 177=edu.miami.cs.www/home/vjm/csc220/google2/71.html[]0.0, 178=edu.miami.cs.www/home/vjm/
    csc220/google2/72.html[]0.0, 181=edu.miami.cs.www/home/vjm/csc220/google2/73.html[]0.0, 182=edu.miami.cs.www/home/vjm/csc220/google2/74.html[]0.0, 185=edu.miami.cs.ww
    w/home/vjm/csc220/google2/75.html[]0.0, 187=edu.miami.cs.www/home/vjm/csc220/google2/76.html[]0.0, 191=edu.miami.cs.www/home/vjm/csc220/google2/77.html[]0.0, 193=edu.
    miami.cs.www/home/vjm/csc220/google2/78.html[]0.0, 196=edu.miami.cs.www/home/vjm/csc220/google2/79.html[]0.0, 200=edu.miami.cs.www/home/vjm/csc220/google2/80.html[]0.
    0, 204=edu.miami.cs.www/home/vjm/csc220/google2/81.html[]0.0, 208=edu.miami.cs.www/home/vjm/csc220/google2/82.html[]0.0, 211=edu.miami.cs.www/home/vjm/csc220/google2/
    83.html[]0.0, 215=edu.miami.cs.www/home/vjm/csc220/google2/84.html[]0.0, 218=edu.miami.cs.www/home/vjm/csc220/google2/85.html[]0.0, 221=edu.miami.cs.www/home/vjm/csc2
    20/google2/86.html[]0.0, 222=edu.miami.cs.www/home/vjm/csc220/google2/87.html[]0.0, 223=edu.miami.cs.www/home/vjm/csc220/google2/88.html[]0.0, 225=edu.miami.cs.www/ho
    me/vjm/csc220/google2/89.html[]0.0, 226=edu.miami.cs.www/home/vjm/csc220/google2/90.html[]0.0, 227=edu.miami.cs.www/home/vjm/csc220/google2/91.html[]0.0, 231=edu.miam
    i.cs.www/home/vjm/csc220/google2/92.html[]0.0, 232=edu.miami.cs.www/home/vjm/csc220/google2/93.html[]0.0, 233=edu.miami.cs.www/home/vjm/csc220/google2/94.html[]0.0, 2
    35=edu.miami.cs.www/home/vjm/csc220/google2/95.html[]0.0, 238=edu.miami.cs.www/home/vjm/csc220/google2/96.html[]0.0, 240=edu.miami.cs.www/home/vjm/csc220/google2/97.h
    tml[]0.0, 244=edu.miami.cs.www/home/vjm/csc220/google2/98.html[]0.0, 248=edu.miami.cs.www/home/vjm/csc220/google2/99.html[]0.0}
    map from word to word index
    {88=223, 89=225, 90=226, 91=227, 92=231, 93=232, 94=233, 95=235, 96=238, 97=240, 10=23, 98=244, 11=27, 99=248, 12=29, 13=31, 14=33, 15=36, 16=40, 17=44, 18=48, 19=49,
     1=0, 2=3, 3=7, 4=8, 5=11, 6=14, 7=16, 8=19, 9=20, 20=53, 21=54, 22=56, 23=58, 24=59, 25=61, 26=62, 27=65, 28=66, 29=67, 30=70, 31=71, 32=75, 33=78, 34=79, 35=81, 36=
    84, 37=86, 38=88, 39=89, 40=93, 41=97, 42=101, 43=104, 44=106, 45=110, 46=113, 47=117, 48=120, 49=123, 50=127, 51=128, 52=132, 53=134, 54=137, 55=140, 56=144, 57=148,
     58=149, 59=152, 60=153, 61=154, 62=158, 63=160, 64=163, 65=166, 66=169, 67=170, 68=171, 69=173, 70=175, 71=177, 72=178, 73=181, 74=182, 75=185, 76=187, 77=191, 78=19
    3, 79=196, 80=200, 81=204, 82=208, 83=211, 84=215, 85=218, 86=221, 87=222}
    map from word index to word file
    {0=1[0, 3, 7, 8, 11, 14, 16, 19, 20, 23, 27, 29, 31, 33, 36, 40, 44, 48, 49, 53, 54, 56, 58, 59, 61, 62, 65, 66, 67, 70, 71, 75, 78, 79, 81, 84, 86, 88, 89, 93, 97, 1
    01, 104, 106, 110, 113, 117, 120, 123, 127, 128, 132, 134, 137, 140, 144, 148, 149, 152, 153, 154, 158, 160, 163, 166, 169, 170, 171, 173, 175, 177, 178, 181, 182, 18
    5, 187, 191, 193, 196, 200, 204, 208, 211, 215, 218, 221, 222, 223, 225, 226, 227, 231, 232, 233, 235, 238, 240, 244, 248]0.0, 3=2[3, 8, 14, 19, 23, 29, 33, 40, 48, 5
    3, 56, 59, 62, 66, 70, 75, 79, 84, 88, 93, 101, 106, 113, 120, 127, 132, 137, 144, 149, 153, 158, 163, 169, 171, 175, 178, 182, 187, 193, 200, 208, 215, 221, 223, 226
    , 231, 233, 238, 244]0.0, 7=3[7, 14, 20, 29, 36, 48, 54, 59, 65, 70, 78, 84, 89, 101, 110, 120, 128, 137, 148, 153, 160, 169, 173, 178, 185, 193, 204, 215, 222, 226,
    232, 238, 248]0.0, 8=4[8, 19, 29, 40, 53, 59, 66, 75, 84, 93, 106, 120, 132, 144, 153, 163, 171, 178, 187, 200, 215, 223, 231, 238]0.0, 11=5[11, 23, 36, 53, 61, 70, 8
    1, 93, 110, 127, 140, 153, 166, 175, 185, 200, 218, 226, 235]0.0, 14=6[14, 29, 48, 59, 70, 84, 101, 120, 137, 153, 169, 178, 193, 215, 226, 238]0.0, 16=7[16, 33, 54,
    66, 81, 101, 123, 144, 160, 175, 191, 215, 227, 244]0.0, 19=8[19, 40, 59, 75, 93, 120, 144, 163, 178, 200, 223, 238]0.0, 20=9[20, 48, 65, 84, 110, 137, 160, 178, 204,
     226, 248]0.0, 23=10[23, 53, 70, 93, 127, 153, 175, 200, 226]0.0, 27=11[27, 56, 78, 106, 140, 169, 191, 223, 248]0.0, 29=12[29, 59, 84, 120, 153, 178, 215, 238]0.0, 3
    1=13[31, 62, 89, 132, 166, 193, 227]0.0, 33=14[33, 66, 101, 144, 175, 215, 244]0.0, 36=15[36, 70, 110, 153, 185, 226]0.0, 40=16[40, 75, 120, 163, 200, 238]0.0, 44=17[
    44, 79, 128, 171, 218]0.0, 48=18[48, 84, 137, 178, 226]0.0, 49=19[49, 88, 148, 187, 235]0.0, 53=20[53, 93, 153, 200]0.0, 54=21[54, 101, 160, 215]0.0, 56=22[56, 106, 1
    69, 223]0.0, 58=23[58, 113, 173, 231]0.0, 59=24[59, 120, 178, 238]0.0, 61=25[61, 127, 185]0.0, 62=26[62, 132, 193]0.0, 65=27[65, 137, 204]0.0, 66=28[66, 144, 215]0.0,
     67=29[67, 149, 222]0.0, 70=30[70, 153, 226]0.0, 71=31[71, 158, 232]0.0, 75=32[75, 163, 238]0.0, 78=33[78, 169, 248]0.0, 79=34[79, 171]0.0, 81=35[81, 175]0.0, 84=36[8
    4, 178]0.0, 86=37[86, 182]0.0, 88=38[88, 187]0.0, 89=39[89, 193]0.0, 93=40[93, 200]0.0, 97=41[97, 208]0.0, 101=42[101, 215]0.0, 104=43[104, 221]0.0, 106=44[106, 223]0
    .0, 110=45[110, 226]0.0, 113=46[113, 231]0.0, 117=47[117, 233]0.0, 120=48[120, 238]0.0, 123=49[123, 244]0.0, 127=50[127]0.0, 128=51[128]0.0, 132=52[132]0.0, 134=53[13
    4]0.0, 137=54[137]0.0, 140=55[140]0.0, 144=56[144]0.0, 148=57[148]0.0, 149=58[149]0.0, 152=59[152]0.0, 153=60[153]0.0, 154=61[154]0.0, 158=62[158]0.0, 160=63[160]0.0,
     163=64[163]0.0, 166=65[166]0.0, 169=66[169]0.0, 170=67[170]0.0, 171=68[171]0.0, 173=69[173]0.0, 175=70[175]0.0, 177=71[177]0.0, 178=72[178]0.0, 181=73[181]0.0, 182=7
    4[182]0.0, 185=75[185]0.0, 187=76[187]0.0, 191=77[191]0.0, 193=78[193]0.0, 196=79[196]0.0, 200=80[200]0.0, 204=81[204]0.0, 208=82[208]0.0, 211=83[211]0.0, 215=84[215]
    0.0, 218=85[218]0.0, 221=86[221]0.0, 222=87[222]0.0, 223=88[223]0.0, 225=89[225]0.0, 226=90[226]0.0, 227=91[227]0.0, 231=92[231]0.0, 232=93[232]0.0, 233=94[233]0.0, 2
    35=95[235]0.0, 238=96[238]0.0, 240=97[240]0.0, 244=98[244]0.0, 248=99[248]0.0}
    page disk after slow rank
    edu.miami.cs.www/home/vjm/csc220/google2/1.html[3, 7, 8, 11, 14, 16, 19, 20, 23, 27, 29, 31, 33, 36, 40, 44, 48, 49, 53, 54, 56, 58, 59, 61, 62, 65, 66, 67, 70, 71, 7
    5, 78, 79, 81, 84, 86, 88, 89, 93, 97, 101, 104, 106, 110, 113, 117, 120, 123, 127, 128, 132, 134, 137, 140, 144, 148, 149, 152, 153, 154, 158, 160, 163, 166, 169, 17
    0, 171, 173, 175, 177, 178, 181, 182, 185, 187, 191, 193, 196, 200, 204, 208, 211, 215, 218, 221, 222, 223, 225, 226, 227, 231, 232, 233, 235, 238, 240, 244]0.6266416
    369068927
    edu.miami.cs.www/home/vjm/csc220/google2/2.html[8, 14, 19, 23, 29, 33, 40, 48, 53, 56, 59, 62, 66, 70, 75, 79, 84, 88, 93, 101, 106, 113, 120, 127, 132, 137, 144, 149
    , 153, 158, 163, 169, 171, 175, 178, 182, 187, 193, 200, 208, 215, 221, 223, 226, 231, 233, 238, 244]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/3.html[14, 20, 29, 36, 48, 54, 59, 65, 70, 78, 84, 89, 101, 110, 120, 128, 137, 148, 153, 160, 169, 173, 178, 185, 193, 204,
    215, 222, 226, 232, 238, 248]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/4.html[19, 29, 40, 53, 59, 66, 75, 84, 93, 106, 120, 132, 144, 153, 163, 171, 178, 187, 200, 215, 223, 231, 238]0.64629148205
    04498
    edu.miami.cs.www/home/vjm/csc220/google2/5.html[23, 36, 53, 61, 70, 81, 93, 110, 127, 140, 153, 166, 175, 185, 200, 218, 226, 235]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/6.html[29, 48, 59, 70, 84, 101, 120, 137, 153, 169, 178, 193, 215, 226, 238]0.6660759151744422
    edu.miami.cs.www/home/vjm/csc220/google2/7.html[33, 54, 66, 81, 101, 123, 144, 160, 175, 191, 215, 227, 244]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/8.html[40, 59, 75, 93, 120, 144, 163, 178, 200, 223, 238]0.674391111704816
    edu.miami.cs.www/home/vjm/csc220/google2/9.html[48, 65, 84, 110, 137, 160, 178, 204, 226, 248]0.6528862930917806
    edu.miami.cs.www/home/vjm/csc220/google2/10.html[53, 70, 93, 127, 153, 175, 200, 226]0.6814638076042142
    edu.miami.cs.www/home/vjm/csc220/google2/11.html[56, 78, 106, 140, 169, 191, 223, 248]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/12.html[59, 84, 120, 153, 178, 215, 238]0.7385806058404365
    edu.miami.cs.www/home/vjm/csc220/google2/13.html[62, 89, 132, 166, 193, 227]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/14.html[66, 101, 144, 175, 215, 244]0.6949916251248928
    edu.miami.cs.www/home/vjm/csc220/google2/15.html[70, 110, 153, 185, 226]0.688058618645545
    edu.miami.cs.www/home/vjm/csc220/google2/16.html[75, 120, 163, 200, 238]0.7356993945870702
    edu.miami.cs.www/home/vjm/csc220/google2/17.html[79, 128, 171, 218]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/18.html[84, 137, 178, 226]0.7757696054952459
    edu.miami.cs.www/home/vjm/csc220/google2/19.html[88, 148, 187, 235]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/20.html[93, 153, 200]0.794746413209105
    edu.miami.cs.www/home/vjm/csc220/google2/21.html[101, 160, 215]0.7015864361662236
    edu.miami.cs.www/home/vjm/csc220/google2/22.html[106, 169, 223]0.7254292145464196
    edu.miami.cs.www/home/vjm/csc220/google2/23.html[113, 173, 231]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/24.html[120, 178, 238]0.905400403842752
    edu.miami.cs.www/home/vjm/csc220/google2/25.html[127, 185]0.6682741855215525
    edu.miami.cs.www/home/vjm/csc220/google2/26.html[132, 193]0.751808458711743
    edu.miami.cs.www/home/vjm/csc220/google2/27.html[137, 204]0.7181749224009562
    edu.miami.cs.www/home/vjm/csc220/google2/28.html[144, 215]0.8389231923000721
    edu.miami.cs.www/home/vjm/csc220/google2/29.html[149, 222]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/30.html[153, 226]0.968448001419465
    edu.miami.cs.www/home/vjm/csc220/google2/31.html[158, 232]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/32.html[163, 238]0.8828392735044822
    edu.miami.cs.www/home/vjm/csc220/google2/33.html[169, 248]0.7320240255877505
    edu.miami.cs.www/home/vjm/csc220/google2/34.html[171]0.8045669470423895
    edu.miami.cs.www/home/vjm/csc220/google2/35.html[175]0.7169743285959955
    edu.miami.cs.www/home/vjm/csc220/google2/36.html[178]1.1033231516434847
    edu.miami.cs.www/home/vjm/csc220/google2/37.html[182]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/38.html[187]0.8045669470423895
    edu.miami.cs.www/home/vjm/csc220/google2/39.html[193]0.7584032697530738
    edu.miami.cs.www/home/vjm/csc220/google2/40.html[200]1.120970167161061
    edu.miami.cs.www/home/vjm/csc220/google2/41.html[208]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/42.html[215]1.1088752021700632
    edu.miami.cs.www/home/vjm/csc220/google2/43.html[221]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/44.html[223]0.9953385823829233
    edu.miami.cs.www/home/vjm/csc220/google2/45.html[226]0.8909589716838263
    edu.miami.cs.www/home/vjm/csc220/google2/46.html[231]0.8573254353730361
    edu.miami.cs.www/home/vjm/csc220/google2/47.html[233]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/48.html[238]1.3543404173744182
    edu.miami.cs.www/home/vjm/csc220/google2/49.html[244]0.6818020030422312
    edu.miami.cs.www/home/vjm/csc220/google2/50.html[]1.1007838763155045
    edu.miami.cs.www/home/vjm/csc220/google2/51.html[]0.8111617580837203
    edu.miami.cs.www/home/vjm/csc220/google2/52.html[]1.1558123177219801
    edu.miami.cs.www/home/vjm/csc220/google2/53.html[]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/54.html[]1.3287994680695294
    edu.miami.cs.www/home/vjm/csc220/google2/55.html[]0.7474119180175224
    edu.miami.cs.www/home/vjm/csc220/google2/56.html[]1.3196930713323654
    edu.miami.cs.www/home/vjm/csc220/google2/57.html[]0.8111617580837203
    edu.miami.cs.www/home/vjm/csc220/google2/58.html[]0.9628424120343292
    edu.miami.cs.www/home/vjm/csc220/google2/59.html[]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/60.html[]1.8511986179733402
    edu.miami.cs.www/home/vjm/csc220/google2/61.html[]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/62.html[]0.9628424120343292
    edu.miami.cs.www/home/vjm/csc220/google2/63.html[]1.000737210864136
    edu.miami.cs.www/home/vjm/csc220/google2/64.html[]1.3242589102567246
    edu.miami.cs.www/home/vjm/csc220/google2/65.html[]0.7737911621828457
    edu.miami.cs.www/home/vjm/csc220/google2/66.html[]1.3974404596580499
    edu.miami.cs.www/home/vjm/csc220/google2/67.html[]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/68.html[]1.6372335237391566
    edu.miami.cs.www/home/vjm/csc220/google2/69.html[]0.8639202464143669
    edu.miami.cs.www/home/vjm/csc220/google2/70.html[]1.6481531927459812
    edu.miami.cs.www/home/vjm/csc220/google2/71.html[]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/72.html[]2.569754720783497
    edu.miami.cs.www/home/vjm/csc220/google2/73.html[]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/74.html[]1.2793933420182086
    edu.miami.cs.www/home/vjm/csc220/google2/75.html[]1.1598074351354164
    edu.miami.cs.www/home/vjm/csc220/google2/76.html[]1.6372335237391566
    edu.miami.cs.www/home/vjm/csc220/google2/77.html[]0.760939735538201
    edu.miami.cs.www/home/vjm/csc220/google2/78.html[]1.9503054519563086
    edu.miami.cs.www/home/vjm/csc220/google2/79.html[]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/80.html[]2.38908021323955
    edu.miami.cs.www/home/vjm/csc220/google2/81.html[]1.0772623836014286
    edu.miami.cs.www/home/vjm/csc220/google2/82.html[]1.2793933420182086
    edu.miami.cs.www/home/vjm/csc220/google2/83.html[]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/84.html[]2.7708231452646324
    edu.miami.cs.www/home/vjm/csc220/google2/85.html[]0.8265496505134923
    edu.miami.cs.www/home/vjm/csc220/google2/86.html[]1.2793933420182086
    edu.miami.cs.www/home/vjm/csc220/google2/87.html[]0.96943722307566
    edu.miami.cs.www/home/vjm/csc220/google2/88.html[]2.0519854476481183
    edu.miami.cs.www/home/vjm/csc220/google2/89.html[]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/90.html[]2.6028620044960395
    edu.miami.cs.www/home/vjm/csc220/google2/91.html[]0.7873189797035243
    edu.miami.cs.www/home/vjm/csc220/google2/92.html[]1.7427505004004624
    edu.miami.cs.www/home/vjm/csc220/google2/93.html[]0.96943722307566
    edu.miami.cs.www/home/vjm/csc220/google2/94.html[]1.2793933420182086
    edu.miami.cs.www/home/vjm/csc220/google2/95.html[]0.8265496505134923
    edu.miami.cs.www/home/vjm/csc220/google2/96.html[]3.15010047150109
    edu.miami.cs.www/home/vjm/csc220/google2/97.html[]0.6331018599677881
    edu.miami.cs.www/home/vjm/csc220/google2/98.html[]1.492625565687919
    edu.miami.cs.www/home/vjm/csc220/google2/99.html[]1.1568644446299028
    page disk after fast rank
    edu.miami.cs.www/home/vjm/csc220/google2/1.html[3, 7, 8, 11, 14, 16, 19, 20, 23, 27, 29, 31, 33, 36, 40, 44, 48, 49, 53, 54, 56, 58, 59, 61, 62, 65, 66, 67, 70, 71, 7
    5, 78, 79, 81, 84, 86, 88, 89, 93, 97, 101, 104, 106, 110, 113, 117, 120, 123, 127, 128, 132, 134, 137, 140, 144, 148, 149, 152, 153, 154, 158, 160, 163, 166, 169, 17
    0, 171, 173, 175, 177, 178, 181, 182, 185, 187, 191, 193, 196, 200, 204, 208, 211, 215, 218, 221, 222, 223, 225, 226, 227, 231, 232, 233, 235, 238, 240, 244]0.6266416
    369068936
    edu.miami.cs.www/home/vjm/csc220/google2/2.html[8, 14, 19, 23, 29, 33, 40, 48, 53, 56, 59, 62, 66, 70, 75, 79, 84, 88, 93, 101, 106, 113, 120, 127, 132, 137, 144, 149
    , 153, 158, 163, 169, 171, 175, 178, 182, 187, 193, 200, 208, 215, 221, 223, 226, 231, 233, 238, 244]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/3.html[14, 20, 29, 36, 48, 54, 59, 65, 70, 78, 84, 89, 101, 110, 120, 128, 137, 148, 153, 160, 169, 173, 178, 185, 193, 204,
    215, 222, 226, 232, 238, 248]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/4.html[19, 29, 40, 53, 59, 66, 75, 84, 93, 106, 120, 132, 144, 153, 163, 171, 178, 187, 200, 215, 223, 231, 238]0.64629148205
    04506
    edu.miami.cs.www/home/vjm/csc220/google2/5.html[23, 36, 53, 61, 70, 81, 93, 110, 127, 140, 153, 166, 175, 185, 200, 218, 226, 235]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/6.html[29, 48, 59, 70, 84, 101, 120, 137, 153, 169, 178, 193, 215, 226, 238]0.6660759151744431
    edu.miami.cs.www/home/vjm/csc220/google2/7.html[33, 54, 66, 81, 101, 123, 144, 160, 175, 191, 215, 227, 244]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/8.html[40, 59, 75, 93, 120, 144, 163, 178, 200, 223, 238]0.6743911117048169
    edu.miami.cs.www/home/vjm/csc220/google2/9.html[48, 65, 84, 110, 137, 160, 178, 204, 226, 248]0.6528862930917815
    edu.miami.cs.www/home/vjm/csc220/google2/10.html[53, 70, 93, 127, 153, 175, 200, 226]0.681463807604215
    edu.miami.cs.www/home/vjm/csc220/google2/11.html[56, 78, 106, 140, 169, 191, 223, 248]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/12.html[59, 84, 120, 153, 178, 215, 238]0.7385806058404375
    edu.miami.cs.www/home/vjm/csc220/google2/13.html[62, 89, 132, 166, 193, 227]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/14.html[66, 101, 144, 175, 215, 244]0.6949916251248937
    edu.miami.cs.www/home/vjm/csc220/google2/15.html[70, 110, 153, 185, 226]0.6880586186455458
    edu.miami.cs.www/home/vjm/csc220/google2/16.html[75, 120, 163, 200, 238]0.7356993945870711
    edu.miami.cs.www/home/vjm/csc220/google2/17.html[79, 128, 171, 218]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/18.html[84, 137, 178, 226]0.7757696054952469
    edu.miami.cs.www/home/vjm/csc220/google2/19.html[88, 148, 187, 235]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/20.html[93, 153, 200]0.7947464132091059
    edu.miami.cs.www/home/vjm/csc220/google2/21.html[101, 160, 215]0.7015864361662245
    edu.miami.cs.www/home/vjm/csc220/google2/22.html[106, 169, 223]0.7254292145464205
    edu.miami.cs.www/home/vjm/csc220/google2/23.html[113, 173, 231]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/24.html[120, 178, 238]0.9054004038427531
    edu.miami.cs.www/home/vjm/csc220/google2/25.html[127, 185]0.6682741855215534
    edu.miami.cs.www/home/vjm/csc220/google2/26.html[132, 193]0.7518084587117438
    edu.miami.cs.www/home/vjm/csc220/google2/27.html[137, 204]0.7181749224009571
    edu.miami.cs.www/home/vjm/csc220/google2/28.html[144, 215]0.8389231923000731
    edu.miami.cs.www/home/vjm/csc220/google2/29.html[149, 222]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/30.html[153, 226]0.9684480014194661
    edu.miami.cs.www/home/vjm/csc220/google2/31.html[158, 232]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/32.html[163, 238]0.8828392735044832
    edu.miami.cs.www/home/vjm/csc220/google2/33.html[169, 248]0.7320240255877514
    edu.miami.cs.www/home/vjm/csc220/google2/34.html[171]0.8045669470423904
    edu.miami.cs.www/home/vjm/csc220/google2/35.html[175]0.7169743285959964
    edu.miami.cs.www/home/vjm/csc220/google2/36.html[178]1.103323151643486
    edu.miami.cs.www/home/vjm/csc220/google2/37.html[182]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/38.html[187]0.8045669470423904
    edu.miami.cs.www/home/vjm/csc220/google2/39.html[193]0.7584032697530747
    edu.miami.cs.www/home/vjm/csc220/google2/40.html[200]1.1209701671610621
    edu.miami.cs.www/home/vjm/csc220/google2/41.html[208]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/42.html[215]1.1088752021700645
    edu.miami.cs.www/home/vjm/csc220/google2/43.html[221]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/44.html[223]0.9953385823829244
    edu.miami.cs.www/home/vjm/csc220/google2/45.html[226]0.8909589716838273
    edu.miami.cs.www/home/vjm/csc220/google2/46.html[231]0.8573254353730371
    edu.miami.cs.www/home/vjm/csc220/google2/47.html[233]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/48.html[238]1.3543404173744196
    edu.miami.cs.www/home/vjm/csc220/google2/49.html[244]0.681802003042232
    edu.miami.cs.www/home/vjm/csc220/google2/50.html[]1.1007838763155056
    edu.miami.cs.www/home/vjm/csc220/google2/51.html[]0.8111617580837213
    edu.miami.cs.www/home/vjm/csc220/google2/52.html[]1.1558123177219815
    edu.miami.cs.www/home/vjm/csc220/google2/53.html[]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/54.html[]1.328799468069531
    edu.miami.cs.www/home/vjm/csc220/google2/55.html[]0.7474119180175233
    edu.miami.cs.www/home/vjm/csc220/google2/56.html[]1.3196930713323667
    edu.miami.cs.www/home/vjm/csc220/google2/57.html[]0.8111617580837213
    edu.miami.cs.www/home/vjm/csc220/google2/58.html[]0.9628424120343302
    edu.miami.cs.www/home/vjm/csc220/google2/59.html[]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/60.html[]1.851198617973342
    edu.miami.cs.www/home/vjm/csc220/google2/61.html[]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/62.html[]0.9628424120343302
    edu.miami.cs.www/home/vjm/csc220/google2/63.html[]1.0007372108641372
    edu.miami.cs.www/home/vjm/csc220/google2/64.html[]1.324258910256726
    edu.miami.cs.www/home/vjm/csc220/google2/65.html[]0.7737911621828466
    edu.miami.cs.www/home/vjm/csc220/google2/66.html[]1.3974404596580514
    edu.miami.cs.www/home/vjm/csc220/google2/67.html[]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/68.html[]1.6372335237391584
    edu.miami.cs.www/home/vjm/csc220/google2/69.html[]0.8639202464143679
    edu.miami.cs.www/home/vjm/csc220/google2/70.html[]1.6481531927459825
    edu.miami.cs.www/home/vjm/csc220/google2/71.html[]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/72.html[]2.569754720783499
    edu.miami.cs.www/home/vjm/csc220/google2/73.html[]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/74.html[]1.27939334201821
    edu.miami.cs.www/home/vjm/csc220/google2/75.html[]1.1598074351354177
    edu.miami.cs.www/home/vjm/csc220/google2/76.html[]1.6372335237391584
    edu.miami.cs.www/home/vjm/csc220/google2/77.html[]0.7609397355382019
    edu.miami.cs.www/home/vjm/csc220/google2/78.html[]1.9503054519563106
    edu.miami.cs.www/home/vjm/csc220/google2/79.html[]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/80.html[]2.389080213239552
    edu.miami.cs.www/home/vjm/csc220/google2/81.html[]1.07726238360143
    edu.miami.cs.www/home/vjm/csc220/google2/82.html[]1.27939334201821
    edu.miami.cs.www/home/vjm/csc220/google2/83.html[]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/84.html[]2.770823145264635
    edu.miami.cs.www/home/vjm/csc220/google2/85.html[]0.8265496505134932
    edu.miami.cs.www/home/vjm/csc220/google2/86.html[]1.27939334201821
    edu.miami.cs.www/home/vjm/csc220/google2/87.html[]0.9694372230756612
    edu.miami.cs.www/home/vjm/csc220/google2/88.html[]2.05198544764812
    edu.miami.cs.www/home/vjm/csc220/google2/89.html[]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/90.html[]2.602862004496042
    edu.miami.cs.www/home/vjm/csc220/google2/91.html[]0.7873189797035253
    edu.miami.cs.www/home/vjm/csc220/google2/92.html[]1.7427505004004642
    edu.miami.cs.www/home/vjm/csc220/google2/93.html[]0.9694372230756612
    edu.miami.cs.www/home/vjm/csc220/google2/94.html[]1.27939334201821
    edu.miami.cs.www/home/vjm/csc220/google2/95.html[]0.8265496505134932
    edu.miami.cs.www/home/vjm/csc220/google2/96.html[]3.1501004715010925
    edu.miami.cs.www/home/vjm/csc220/google2/97.html[]0.633101859967789
    edu.miami.cs.www/home/vjm/csc220/google2/98.html[]1.4926255656879208
    edu.miami.cs.www/home/vjm/csc220/google2/99.html[]1.1568644446299041
    ```

    `Search.java`:

    -   GUI OUTPUT:

    ```
    Found [2, 5] on
    http://www.cs.miami.edu/home/vjm/csc220/google2/90.html
    http://www.cs.miami.edu/home/vjm/csc220/google2/80.html
    http://www.cs.miami.edu/home/vjm/csc220/google2/60.html
    http://www.cs.miami.edu/home/vjm/csc220/google2/70.html
    http://www.cs.miami.edu/home/vjm/csc220/google2/40.html
    ```

    -   TERMINAL OUTPUT:

    ```
    map from URL to page index
    {edu.miami.cs.www/home/vjm/csc220/google2/1.html=0, edu.miami.cs.www/home/vjm/csc220/google2/10.html=23, edu.miami.cs.www/home/vjm/csc220/google2/11.html=27, edu.miam
    i.cs.www/home/vjm/csc220/google2/12.html=29, edu.miami.cs.www/home/vjm/csc220/google2/13.html=31, edu.miami.cs.www/home/vjm/csc220/google2/14.html=33, edu.miami.cs.ww
    w/home/vjm/csc220/google2/15.html=36, edu.miami.cs.www/home/vjm/csc220/google2/16.html=40, edu.miami.cs.www/home/vjm/csc220/google2/17.html=44, edu.miami.cs.www/home/
    vjm/csc220/google2/18.html=48, edu.miami.cs.www/home/vjm/csc220/google2/19.html=49, edu.miami.cs.www/home/vjm/csc220/google2/2.html=3, edu.miami.cs.www/home/vjm/csc22
    0/google2/20.html=53, edu.miami.cs.www/home/vjm/csc220/google2/21.html=54, edu.miami.cs.www/home/vjm/csc220/google2/22.html=56, edu.miami.cs.www/home/vjm/csc220/googl
    e2/23.html=58, edu.miami.cs.www/home/vjm/csc220/google2/24.html=59, edu.miami.cs.www/home/vjm/csc220/google2/25.html=61, edu.miami.cs.www/home/vjm/csc220/google2/26.h
    tml=62, edu.miami.cs.www/home/vjm/csc220/google2/27.html=65, edu.miami.cs.www/home/vjm/csc220/google2/28.html=66, edu.miami.cs.www/home/vjm/csc220/google2/29.html=67,
     edu.miami.cs.www/home/vjm/csc220/google2/3.html=7, edu.miami.cs.www/home/vjm/csc220/google2/30.html=70, edu.miami.cs.www/home/vjm/csc220/google2/31.html=71, edu.miam
    i.cs.www/home/vjm/csc220/google2/32.html=75, edu.miami.cs.www/home/vjm/csc220/google2/33.html=78, edu.miami.cs.www/home/vjm/csc220/google2/34.html=79, edu.miami.cs.ww
    w/home/vjm/csc220/google2/35.html=81, edu.miami.cs.www/home/vjm/csc220/google2/36.html=84, edu.miami.cs.www/home/vjm/csc220/google2/37.html=86, edu.miami.cs.www/home/
    vjm/csc220/google2/38.html=88, edu.miami.cs.www/home/vjm/csc220/google2/39.html=89, edu.miami.cs.www/home/vjm/csc220/google2/4.html=8, edu.miami.cs.www/home/vjm/csc22
    0/google2/40.html=93, edu.miami.cs.www/home/vjm/csc220/google2/41.html=97, edu.miami.cs.www/home/vjm/csc220/google2/42.html=101, edu.miami.cs.www/home/vjm/csc220/goog
    le2/43.html=104, edu.miami.cs.www/home/vjm/csc220/google2/44.html=106, edu.miami.cs.www/home/vjm/csc220/google2/45.html=110, edu.miami.cs.www/home/vjm/csc220/google2/
    46.html=113, edu.miami.cs.www/home/vjm/csc220/google2/47.html=117, edu.miami.cs.www/home/vjm/csc220/google2/48.html=120, edu.miami.cs.www/home/vjm/csc220/google2/49.h
    tml=123, edu.miami.cs.www/home/vjm/csc220/google2/5.html=11, edu.miami.cs.www/home/vjm/csc220/google2/50.html=127, edu.miami.cs.www/home/vjm/csc220/google2/51.html=12
    8, edu.miami.cs.www/home/vjm/csc220/google2/52.html=132, edu.miami.cs.www/home/vjm/csc220/google2/53.html=134, edu.miami.cs.www/home/vjm/csc220/google2/54.html=137, e
    du.miami.cs.www/home/vjm/csc220/google2/55.html=140, edu.miami.cs.www/home/vjm/csc220/google2/56.html=144, edu.miami.cs.www/home/vjm/csc220/google2/57.html=148, edu.m
    iami.cs.www/home/vjm/csc220/google2/58.html=149, edu.miami.cs.www/home/vjm/csc220/google2/59.html=152, edu.miami.cs.www/home/vjm/csc220/google2/6.html=14, edu.miami.c
    s.www/home/vjm/csc220/google2/60.html=153, edu.miami.cs.www/home/vjm/csc220/google2/61.html=154, edu.miami.cs.www/home/vjm/csc220/google2/62.html=158, edu.miami.cs.ww
    w/home/vjm/csc220/google2/63.html=160, edu.miami.cs.www/home/vjm/csc220/google2/64.html=163, edu.miami.cs.www/home/vjm/csc220/google2/65.html=166, edu.miami.cs.www/ho
    me/vjm/csc220/google2/66.html=169, edu.miami.cs.www/home/vjm/csc220/google2/67.html=170, edu.miami.cs.www/home/vjm/csc220/google2/68.html=171, edu.miami.cs.www/home/v
    jm/csc220/google2/69.html=173, edu.miami.cs.www/home/vjm/csc220/google2/7.html=16, edu.miami.cs.www/home/vjm/csc220/google2/70.html=175, edu.miami.cs.www/home/vjm/csc
    220/google2/71.html=177, edu.miami.cs.www/home/vjm/csc220/google2/72.html=178, edu.miami.cs.www/home/vjm/csc220/google2/73.html=181, edu.miami.cs.www/home/vjm/csc220/
    google2/74.html=182, edu.miami.cs.www/home/vjm/csc220/google2/75.html=185, edu.miami.cs.www/home/vjm/csc220/google2/76.html=187, edu.miami.cs.www/home/vjm/csc220/goog
    le2/77.html=191, edu.miami.cs.www/home/vjm/csc220/google2/78.html=193, edu.miami.cs.www/home/vjm/csc220/google2/79.html=196, edu.miami.cs.www/home/vjm/csc220/google2/
    8.html=19, edu.miami.cs.www/home/vjm/csc220/google2/80.html=200, edu.miami.cs.www/home/vjm/csc220/google2/81.html=204, edu.miami.cs.www/home/vjm/csc220/google2/82.htm
    l=208, edu.miami.cs.www/home/vjm/csc220/google2/83.html=211, edu.miami.cs.www/home/vjm/csc220/google2/84.html=215, edu.miami.cs.www/home/vjm/csc220/google2/85.html=21
    8, edu.miami.cs.www/home/vjm/csc220/google2/86.html=221, edu.miami.cs.www/home/vjm/csc220/google2/87.html=222, edu.miami.cs.www/home/vjm/csc220/google2/88.html=223, e
    du.miami.cs.www/home/vjm/csc220/google2/89.html=225, edu.miami.cs.www/home/vjm/csc220/google2/9.html=20, edu.miami.cs.www/home/vjm/csc220/google2/90.html=226, edu.mia
    mi.cs.www/home/vjm/csc220/google2/91.html=227, edu.miami.cs.www/home/vjm/csc220/google2/92.html=231, edu.miami.cs.www/home/vjm/csc220/google2/93.html=232, edu.miami.c
    s.www/home/vjm/csc220/google2/94.html=233, edu.miami.cs.www/home/vjm/csc220/google2/95.html=235, edu.miami.cs.www/home/vjm/csc220/google2/96.html=238, edu.miami.cs.ww
    w/home/vjm/csc220/google2/97.html=240, edu.miami.cs.www/home/vjm/csc220/google2/98.html=244, edu.miami.cs.www/home/vjm/csc220/google2/99.html=248}
    map from page index to page disk
    {0=edu.miami.cs.www/home/vjm/csc220/google2/1.html[3, 7, 8, 11, 14, 16, 19, 20, 23, 27, 29, 31, 33, 36, 40, 44, 48, 49, 53, 54, 56, 58, 59, 61, 62, 65, 66, 67, 70, 71
    , 75, 78, 79, 81, 84, 86, 88, 89, 93, 97, 101, 104, 106, 110, 113, 117, 120, 123, 127, 128, 132, 134, 137, 140, 144, 148, 149, 152, 153, 154, 158, 160, 163, 166, 169,
     170, 171, 173, 175, 177, 178, 181, 182, 185, 187, 191, 193, 196, 200, 204, 208, 211, 215, 218, 221, 222, 223, 225, 226, 227, 231, 232, 233, 235, 238, 240, 244]0.5050
    505050505051, 3=edu.miami.cs.www/home/vjm/csc220/google2/2.html[8, 14, 19, 23, 29, 33, 40, 48, 53, 56, 59, 62, 66, 70, 75, 79, 84, 88, 93, 101, 106, 113, 120, 127, 13
    2, 137, 144, 149, 153, 158, 163, 169, 171, 175, 178, 182, 187, 193, 200, 208, 215, 221, 223, 226, 231, 233, 238, 244]0.5102572112881392, 7=edu.miami.cs.www/home/vjm/c
    sc220/google2/3.html[14, 20, 29, 36, 48, 54, 59, 65, 70, 78, 84, 89, 101, 110, 120, 128, 137, 148, 153, 160, 169, 173, 178, 185, 193, 204, 215, 222, 226, 232, 238, 24
    8]0.5102572112881392, 8=edu.miami.cs.www/home/vjm/csc220/google2/4.html[19, 29, 40, 53, 59, 66, 75, 84, 93, 106, 120, 132, 144, 153, 163, 171, 178, 187, 200, 215, 223
    , 231, 238]0.5208875698566421, 11=edu.miami.cs.www/home/vjm/csc220/google2/5.html[23, 36, 53, 61, 70, 81, 93, 110, 127, 140, 153, 166, 175, 185, 200, 218, 226, 235]0.
    5102572112881392, 14=edu.miami.cs.www/home/vjm/csc220/google2/6.html[29, 48, 59, 70, 84, 101, 120, 137, 153, 169, 178, 193, 215, 226, 238]0.5368331077093964, 16=edu.m
    iami.cs.www/home/vjm/csc220/google2/7.html[33, 54, 66, 81, 101, 123, 144, 160, 175, 191, 215, 227, 244]0.5102572112881392, 19=edu.miami.cs.www/home/vjm/csc220/google2
    /8.html[40, 59, 75, 93, 120, 144, 163, 178, 200, 223, 238]0.5435348555025831, 20=edu.miami.cs.www/home/vjm/csc220/google2/9.html[48, 65, 84, 110, 137, 160, 178, 204,
    226, 248]0.5262027491408935, 23=edu.miami.cs.www/home/vjm/csc220/google2/10.html[53, 70, 93, 127, 153, 175, 200, 226]0.5492351927059832, 27=edu.miami.cs.www/home/vjm/
    csc220/google2/11.html[56, 78, 106, 140, 169, 191, 223, 248]0.5102572112881392, 29=edu.miami.cs.www/home/vjm/csc220/google2/12.html[59, 84, 120, 153, 178, 215, 238]0.
    5952692672026305, 31=edu.miami.cs.www/home/vjm/csc220/google2/13.html[62, 89, 132, 166, 193, 227]0.5102572112881392, 33=edu.miami.cs.www/home/vjm/csc220/google2/14.ht
    ml[66, 101, 144, 175, 215, 244]0.5601381245711143, 36=edu.miami.cs.www/home/vjm/csc220/google2/15.html[70, 110, 153, 185, 226]0.5545503719902346, 40=edu.miami.cs.www/
    home/vjm/csc220/google2/16.html[75, 120, 163, 200, 238]0.592947115093727, 44=edu.miami.cs.www/home/vjm/csc220/google2/17.html[79, 128, 171, 218]0.5102572112881392, 48
    =edu.miami.cs.www/home/vjm/csc220/google2/18.html[84, 137, 178, 226]0.6252422564707789, 49=edu.miami.cs.www/home/vjm/csc220/google2/19.html[88, 148, 187, 235]0.510257
    2112881392, 53=edu.miami.cs.www/home/vjm/csc220/google2/20.html[93, 153, 200]0.6405368774401721, 54=edu.miami.cs.www/home/vjm/csc220/google2/21.html[101, 160, 215]0.5
    654533038553657, 56=edu.miami.cs.www/home/vjm/csc220/google2/22.html[106, 169, 223]0.5846697212676595, 58=edu.miami.cs.www/home/vjm/csc220/google2/23.html[113, 173, 2
    31]0.5102572112881392, 59=edu.miami.cs.www/home/vjm/csc220/google2/24.html[120, 178, 238]0.7297199935370073, 61=edu.miami.cs.www/home/vjm/csc220/google2/25.html[127,
    185]0.5386048341374803, 62=edu.miami.cs.www/home/vjm/csc220/google2/26.html[132, 193]0.6059304384046653, 65=edu.miami.cs.www/home/vjm/csc220/google2/27.html[137, 204]
    0.5788230240549829, 66=edu.miami.cs.www/home/vjm/csc220/google2/28.html[144, 215]0.676141764312241, 67=edu.miami.cs.www/home/vjm/csc220/google2/29.html[149, 222]0.510
    2572112881392, 70=edu.miami.cs.www/home/vjm/csc220/google2/30.html[153, 226]0.7805340778923254, 71=edu.miami.cs.www/home/vjm/csc220/google2/31.html[158, 232]0.5102572
    112881392, 75=edu.miami.cs.www/home/vjm/csc220/google2/32.html[163, 238]0.7115365381124724, 78=edu.miami.cs.www/home/vjm/csc220/google2/33.html[169, 248]0.58998490055
    19109, 79=edu.miami.cs.www/home/vjm/csc220/google2/34.html[171]0.6484518726786769, 81=edu.miami.cs.www/home/vjm/csc220/google2/35.html[175]0.5778553888519525, 84=edu.
    miami.cs.www/home/vjm/csc220/google2/36.html[178]0.8892385729776475, 86=edu.miami.cs.www/home/vjm/csc220/google2/37.html[182]0.5102572112881392, 88=edu.miami.cs.www/h
    ome/vjm/csc220/google2/38.html[187]0.6484518726786769, 89=edu.miami.cs.www/home/vjm/csc220/google2/39.html[193]0.6112456176889167, 93=edu.miami.cs.www/home/vjm/csc220
    /google2/40.html[200]0.9034614295113733, 97=edu.miami.cs.www/home/vjm/csc220/google2/41.html[208]0.5102572112881392, 101=edu.miami.cs.www/home/vjm/csc220/google2/42.h
    tml[215]0.8937133249848027, 104=edu.miami.cs.www/home/vjm/csc220/google2/43.html[221]0.5102572112881392, 106=edu.miami.cs.www/home/vjm/csc220/google2/44.html[223]0.80
    22069140028203, 110=edu.miami.cs.www/home/vjm/csc220/google2/45.html[226]0.7180807213023709, 113=edu.miami.cs.www/home/vjm/csc220/google2/46.html[231]0.69097330695268
    84, 117=edu.miami.cs.www/home/vjm/csc220/google2/47.html[233]0.5102572112881392, 120=edu.miami.cs.www/home/vjm/csc220/google2/48.html[238]1.091549414401422, 123=edu.m
    iami.cs.www/home/vjm/csc220/google2/49.html[244]0.5495077660026114, 127=edu.miami.cs.www/home/vjm/csc220/google2/50.html[]0.8871920088629712, 128=edu.miami.cs.www/hom
    e/vjm/csc220/google2/51.html[]0.6537670519629283, 132=edu.miami.cs.www/home/vjm/csc220/google2/52.html[]0.931542943252939, 134=edu.miami.cs.www/home/vjm/csc220/google
    2/53.html[]0.5102572112881392, 137=edu.miami.cs.www/home/vjm/csc220/google2/54.html[]1.070964332615965, 140=edu.miami.cs.www/home/vjm/csc220/google2/55.html[]0.602386
    9855484977, 144=edu.miami.cs.www/home/vjm/csc220/google2/56.html[]1.0636249060595055, 148=edu.miami.cs.www/home/vjm/csc220/google2/57.html[]0.6537670519629283, 149=ed
    u.miami.cs.www/home/vjm/csc220/google2/58.html[]0.7760161755007117, 152=edu.miami.cs.www/home/vjm/csc220/google2/59.html[]0.5102572112881392, 153=edu.miami.cs.www/hom
    e/vjm/csc220/google2/60.html[]1.4919991617077193, 154=edu.miami.cs.www/home/vjm/csc220/google2/61.html[]0.5102572112881392, 158=edu.miami.cs.www/home/vjm/csc220/googl
    e2/62.html[]0.7760161755007117, 160=edu.miami.cs.www/home/vjm/csc220/google2/63.html[]0.8065580133879103, 163=edu.miami.cs.www/home/vjm/csc220/google2/64.html[]1.0673
    048071687086, 166=edu.miami.cs.www/home/vjm/csc220/google2/65.html[]0.6236477026855035, 169=edu.miami.cs.www/home/vjm/csc220/google2/66.html[]1.1262864903328822, 170=
    edu.miami.cs.www/home/vjm/csc220/google2/67.html[]0.5102572112881392, 171=edu.miami.cs.www/home/vjm/csc220/google2/68.html[]1.3195510310032947, 173=edu.miami.cs.www/h
    ome/vjm/csc220/google2/69.html[]0.6962884862369398, 175=edu.miami.cs.www/home/vjm/csc220/google2/70.html[]1.3283518894558415, 177=edu.miami.cs.www/home/vjm/csc220/goo
    gle2/71.html[]0.5102572112881392, 178=edu.miami.cs.www/home/vjm/csc220/google2/72.html[]2.071129403392108, 181=edu.miami.cs.www/home/vjm/csc220/google2/73.html[]0.510
    2572112881392, 182=edu.miami.cs.www/home/vjm/csc220/google2/74.html[]1.0311447811447811, 185=edu.miami.cs.www/home/vjm/csc220/google2/75.html[]0.9347628634570216, 187
    =edu.miami.cs.www/home/vjm/csc220/google2/76.html[]1.3195510310032947, 191=edu.miami.cs.www/home/vjm/csc220/google2/77.html[]0.6132899174136288, 193=edu.miami.cs.www/
    home/vjm/csc220/google2/78.html[]1.5718756869959623, 196=edu.miami.cs.www/home/vjm/csc220/google2/79.html[]0.5102572112881392, 200=edu.miami.cs.www/home/vjm/csc220/go
    ogle2/80.html[]1.9255122820414923, 204=edu.miami.cs.www/home/vjm/csc220/google2/81.html[]0.8682345360824744, 208=edu.miami.cs.www/home/vjm/csc220/google2/82.html[]1.0
    311447811447811, 211=edu.miami.cs.www/home/vjm/csc220/google2/83.html[]0.5102572112881392, 215=edu.miami.cs.www/home/vjm/csc220/google2/84.html[]2.2331832845149, 218=
    edu.miami.cs.www/home/vjm/csc220/google2/85.html[]0.6661691369595151, 221=edu.miami.cs.www/home/vjm/csc220/google2/86.html[]1.0311447811447811, 222=edu.miami.cs.www/h
    ome/vjm/csc220/google2/87.html[]0.7813313547849631, 223=edu.miami.cs.www/home/vjm/csc220/google2/88.html[]1.6538260875967845, 225=edu.miami.cs.www/home/vjm/csc220/goo
    gle2/89.html[]0.5102572112881392, 226=edu.miami.cs.www/home/vjm/csc220/google2/90.html[]2.097812677172643, 227=edu.miami.cs.www/home/vjm/csc220/google2/91.html[]0.634
    5506345506347, 231=edu.miami.cs.www/home/vjm/csc220/google2/92.html[]1.4045938995513179, 232=edu.miami.cs.www/home/vjm/csc220/google2/93.html[]0.7813313547849631, 233
    =edu.miami.cs.www/home/vjm/csc220/google2/94.html[]1.0311447811447811, 235=edu.miami.cs.www/home/vjm/csc220/google2/95.html[]0.6661691369595151, 238=edu.miami.cs.www/
    home/vjm/csc220/google2/96.html[]2.53886709785908, 240=edu.miami.cs.www/home/vjm/csc220/google2/97.html[]0.5102572112881392, 244=edu.miami.cs.www/home/vjm/csc220/goog
    le2/98.html[]1.2030022446689115, 248=edu.miami.cs.www/home/vjm/csc220/google2/99.html[]0.9323909195043216}
    map from word to word index
    {88=223, 89=225, 90=226, 91=227, 92=231, 93=232, 94=233, 95=235, 96=238, 97=240, 10=23, 98=244, 11=27, 99=248, 12=29, 13=31, 14=33, 15=36, 16=40, 17=44, 18=48, 19=49,
     1=0, 2=3, 3=7, 4=8, 5=11, 6=14, 7=16, 8=19, 9=20, 20=53, 21=54, 22=56, 23=58, 24=59, 25=61, 26=62, 27=65, 28=66, 29=67, 30=70, 31=71, 32=75, 33=78, 34=79, 35=81, 36=
    84, 37=86, 38=88, 39=89, 40=93, 41=97, 42=101, 43=104, 44=106, 45=110, 46=113, 47=117, 48=120, 49=123, 50=127, 51=128, 52=132, 53=134, 54=137, 55=140, 56=144, 57=148,
     58=149, 59=152, 60=153, 61=154, 62=158, 63=160, 64=163, 65=166, 66=169, 67=170, 68=171, 69=173, 70=175, 71=177, 72=178, 73=181, 74=182, 75=185, 76=187, 77=191, 78=19
    3, 79=196, 80=200, 81=204, 82=208, 83=211, 84=215, 85=218, 86=221, 87=222}
    map from word index to word file
    {0=1[0, 3, 7, 8, 11, 14, 16, 19, 20, 23, 27, 29, 31, 33, 36, 40, 44, 48, 49, 53, 54, 56, 58, 59, 61, 62, 65, 66, 67, 70, 71, 75, 78, 79, 81, 84, 86, 88, 89, 93, 97, 1
    01, 104, 106, 110, 113, 117, 120, 123, 127, 128, 132, 134, 137, 140, 144, 148, 149, 152, 153, 154, 158, 160, 163, 166, 169, 170, 171, 173, 175, 177, 178, 181, 182, 18
    5, 187, 191, 193, 196, 200, 204, 208, 211, 215, 218, 221, 222, 223, 225, 226, 227, 231, 232, 233, 235, 238, 240, 244, 248]0.0, 3=2[3, 8, 14, 19, 23, 29, 33, 40, 48, 5
    3, 56, 59, 62, 66, 70, 75, 79, 84, 88, 93, 101, 106, 113, 120, 127, 132, 137, 144, 149, 153, 158, 163, 169, 171, 175, 178, 182, 187, 193, 200, 208, 215, 221, 223, 226
    , 231, 233, 238, 244]0.0, 7=3[7, 14, 20, 29, 36, 48, 54, 59, 65, 70, 78, 84, 89, 101, 110, 120, 128, 137, 148, 153, 160, 169, 173, 178, 185, 193, 204, 215, 222, 226,
    232, 238, 248]0.0, 8=4[8, 19, 29, 40, 53, 59, 66, 75, 84, 93, 106, 120, 132, 144, 153, 163, 171, 178, 187, 200, 215, 223, 231, 238]0.0, 11=5[11, 23, 36, 53, 61, 70, 8
    1, 93, 110, 127, 140, 153, 166, 175, 185, 200, 218, 226, 235]0.0, 14=6[14, 29, 48, 59, 70, 84, 101, 120, 137, 153, 169, 178, 193, 215, 226, 238]0.0, 16=7[16, 33, 54,
    66, 81, 101, 123, 144, 160, 175, 191, 215, 227, 244]0.0, 19=8[19, 40, 59, 75, 93, 120, 144, 163, 178, 200, 223, 238]0.0, 20=9[20, 48, 65, 84, 110, 137, 160, 178, 204,
     226, 248]0.0, 23=10[23, 53, 70, 93, 127, 153, 175, 200, 226]0.0, 27=11[27, 56, 78, 106, 140, 169, 191, 223, 248]0.0, 29=12[29, 59, 84, 120, 153, 178, 215, 238]0.0, 3
    1=13[31, 62, 89, 132, 166, 193, 227]0.0, 33=14[33, 66, 101, 144, 175, 215, 244]0.0, 36=15[36, 70, 110, 153, 185, 226]0.0, 40=16[40, 75, 120, 163, 200, 238]0.0, 44=17[
    44, 79, 128, 171, 218]0.0, 48=18[48, 84, 137, 178, 226]0.0, 49=19[49, 88, 148, 187, 235]0.0, 53=20[53, 93, 153, 200]0.0, 54=21[54, 101, 160, 215]0.0, 56=22[56, 106, 1
    69, 223]0.0, 58=23[58, 113, 173, 231]0.0, 59=24[59, 120, 178, 238]0.0, 61=25[61, 127, 185]0.0, 62=26[62, 132, 193]0.0, 65=27[65, 137, 204]0.0, 66=28[66, 144, 215]0.0,
     67=29[67, 149, 222]0.0, 70=30[70, 153, 226]0.0, 71=31[71, 158, 232]0.0, 75=32[75, 163, 238]0.0, 78=33[78, 169, 248]0.0, 79=34[79, 171]0.0, 81=35[81, 175]0.0, 84=36[8
    4, 178]0.0, 86=37[86, 182]0.0, 88=38[88, 187]0.0, 89=39[89, 193]0.0, 93=40[93, 200]0.0, 97=41[97, 208]0.0, 101=42[101, 215]0.0, 104=43[104, 221]0.0, 106=44[106, 223]0
    .0, 110=45[110, 226]0.0, 113=46[113, 231]0.0, 117=47[117, 233]0.0, 120=48[120, 238]0.0, 123=49[123, 244]0.0, 127=50[127]0.0, 128=51[128]0.0, 132=52[132]0.0, 134=53[13
    4]0.0, 137=54[137]0.0, 140=55[140]0.0, 144=56[144]0.0, 148=57[148]0.0, 149=58[149]0.0, 152=59[152]0.0, 153=60[153]0.0, 154=61[154]0.0, 158=62[158]0.0, 160=63[160]0.0,
     163=64[163]0.0, 166=65[166]0.0, 169=66[169]0.0, 170=67[170]0.0, 171=68[171]0.0, 173=69[173]0.0, 175=70[175]0.0, 177=71[177]0.0, 178=72[178]0.0, 181=73[181]0.0, 182=7
    4[182]0.0, 185=75[185]0.0, 187=76[187]0.0, 191=77[191]0.0, 193=78[193]0.0, 196=79[196]0.0, 200=80[200]0.0, 204=81[204]0.0, 208=82[208]0.0, 211=83[211]0.0, 215=84[215]
    0.0, 218=85[218]0.0, 221=86[221]0.0, 222=87[222]0.0, 223=88[223]0.0, 225=89[225]0.0, 226=90[226]0.0, 227=91[227]0.0, 231=92[231]0.0, 232=93[232]0.0, 233=94[233]0.0, 2
    35=95[235]0.0, 238=96[238]0.0, 240=97[240]0.0, 244=98[244]0.0, 248=99[248]0.0}
    Match found: edu.miami.cs.www/home/vjm/csc220/google2/10.html Impact: 0.5492351927059832
    Match found: edu.miami.cs.www/home/vjm/csc220/google2/20.html Impact: 0.6405368774401721
    Match found: edu.miami.cs.www/home/vjm/csc220/google2/30.html Impact: 0.7805340778923254
    Match found: edu.miami.cs.www/home/vjm/csc220/google2/40.html Impact: 0.9034614295113733
    Match found: edu.miami.cs.www/home/vjm/csc220/google2/50.html Impact: 0.8871920088629712
    Match found: edu.miami.cs.www/home/vjm/csc220/google2/60.html Impact: 1.4919991617077193
    Match found: edu.miami.cs.www/home/vjm/csc220/google2/70.html Impact: 1.3283518894558415
    Match found: edu.miami.cs.www/home/vjm/csc220/google2/80.html Impact: 1.9255122820414923
    Match found: edu.miami.cs.www/home/vjm/csc220/google2/90.html Impact: 2.097812677172643
    ```

## License

This project is licensed under the terms found on the following license: [LICENSE](LICENSE). Please see the `LICENSE` file for more details.
