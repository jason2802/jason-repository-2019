package it.test.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSearchFile
{ 
	private String baseFolder = "C:/dev/perso/jenkinsfileprojects";
    private String searchedFile = "Jenkinsfile";
    private static String wordReplaceFrom = "https://bitbucket.org/digitalicbpi/";
    private static String wordReplaceTo;    
    private static HashMap<String, String> repositories = new HashMap<String, String>();
    private static HashMap<String, String> environmentVariables = new HashMap<String, String>();
    
    public String searchJenkinFile() {
       
        final File startFolder = new File( baseFolder );

        boolean flagFileFound = findFile1( startFolder, searchedFile );

        // replaceInFile( file, wordReplaceFrom, wordReplaceTo );

        System.out.println( "************* baseFolder =  " + baseFolder + "************* searchedFile =  " + searchedFile );
        return "";
    }
    
    private static File findFile8( File dir, String searchedFilename ) {
    	
	    try (Stream<Path> streamFiles = Files.find( Paths.get( dir.getPath() ), 1,
	                (path, attr) -> path.getFileName().toString().equals(searchedFilename) )) {
	    	
	    	/*
	    	List<File> filesInFolder = Files.walk(Paths.get("/path/to/folder"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
	    	*/
	    	/*
	           //  boolean isFileFound = streamFiles.findAny().isPresent() ;
	            if ( isFileFound ) {
	            	System.out.println( isFileFound );
	            	
	            	// streamFiles.limit(1).forEach( path -> path.toFile() );
	            	
	            	// return (File) streamFiles.map(path -> path.toFile()).collect(Collectors.toList());
	            }
	            */
	    	List<File> filesInFolder =  streamFiles.map(path -> path.toFile()).collect(Collectors.toList());
	    	return filesInFolder!= null ? filesInFolder.get( 0 ) : null;
	    	
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
	    return null;
    }
    
    private static boolean findFile1( File dir, String searchedFilename ) {
        File foundFile = null; // no need to store result as String, you're returning File anyway
        File[] dirlist = dir.listFiles();        
        boolean flagReplaceAll = true;
        for ( int i = 0; i < dirlist.length; i++ ) {
            if ( dirlist[i].isDirectory() ) {
            	foundFile = findFile8( dirlist[i], searchedFilename );                
                if ( foundFile != null ) {
                	if ( !replaceInFile( foundFile, wordReplaceFrom, wordReplaceTo ) ) {
                		flagReplaceAll = false;
                		break;
                	}
                }
            }
        }        
        
        return flagReplaceAll; // will return null if we didn't find anything
    }
    
    
    private static File findFile( File dir, String searchedFilename ) {
        File result = null; // no need to store result as String, you're returning File anyway
        File[] dirlist = dir.listFiles();

        for ( int i = 0; i < dirlist.length; i++ ) {
            if ( dirlist[i].isDirectory() ) {
                result = findFile( dirlist[i], searchedFilename );
                if ( result != null ) break; // recursive call found the file; terminate the loop
            } else if ( dirlist[i].getName().matches( searchedFilename ) ) {
                	// return dirlist[i]; // found the file; return it
            	replaceInFile( dirlist[i], wordReplaceFrom, wordReplaceTo );
            }
        }
        return result; // will return null if we didn't find anything
    }
    
    
    
    public static boolean replaceInFile( File foundFile, String wordFrom, String wordTo ) {
    	boolean replacedInFile = false;
        try {
        	System.out.println( "\n *** in replaceInFile() : and foundFile = " + foundFile.toString() );
            Path path = Paths.get( foundFile.getPath() );
            Stream<String> lines = Files.lines( path );
            List<String> replaced = lines
            		.map( line -> line.replace( wordFrom, "${MID_GIT_URL_POST_MIG}" ) )
            		.collect( Collectors.toList() );
            Files.write( path, replaced );
            lines.close();
            System.out.println( "\n Find and Replace done!!!" );
            replacedInFile = true;
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return replacedInFile;
    }
    
    public static void main(String args[]) 
    {
    	
    	repositories.put("Loyalty","MID");
        repositories.put("mte-issuing-online-bank-statements-ansible","MID");
        // repositories.put("#mte-acquiring-ucamp","MID");
        repositories.put("mtt-datasource-util","CA");
        repositories.put("mtb-partners-gateway-installment","MID");
        repositories.put("mti-ansible-integration","CA");
        repositories.put("mtb-ch-push-notification","MID");
        // repositories.put("#mtt-mocking-util","CA");
        repositories.put("swagger-code-generator","CA");
        repositories.put("mte-issuing-notification","MID");
        repositories.put("mte-issuing-installment-documents","MID");
        repositories.put("mtt-test-asset","CA");
        repositories.put("mtt-logging-util","CA");
        repositories.put("mtt-camel-asset","CA");
        repositories.put("mte-issuing-horus","MID");
        repositories.put("mtb-partners-gateway-privacy-agreements","MID");
        repositories.put("mte-acquiring-reliability","MID");
        // repositories.put("#mti-eureka-server","CA");
        
        environmentVariables.put("MID", "${MID_GIT_URL_PRE_MIG}");
        environmentVariables.put("CA", "${MID_CA_GIT_URL_PRE_MIG}");
       
        
    	TestSearchFile test = new TestSearchFile();
    	test.searchJenkinFile();
    } 
 
} 