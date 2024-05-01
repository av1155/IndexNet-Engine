package edu.aav66;

import java.util.List;

/**
 * Defines the contract for a browser that can load pages, fetch words and URLs from a page.
 * Implementations of this interface can be used to scrape and process web content.
 */
public interface Browser
{

    /**
     * Load the page with this url.  Return false if it could not be
     * loaded.
     */
    boolean loadPage( String url );

    /** Return a list containing all the words on this page. */
    List<String> getWords();

    /** Return a list containing all the URLs on this page */
    List<String> getURLs();
}
