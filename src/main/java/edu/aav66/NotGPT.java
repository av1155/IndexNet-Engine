package edu.aav66;

import edu.aav66.DataStructures.ExternalSort;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * Represents a simple search engine that uses a hard disk simulation to store and index webpages.
 * It implements the SearchEngine interface, providing functionality to collect, rank, and search
 * web pages based on the provided URLs and search terms.
 */
public class NotGPT implements SearchEngine
{
    /**
     * Represents a voting instance where each vote is associated with an index.
     * This class is capable of comparing two votes primarily based on their indexes,
     * and secondarily on their numerical vote values if their indexes are the same.
     */
    public class Vote implements Comparable<Vote> // Ensure that Vote implements Comparable<Vote>
    {
        Long index;  // The unique identifier for the vote
        double vote; // The numerical value of the vote

        /**
         * Constructs a new Vote object with a specified index and vote value.
         *
         * @param index The unique identifier for the vote, used as the primary comparison attribute.
         * @param vote The numerical value associated with this vote, used as a secondary comparison attribute
         *             when indexes are equal.
         */
        public Vote( Long index, double vote )
        {
            this.index = index;
            this.vote = vote;
        }

        /**
         * Compares this Vote object with another Vote object for order.
         * Comparison is first based on the index, and if indexes are equal,
         * it is based on the vote value.
         *
         * @param o The Vote object to be compared against this object.
         * @return A negative integer, zero, or a positive integer as this object
         *         is less than, equal to, or greater than the specified object.
         */
        @Override public int compareTo( Vote o )
        {
            if ( !this.index.equals( o.index ) )
            {
                return this.index.compareTo( o.index ); // Compare indexes
            }
            else
            {
                return Double.compare( this.vote, o.vote ); // Compare votes if indexes are equal
            }
        }

        /**
         * Returns a string representation of this Vote object.
         * The string consists of the index and vote value separated by a space.
         *
         * @return A string representation of the object, formatted as "index vote".
         */
        @Override public String toString()
        {
            return index + " " + vote; // Format: index vote
        }
    }

    /**
     * A class that implements the EScanner interface for the Vote class.
     * This class provides an iterator to read and parse a file containing
     * votes and return them as Vote objects.
     */
    class VoteScanner implements edu.aav66.DataStructures.ExternalSort.EScanner<Vote>
    {
        /**
         * An inner class that implements the Iterator interface for the Vote class.
         * This class reads and parses a file containing votes and returns them as Vote objects.
         */
        class Iter implements Iterator<Vote>
        {
            Scanner in;

            /**
             * Constructor for the Iter class.
             * Opens a Scanner to read from the specified file.
             *
             * @param fileName The name of the file to read votes from.
             */
            Iter( String fileName )
            {
                try
                {
                    in = new Scanner( new File( fileName ) );
                }
                catch ( Exception e )
                {
                    System.out.println( e );
                }
            }

            /**
             * Checks if there are more votes to read from the file.
             *
             * @return true if there are more votes to read, false otherwise.
             */
            public boolean hasNext() { return in.hasNext(); }

            /**
             * Reads the next vote from the file and returns it as a Vote object.
             *
             * @return The next Vote object read from the file.
             */
            public Vote next()
            {
                Long index = in.nextLong();     // Read next Long
                double vote = in.nextDouble();  // Read next double
                return new Vote( index, vote ); // Return a new Vote object
            }
        }

        /**
         * Creates and returns an iterator for reading and processing votes from a file.
         * This method initializes an iterator which will read the file specified by the
         * file name and produce Vote objects based on the data read. The file should
         * contain long and double pairs, each representing the index and vote respectively.
         *
         * @param fileName The name of the file from which the votes will be read.
         * @return An iterator of Vote objects, each constructed from the data read from the file.
         */
        @Override public Iterator<Vote> iterator( String fileName ) { return new Iter( fileName ); }
    }

    /**
     * Compares two Long objects representing page indices based on the impact values of the
     * corresponding pages in a pageDisk map. This comparator is used to order pages in a priority queue
     * by their impact values.
     *
     * @param pageIndex1 The Long index of the first page to compare.
     * @param pageIndex2 The Long index of the second page to compare.
     * @return A negative integer, zero, or a positive integer as the impact value of pageIndex1 is
     *         less than, equal to, or greater than the impact value of pageIndex2.
     */
    private class PageIndexComparator implements Comparator<Long>
    {
        public int compare( Long pageIndex1, Long pageIndex2 )
        {
            double impact1 = pageDisk.get( pageIndex1 ).impact;
            double impact2 = pageDisk.get( pageIndex2 ).impact;
            return Double.compare( impact1, impact2 );
        }
    }

