package edu.aav66.DataStructures;
import java.io.*;
import java.util.*;

/**
 * Represents a B-tree, a self-balancing tree data structure that maintains sorted data in a way that
 * allows searches, sequential access, insertions, and deletions in logarithmic time. The BTree extends
 * AbstractMap and stores elements in an ArrayMap, adjusting its structure as elements are added or removed
 * to ensure balanced tree properties.
 */
public class BTree extends AbstractMap<String, String>
{
    final int CAPACITY;
    ArrayMap file;
    int level = 0;

    /**
     * Constructs a BTree with a specified capacity. Initializes an ArrayMap to store the elements.
     *
     * @param CAPACITY The capacity of the ArrayMap, defining the maximum number of elements it can hold
     * before needing to split.
     */
    public BTree( int CAPACITY )
    {
        this.CAPACITY = CAPACITY;
        file = new ArrayMap( CAPACITY, FileMap.newFileName() );
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map.
     */
    public int size() { return file.size(); }

    /**
     * Returns {@code true} if this map contains a mapping for the specified key.
     *
     * @param keyAsObject The key whose presence in this map is to be tested.
     * @return {@code true} if this map contains a mapping for the specified key.
     */
    public boolean containsKey( Object keyAsObject ) { return file.containsKey( keyAsObject ); }

    /**
     * Returns the value to which the specified key is mapped, or {@code null} if this map contains no
     * mapping for the key.
     *
     * @param keyAsObject The key whose associated value is to be returned.
     * @return The value to which the specified key is mapped, or {@code null} if this map contains no
     * mapping for the key.
     */
    public String get( Object keyAsObject ) { return file.get( keyAsObject ); }

    /**
     * Associates the specified value with the specified key in this map. If the map previously contained
     * a mapping for the key, the old value is replaced by the specified value.
     *
     * @param key Key with which the specified value is to be associated.
     * @param value Value to be associated with the specified key.
     * @return The previous value associated with {@code key}, or {@code null} if there was no mapping for
     * {@code key}.
     */
    public String put( String key, String value )
    {
        String oldValue = null;
        // EXERCISE
        ///
        // Look at containsKey and get.
        // What should oldValue be set to?
        oldValue = file.put( key, value );

        // Write out the file.
        file.write();

        ///

        if ( file.size == file.entries.length )
        {
            // EXERCISE
            ///
            // increment level
            level++;

            // Create a new FileMap at the new level.
            // Use FileMap.newFileName() as its name.
            // Use CAPACITY and level.
            FileMap newFile = new FileMap( CAPACITY, FileMap.newFileName(), level ); // FIXED

            // Add a new Entry (new ArrayMap.Entry) to newFile whose
            // key is the minimum key in file and whose value is
            // file's file name.  (Hint: file "knows" its file name.)
            newFile.add( 0, new ArrayMap.Entry( file.entries[0].key, file.fileName ) );

            // Now newFile is an FileMap with a single file that has 4
            // entries (file.size==4).  How should we fix this?  Look
            // at FileMap.put!
            newFile.split( 0 );

            // Write out the new file.
            newFile.write();

            ///

            file = newFile;
        }

        return oldValue;
    }

    /**
     * Removes the mapping for a key from this map if it is present. Returns the value to which this map
     * previously associated the key, or {@code null} if the map contained no mapping for the key.
     *
     * @param keyAsObject The key whose mapping is to be removed from the map.
     * @return The previous value associated with {@code key}, or {@code null} if there was no mapping for
     * {@code key}.
     */
    public String remove( Object keyAsObject )
    {
        String value = null;
        String key = (String)keyAsObject;

        if ( level == 0 )
        {
            // Directly remove from ArrayMap if at root level
            value = file.remove( key );
            file.write();
        }
        else
        {
            // Downcast to FileMap since level is positive
            FileMap fileMap = (FileMap)file;

            // Find the file that potentially contains the key
            int index = fileMap.findFile( key );
            if ( index >= 0 )
            {
                ArrayMap childFile = fileMap.getFile( index );
                value = childFile.remove( key );
                childFile.write();

                // Handle potential underflow
                if ( childFile.size < childFile.entries.length / 2 )
                {
                    // Check and merge or redistribute with siblings
                    if ( index > 0 )
                    {
                        // Try to merge with the left sibling or redistribute entries
                        fileMap.join( index - 1 );
                    }
                    else if ( index < fileMap.size - 1 )
                    {
                        // Try to merge with the right sibling or redistribute entries
                        fileMap.join( index );
                    }

                    // If the childFile is the root and only one entry left, decrease the tree level
                    if ( fileMap == file && fileMap.size == 1 )
                    {
                        // Set file to that file.
                        file = fileMap.getFile( 0 );

                        // Decrement level.
                        level--;

                        // Write out the file.
                        file.write();
                    }
                }
            }
        }

        return value;
    }

    /**
     * Internal method to add entries to a list from the file map. This is used by the iterator
     * implementations to provide a consistent iteration order.
     *
     * @param list The list to which entries will be added.
     */
    void addEntries( List<Map.Entry<String, String>> list )
    {
        if ( file instanceof FileMap )
        {
            FileMap map2 = (FileMap)file;
            map2.addEntries( list );
        }
        else
        {
            for ( int i = 0; i < file.size; i++ )
                list.add( (Map.Entry<String, String>)file.entries[i] );
        }
    }

    /**
     * Creates an iterator over the entries in this map. This method is used internally to provide
     * iterators for the map's entry set.
     *
     * @return An iterator over the entries in this map.
     */
    Iterator<Map.Entry<String, String>> myIterator()
    {
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();
        addEntries( list );
        return list.iterator();
    }

    /**
     * Computes the size of this map for the iterator. This method is used internally to provide the
     * size for the map's entry set.
     *
     * @return The number of entries in this map.
     */
    int mySize()
    {
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();
        addEntries( list );
        return list.size();
    }

    /**
     * Nested class to provide a set view of the entries in the BTree. This is used by the entrySet
     * method to return a set of Map.Entry objects contained in the BTree.
     */
    protected class Setter extends AbstractSet<Map.Entry<String, String>>
    {
        public Iterator<Map.Entry<String, String>> iterator() { return myIterator(); }

        public int size() { return mySize(); }
    }

    /**
     * Provides a set view of the mappings contained in this map. Each element in the returned set is a
     * Map.Entry.
     *
     * @return A set view of the mappings contained in this map.
     */
    public Set<Map.Entry<String, String>> entrySet() { return new Setter(); }

    /**
     * Internal test method to print the map's contents. Used for debugging purposes.
     */
    void print()
    {
        if ( level == 0 )
        {
            for ( int i = 0; i < file.size; i++ )
            {
                System.out.println( file.entries[i].key );
                System.out.println( file.entries[i].value );
            }
        }
        else
            ( (FileMap)file ).print();
    }

    /**
     * Test method for put operation. Inserts a key-value pair into the map and prints the result.
     * Used for debugging purposes.
     *
     * @param key The key to be inserted.
     * @param value The value to be associated with the key.
     */
    void putTest( String key, String value )
    {
        System.out.println( "put(" + key + ", " + value + ") = " + put( key, value ) );
        if ( !get( key ).equals( value ) )
            System.out.println( "ERROR: get(" + key + ") = " + get( key ) );
        print();
    }

    /**
     * Test method for remove operation. Removes a key from the map and prints the result.
     * Used for debugging purposes.
     *
     * @param key The key to be removed.
     */
    void removeTest( String key )
    {
        String v = get( key );
        String value = remove( key );
        if ( !v.equals( value ) )
            System.out.print( "ERROR: " );
        System.out.println( "remove(" + key + ") = " + value );
        value = remove( key );
        if ( value != null )
            System.out.println( "ERROR: remove(" + key + ") = " + value );
        print();
    }

    /**
     * The main method to test BTree functionality.
     *
     * @param args Command line arguments (not used).
     */
    public static void main( String[] args )
    {
        BTree tree = new BTree( 4 );

        tree.putTest( "a", 0 + "" );
        tree.putTest( "b", 1 + "" );
        tree.putTest( "c", 2 + "" );
        tree.putTest( "d", 3 + "" );
        tree.putTest( "e", 4 + "" );
        tree.putTest( "f", 5 + "" );
        tree.putTest( "g", 6 + "" );
        tree.putTest( "h", 7 + "" );
        tree.putTest( "i", 8 + "" );
        tree.removeTest( "a" );
    }
}
