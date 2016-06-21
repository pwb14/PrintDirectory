package edu.citadel.csci603;


import java.io.*;


/**
 * Utility class that prints the directory structure to standard output
 * showing the composition of nested files and subdirectories.
 */
public class PrintDirectoryStructure
  {
    /**
     * Prints the structure for the file whose path name is given in arg[0].
     */

    public static void main(String[] args)
      {

        if (args.length != 1)
          {
            printUsage();
            System.exit(-1);
          }

        String pathName = args[0];
        File file = new File(pathName);

        if (file.exists()){
        	printDirectory(file,0);
            printFileTree(file,1);
        } else
            System.out.println("*** File " + pathName + " does not exist. ***");
      }


    public static void printFileTree(File f, int level) { 
        File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                	printDirectory(file,level);
                    printFileTree(file, level + 1);
                } else 
                	printFile(file,level);
            }
    }
    private static void printDirectory(File dir, int nestingLevel)
      {
    	System.out.println(getIndentString(nestingLevel)+"+" + dir.getName());
      }

    private static void printFile(File file, int nestingLevel)
      {
        System.out.println(getIndentString(nestingLevel)+"-" + file.getName());
      }


    private static String getIndentString(int nestingLevel)
      {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < nestingLevel; i++)
            s.append("   ");

        return s.toString();
      }


    private static void printUsage()
      {
        System.out.println("Usage: edu.citadel.csis603.(<path>)");
        System.out.println("       where <path> is the path of a file or directory");
        System.out.println();
      }
  }