    /**
     * The main method that initiates the program.
     *
     * @param args Command line arguments.
     */
    public static void main( String[] args ) {}

    /* Initializes a priority queue of Long values to store the best page indices. */
    PriorityQueue<Long> bestPageIndices = new PriorityQueue<>( new PageIndexComparator() );

    // WEB PAGES AND URLs-----------------------------------------------------------
    /**
     * Use `pageDisk` to store information about web pages. This hard disk is utilized to map, store,
     * and retrieve data related to web pages, including their content, links, and metadata, facilitating
     * efficient access and manipulation of webpage-related information.
     */
    public HardDisk pageDisk = new HardDisk();

    /**
     * Use `indexOfURL` to store the mapping from each URL to its corresponding index in `pageDisk`.
     * This mapping aids in quickly locating the index of a web page's information stored on the hard disk,
     * enhancing the efficiency of web page data retrieval and processing.
     */
    public Map<String, String> indexOfURL = new edu.aav66.DataStructures.BTree( 100 );

    // WORDS OR TERMS ON WEB PAGES--------------------------------------------------
    /**
     * Use `wordDisk` to store information about individual words or terms encountered on web pages.
     * This hard disk will be utilized to map, store, and retrieve data related to words, such as their
     * occurrences, frequencies, or associations with web page indices, aiding in text analysis and search
     * functionality.
     */
    public HardDisk wordDisk = new HardDisk();

    /**
     * Use `indexOfWord` to store the mapping from each unique word to its corresponding index.
     * This `HashMap` facilitates efficient lookups and retrievals of word indices, allowing for
     * rapid access to word-related data stored elsewhere in the system.
     */
    public Map<String, Long> indexOfWord = new HashMap<>();

    /**
     * Indexes a web page specified by its URL, creating a new entry in the hard disk and mapping the URL
     * to its index.
     *
     * @param URL The URL of the web page to be indexed.
     * @return The index of the newly created page file on the hard disk.
     */
    public Long indexPage( String URL )
    {
        // Check if the URL is already indexed.
        if ( indexOfURL.containsKey( URL ) )
        {
            // Return the existing index if the URL is already indexed.
            return Long.parseLong( indexOfURL.get( URL ) );
        }

        // Gets index of a new file from pageDisk
        Long index = pageDisk.newFile();

        // Creates a new InfoFile
        InfoFile data = new InfoFile( URL );

        // Stores it in pageDisk under that index
        pageDisk.put( index, data );

        // Tells the Map urlToIndex to map URL to that index
        indexOfURL.put( URL, index.toString() );

        // Put a print statement inside your indexPage method.
        System.out.println( String.format( "indexing url %s index %d file %s", URL, index, data ) );
        // indexing url edu.miami.cs.www/home/vjm/csc220/google/mary.html index 0
        // file edu.miami.cs.www/home/vjm/csc220/google/mary.html[]0.0

        // returns the index
        return index;
    }

    /**
     * Indexes a given word by creating a new entry in the word disk. If the word is already indexed,
     * this method simply returns the existing index. Otherwise, it creates a new InfoFile for the word,
     * stores it in the word disk, and maps the word to its new index.
     *
     * @param word The word to be indexed.
     * @return The index of the word in the word disk. If the word was already indexed,
     *         the existing index is returned. Otherwise, a new index is returned.
     */
    public Long indexWord( String word )
    {
        // Check if the word is already indexed.
        if ( indexOfWord.containsKey( word ) )
            // Return the existing index if the word is already indexed.
            return indexOfWord.get( word );

        // Gets index of a new file from wordDisk
        Long index = wordDisk.newFile();

        // Creates a new InfoFile
        InfoFile data = new InfoFile( word );

        // Stores it in wordDisk under that index
        wordDisk.put( index, data );

        // Tells the Map indexOfWord to map `word` to that index
        indexOfWord.put( word, index );

        // Put a print statement inside your indexWord method.
        System.out.println( String.format( "indexing word %s index %d file %s", word, index, data ) );
        // indexing word hill index 0 file hill[]0.0

        // returns the index
        return index;
    }

