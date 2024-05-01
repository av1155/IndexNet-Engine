package edu.aav66;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents information about an entity, such as a word or a webpage, stored in a file.
 * It contains the entity's data, its impact or relevance score, and references to related entities.
 */
public class InfoFile
{
    /** The main content of the file, such as a URL or a word. */
    public final String data; // URL or word

    /** The impact or relevance score of the data, like page rank for web pages or frequency for words. */
    public double impact = 0; // page rank or word frequency

    /** A temporary placeholder for the impact score, useful during calculations or updates. */
    public double impactTemp = 0; // temporary page rank

    /** A list of indices representing links or references to other related data points. */
    List<Long> indices = new ArrayList<Long>(); // page indices

    /**
     * Constructs an InfoFile with the specified data.
     *
     * @param data The main content of this file, such as a URL or word.
     */
    public InfoFile( String data ) { this.data = data; }

    /**
     * Returns a string representation of this InfoFile, including its data, indices, and impact score.
     *
     * @return A string that concatenates the data, indices, and impact of this file.
     */
    public String toString() { return data + indices + impact; }
}

/*
 * The "InfoFile" class is like a page in a digital notebook, each dedicated to a piece of information
 * which could be a favorite song, a word, or a webpage URL (represented by the "data" field).
 * The "impact" field is akin to a rating system, where you assign a value based on how significant
 * or impactful the information is to you, similar to a score from 1 to 10.
 *
 * If you're still deciding on the final impact score, you can use the "impactTemp" field as a
 * placeholder for a provisional rating.
 *
 * The "indices" list acts like a collection of references or links. Each entry in this list is a code
 * that connects the information on this page to other related items or categories in your digital notebook,
 * helping you organize and cross-reference your data effectively.
 */
