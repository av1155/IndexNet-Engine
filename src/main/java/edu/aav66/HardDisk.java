package edu.aav66;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Simulates a hard disk that maps a block number to InfoFile objects. It supports creating new files,
 * reading from, and writing to the simulated disk, using a TreeMap to manage the mappings.
 */
public class HardDisk extends TreeMap<Long, InfoFile>
{
    /**
     * Creates a new file on the hard disk and returns its starting block number.
     *
     * @return The starting block number of the new file (index).
     */
    public Long newFile()
    {
        Long index = nextIndex;
        nextIndex += 1 + random.nextInt( 4 );
        return index;
    }

    /**
     * Writes the contents of the hard disk to a specified file.
     *
     * @param fileName The name of the file to which the disk contents will be written.
     * @return true if the writing was successful, false otherwise.
     */
    public boolean write( String fileName )
    {
        try
        {
            // Create PrintWriter for the file.
            PrintWriter out = new PrintWriter( new FileWriter( fileName ) );

            for ( Map.Entry entry : entrySet() )
            {
                out.println( entry.getKey() );
                InfoFile file = (InfoFile)entry.getValue();
                out.println( file.data );
                out.println( file.impact );
                out.println( file.indices.size() );
                for ( Long index : file.indices )
                    out.println( index );
            }

            out.close();
        }
        catch ( Exception ex )
        {
            System.err.println( "Could not write to " + fileName );
            return false;
        }

        return true;
    }

    /**
     * Reads the contents of a specified file and loads it into the hard disk.
     *
     * @param fileName The name of the file to read from.
     * @return true if the file was successfully read, false otherwise.
     */
    public boolean read( String fileName )
    {
        clear();
        try
        {
            Scanner in = new Scanner( new File( fileName ) );

            while ( in.hasNextLong() )
            {
                Long index = in.nextLong();
                String data = in.nextLine();
                data = in.nextLine();
                // System.out.println("data " + data);
                InfoFile file = new InfoFile( data );
                file.impact = in.nextDouble();
                int n = in.nextInt();
                for ( int i = 0; i < n; i++ )
                    file.indices.add( in.nextLong() );
                put( index, file );
            }

            // Close the file.
            in.close();
        }
        catch ( FileNotFoundException ex )
        {
            // Do nothing: no data to load.
            System.out.println( "Could not read " + fileName );
            return false;
        }

        return true;
    }

    private Long nextIndex = 0L;
    private Random random = new Random( 0 );
}

/*
 * The HardDisk class simulates a simple computer hard drive:
 *
 * - "newFile": Assigns a unique starting point (block number) for
 *   each new file, ensuring each one has its own space. Every other
 *   subsequent file has a slightly higher (by 1 to 4 steps) than the
 *   previous one.
 *
 * - "write": Saves information to the hard disk, recording details
 *   like the file's starting point, its content, and
 *   related references.
 *
 * - "read": Retrieves information from the hard disk, reviewing all
 *   details stored in a file. If the file isn't there,
 *   it notes that there's nothing to read.
 *
 * - The disk keeps track of where to start the next file and adds a
 *   little randomness to this process, so files are not
 *   stored in a strictly sequential order.
 */