    /**
     * Collect info from all web pages reachable from URLs in startingURLs.
     *
     * @param browser The browser instance to use for web scraping.
     * @param startingURLs The initial set of URLs to start the collection process.
     */
    @Override public void collect( Browser browser, List<String> startingURLs )
    {
        // Create a queue of page indices.
        //     Deque (double-ended queue): Supports the addition or
        //     removal of elements from either end of the data structure.
        Deque<Long> queue = new ArrayDeque<>();

        // Print initial starting pages
        System.out.println( "starting pages " + startingURLs );

        // For each starting URL:
        for ( String startingURL : startingURLs )
        {
            // Check if it has been indexed already (how?).
            // containsKey(Object key) -> Returns `true` if this map contains a mapping
            // for the specified key.
            // If not, index it using indexPage and put the new index into the queue.
            if ( !indexOfURL.containsKey( startingURL ) )
            {
                Long index = indexPage( startingURL );
                queue.add( index );

                // Print the state of the queue after addition
                System.out.println( "queue " + queue );
            }
        }

        // Do the following while the queue is not empty:
        while ( !queue.isEmpty() )
        {
            // Dequeue a page index.
            Long currentPageIndex = queue.poll();

            // Retrieve the current page's InfoFile to update its references later.
            InfoFile currentPageInfo = pageDisk.get( currentPageIndex );

            System.out.println( "dequeued " + currentPageInfo );

            // Load its URL into the browser.
            boolean pageLoaded = browser.loadPage( pageDisk.get( currentPageIndex ).data );

            // If it loads, get its list of URLs.
            if ( pageLoaded )
            {
                // URLs ========================================================
                // Get its list of URLs.
                List<String> URLsOnPage = browser.getURLs();

                // Print the URLs on the page.
                System.out.println( "urls " + URLsOnPage );

                // Use a Set<String> to determine if a URL has been seen before on that page.
                Set<String> uniqueURLsOnPage = new HashSet<>();

                // Iterate over each URL to process it only if it's unique on the current page.
                for ( String url : URLsOnPage )
                {
                    // Check if the URL has already been encountered on this page.
                    if ( !uniqueURLsOnPage.contains( url ) )
                    {
                        uniqueURLsOnPage.add( url ); // Mark the URL as seen on this page.

                        // Check if the URL is not already indexed.
                        /* Index the URL if it hasn't been indexed yet. We determine this by checking
                         * if 'indexOfURL' does not contain the URL as a key. If 'indexOfURL.get(linkedURL)'
                         * returns 'null', it confirms the URL is not in the map, indicating it hasn't been
                         * indexed and needs to be processed.
                         */
                        if ( !indexOfURL.containsKey( url ) && indexOfURL.get( url ) == null )
                        {
                            // Index the new URL, get its index, and update the current page's InfoFile.
                            Long newIndex = indexPage( url );

                            // Link the current page to the new URL.
                            currentPageInfo.indices.add( newIndex );

                            // Queue the new URL's index for further processing.
                            queue.add( newIndex );
                        }

                        // However, if it does not return `null`, the returned value should
                        // be converted to a `Long` using `Long.parseLong()`
                        else if ( indexOfURL.get( url ) != null )
                        {
                            // Get the existing index of the URL and update the current page's InfoFile
                            Long existingIndex = Long.parseLong( indexOfURL.get( url ) );
                            currentPageInfo.indices.add( existingIndex );
                        }
                    }
                }

                // Print the updated page's InfoFile.
                System.out.println( "updated page file " + currentPageInfo );

                // WORDS ========================================================
                // Get the words from the page using the browser.
                List<String> wordsOnPage = browser.getWords();

                // Print the words on the page.
                System.out.println( "words " + wordsOnPage );

                // Create a set to store unique words encountered on the page.
                Set<String> uniqueWordsOnPage = new HashSet<>();

                // Iterate over each word on the page:
                for ( String word : wordsOnPage )
                {
                    // Check if the word has already been encountered on this page.
                    if ( !uniqueWordsOnPage.contains( word ) )
                    {
                        // If it's a new word on the page, add it to the set.
                        uniqueWordsOnPage.add( word );

                        // Index the word if it hasn't been indexed yet, and get its index.
                        Long wordIndex = indexWord( word );

                        // Get the InfoFile associated with the word.
                        InfoFile wordInfo = wordDisk.get( wordIndex );

                        // Update the word's InfoFile with the current page index if it's not already included.
                        if ( !wordInfo.indices.contains( currentPageIndex ) )
                        {
                            wordInfo.indices.add( currentPageIndex );

                            // Print the updated word's InfoFile.
                            System.out.println( "updated word " + wordInfo.data + " index " + wordIndex + " file " +
                                                wordInfo );
                        }
                    }
                }
            }

            // Print the state of the queue after processing
            if ( !queue.isEmpty() )
                System.out.println( "queue " + queue );
        }
    }

    /**
     * Sets initial page impacts and chooses between slow and fast ranking methods based on the 'fast' parameter.
     * Each selected ranking process is executed multiple times to stabilize results.
     *
     * @param fast If true, the fast ranking method is used; otherwise, the slow ranking is applied.
     */
    @Override public void rank( boolean fast )
    {
        // Iterate over all the page files
        for ( Map.Entry<Long, InfoFile> entry : pageDisk.entrySet() )
        {
            @SuppressWarnings( "unused" ) long index = entry.getKey();
            InfoFile file = entry.getValue();

            // Set the impact in each file to 1.0 and the impactTemp to 0.0.
            file.impact = 1.0;
            file.impactTemp = 0.0;
        }

        if ( !fast )
        {
            for ( int i = 0; i < 20; i++ )
                rankSlow();
        }

        else
        {
            for ( int i = 0; i < 20; i++ )
                rankFast();
        }
    }

    /**
     * Search for up to numResults pages containing all searchWords and
     * return them in an array in order of decreasing importance
     * (number of references).
     *
     * @param searchWords The list of words to search for.
     * @param numResults The number of results to return.
     * @return An array of search results.
     */
    @Override public String[] search( List<String> searchWords, int numResults )
    {
        // Initialize the priority queue with the appropriate capacity and comparator
        bestPageIndices = new PriorityQueue<>( numResults, new PageIndexComparator() );

        // Iterator into list of page indices for each key word.
        @SuppressWarnings( "unchecked" )
        Iterator<Long>[] pageIndexIterators = ( Iterator<Long>[] ) new Iterator[searchWords.size()];

        for ( int i = 0; i < searchWords.size(); i++ )
            // pageIndexIterators[i] should be set to an iterator over the page indices in the file of searchWords[i].
            pageIndexIterators[i] = wordDisk.get( indexOfWord.get( searchWords.get( i ) ) ).indices.iterator();

        // Current page index in each list, just ``behind'' the iterator.
        long[] currentPageIndices = new long[pageIndexIterators.length];

        // While getNextPageIndices is true
        while ( getNextPageIndices( currentPageIndices, pageIndexIterators ) )
        {
            // check if the entries of currentPageIndices are all equal.
            if ( allEqual( currentPageIndices ) )
            {
                Long matchedPageIndex = currentPageIndices[0];
                InfoFile matchedPageInfo = pageDisk.get( matchedPageIndex );

                // Print out the match found and its impact
                System.out.println( "Match found: " + matchedPageInfo.data + " Impact: " + matchedPageInfo.impact );

                if ( bestPageIndices.size() < numResults )
                {
                    bestPageIndices.offer( matchedPageIndex );
                }
                else
                {
                    if ( matchedPageInfo.impact > pageDisk.get( bestPageIndices.peek() ).impact )
                    {
                        bestPageIndices.poll();
                        bestPageIndices.offer( matchedPageIndex );
                    }
                }
            }
        }

        // Extract results from the queue into an array, reversing the order as we do so
        String[] results = new String[bestPageIndices.size()];
        for ( int i = bestPageIndices.size() - 1; i >= 0; i-- )
        {
            results[i] = pageDisk.get( bestPageIndices.poll() ).data; // Fetch URL from pageDisk using index
        }

        return results;
    }

    /**
     * Performs the slow ranking of web pages using the PageRank algorithm. This method distributes
     * a page's impact to all linked pages and then updates each page's impact based on these contributions.
     * Pages with no outgoing links have their impact evenly distributed to all pages.
     */
    void rankSlow()
    {
        // First loop: calculate temporary impacts based on the current page impact
        for ( Map.Entry<Long, InfoFile> entry : pageDisk.entrySet() )
        {
            InfoFile file = entry.getValue();

            // Check if the page has outgoing links
            if ( !file.indices.isEmpty() )
            {
                double impactPerIndex = file.impact / file.indices.size();

                // Distributing the impact across all linked pages
                for ( Long linkedPageIndex : file.indices )
                {
                    InfoFile linkedPage = pageDisk.get( linkedPageIndex );
                    linkedPage.impactTemp += impactPerIndex;
                }
            }
        }

        // Calculate total impact from pages with no outgoing links
        double zeroLinkImpact = 0.0;
        for ( Map.Entry<Long, InfoFile> entry : pageDisk.entrySet() )
        {
            InfoFile file = entry.getValue();
            if ( file.indices.isEmpty() )
                zeroLinkImpact += file.impact;
        }

        // Divide total zero link impact by the number of pages
        double distributedImpact = zeroLinkImpact / pageDisk.size();

        // Second loop: update impact by adding distributedImpact and reset impactTemp
        for ( Map.Entry<Long, InfoFile> entry : pageDisk.entrySet() )
        {
            InfoFile file = entry.getValue();
            // Update impact by adding the distributed zero link impact
            file.impact = file.impactTemp + distributedImpact;
            file.impactTemp = 0.0; // Reset the temporary impact after updating
        }
    }

    /**
     * Quickly calculates page ranks using an external sort mechanism. This method processes impacts as votes,
     * sorts them, and aggregates these votes to update page impacts, optimizing performance for large data sets.
     */
    void rankFast()
    {
        double zeroLinkImpact = 0.0;
        for ( Map.Entry<Long, InfoFile> entry : pageDisk.entrySet() )
        {
            @SuppressWarnings( "unused" ) long index = entry.getKey();
            InfoFile file = entry.getValue();
            if ( file.indices.isEmpty() )
                zeroLinkImpact += file.impact;
        }
        zeroLinkImpact /= pageDisk.size();
        try
        {
            PrintWriter out = new PrintWriter( "unsorted-votes.txt" );
            for ( Map.Entry<Long, InfoFile> entry : pageDisk.entrySet() )
            {
                InfoFile file = entry.getValue();
                double impactPerIndex = file.impact / file.indices.size();
                for ( Long index : file.indices )
                {
                    Vote vote = new Vote( index, impactPerIndex );
                    out.println( vote );
                }
            }
            out.close();
            VoteScanner voteScanner = new VoteScanner();
            ExternalSort<Vote> sorter = new ExternalSort<>( voteScanner );
            sorter.sort( "unsorted-votes.txt", "sorted-votes.txt" );
        }
        catch ( FileNotFoundException e )
        {
            System.out.println( e );
        }

        VoteScanner sortedVoteScanner = new VoteScanner();
        Iterator<Vote> sortedIterator = sortedVoteScanner.iterator( "sorted-votes.txt" );
        Vote vote = sortedIterator.hasNext() ? sortedIterator.next() : null;

        for ( Map.Entry<Long, InfoFile> entry : pageDisk.entrySet() )
        {
            InfoFile file = entry.getValue();
            long index = entry.getKey();
            @SuppressWarnings( "unused" ) double oldImpact = file.impact;
            file.impact = zeroLinkImpact;
            while ( vote != null && vote.index.equals( index ) )
            {
                file.impact += vote.vote;
                vote = sortedIterator.hasNext() ? sortedIterator.next() : null;
            }
        }
    }

    /**
       Check if all elements in an array of long are equal.
        @param array an array of numbers
        @return true if all are equal, false otherwise
    */
    private boolean allEqual( long[] array )
    {
        // Check if all elements of the array are equal
        for ( long element : array )
        {
            // If any element is not equal to the first element, return false
            if ( element != array[0] )
                return false;
        }

        // If all elements are equal, return true
        return true;
    }

    /**
       Get the largest element of an array of long.
        @param array an array of numbers
        @return largest element
    */
    private long getLargest( long[] array )
    {
        long currentLargest = array[0];
        for ( int i = 0; i < array.length; i++ )
        {
            if ( currentLargest < array[i] )
                currentLargest = array[i];
        }

        return currentLargest;
    }

    /**
       If all the elements of currentPageIndices are equal,
        set each one to the next() of its Iterator,
        but if any Iterator hasNext() is false, just return false.

        Otherwise, do that for every element not equal to the largest element.

        Return true.

        @param currentPageIndices array of current page indices
        @param pageIndexIterators array of iterators with next page indices
        @return true if all page indices are updated, false otherwise
    */
    private boolean getNextPageIndices( long[] currentPageIndices, Iterator<Long>[] pageIndexIterators )
    {
        // Check if all elements of currentPageIndices are equal
        if ( allEqual( currentPageIndices ) )
        {
            // Check if any Iterator hasNext() is false
            for ( int i = 0; i < currentPageIndices.length; i++ )
            {
                // if any Iterator hasNext() is false, just return false
                if ( pageIndexIterators[i].hasNext() )
                    currentPageIndices[i] = pageIndexIterators[i].next();

                else
                    return false;
            }
        }

        // Otherwise, do that for every element not equal to the largest element
        else
        {
            // Find the largest element in currentPageIndices
            long largest = getLargest( currentPageIndices );

            // Update elements not equal to the largest element
            for ( int i = 0; i < currentPageIndices.length; i++ )
            {
                // if not equal to the largest element
                if ( currentPageIndices[i] != largest )
                {
                    // if there is a next value to check
                    if ( pageIndexIterators[i].hasNext() )
                        // Set each element to the next() of its Iterator
                        currentPageIndices[i] = pageIndexIterators[i].next();

                    else
                        return false;
                }
            }
        }

        return true;
    }
}
