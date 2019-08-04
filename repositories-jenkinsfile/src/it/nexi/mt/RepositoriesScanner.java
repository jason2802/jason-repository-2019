package it.nexi.mt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;


public class RepositoriesScanner
{ 
	private static final String JENKINSFILE_FOLDERS_PATH = "C:/dev/nexi/services/clone_all_repo"; 	// "C:/dev/perso/jenkinsfileprojects"; 
    private static final String ALL_SERVICES_DICTIONARY_FILEPATH = "C:\\dev\\perso\\all_services_dictionary.txt";
	private static final String SEARCHED_FILENAME = "Jenkinsfile";
    private static final String GIT_URL_INIT = "https://bitbucket.org/digitalicbpi/";
    private static final String GIT_CREDENTIALS_OLD = "soa-bitbucket-user";
    private static final String GIT_CREDENTIALS_NEW = "soa-nexicloud-bitbucket";
    private static Map<Object, Object> repositories = new HashMap<Object, Object>();
    private static HashMap<String, String> environmentVariables = new HashMap<String, String>();
    
    public void searchJenkinFile() {    	
        final File startFolder = new File( JENKINSFILE_FOLDERS_PATH );
        findAndReplaceFile( startFolder );       
    }

    private static boolean findAndReplaceFile( File dir ) {
        File foundFile = null; 
        File[] dirlist = dir.listFiles();        
        boolean flagReplaceAll = true;
        for ( int i = 0; i < dirlist.length; i++ ) {
        	File currentPath = dirlist[i];
            if ( currentPath.isDirectory() ) {
            	foundFile = findFile( currentPath, SEARCHED_FILENAME );                
                if ( Objects.nonNull( foundFile ) ) {
                	System.out.println( "\nFound file = " + foundFile.toString() );                	
                	String path = currentPath.getPath();
                	String repositoryName = path.substring( path.lastIndexOf('\\') + 1 );
                	String subPath = (String) repositories.get( repositoryName );
                	if ( Objects.nonNull( subPath ) ) {
	                	String jenkinsEnv = environmentVariables.get( subPath );
	                	if ( !replaceInFile( foundFile, jenkinsEnv ) ) {
	                		flagReplaceAll = false;
	                		break;
	                	}
                	} else {
                		System.out.println( "\n --- Not value found in repositories ( all_services_dictionary.txt ) for key repositoryName = " + repositoryName );
                		flagReplaceAll = false;
                	}
                }
            }
        }         
        return flagReplaceAll; 
    }

    private static File findFile( File dir, String searchedFilename ) {    	
	    try ( Stream<Path> streamFiles = Files.find( Paths.get( dir.getPath() ), 3,
	                ( path, attr ) -> path.getFileName().toString().equals(searchedFilename) ) ) {
	    	List<File> filesInFolder =  streamFiles.map( path -> path.toFile() ).collect( Collectors.toList() );
	    	return CollectionUtils.isNotEmpty( filesInFolder ) ? filesInFolder.get( 0 ) : null;	    	
	    } catch ( IOException e ) {
	            e.printStackTrace();
	    }
	    return null;
    }    
       
    public static boolean replaceInFile( File foundFile, String gitUrlEnv ) {
    	boolean replacedInFile = false;
        try {
            Path path = Paths.get( foundFile.getPath() );
            Stream<String> lines = Files.lines( path );
            List<String> replaced = lines
            		.map( line -> { 
        								if( line.indexOf( GIT_URL_INIT ) > 0 ) {
        									line = line.replace( GIT_URL_INIT, gitUrlEnv );
        									System.out.println( "   " + GIT_URL_INIT + " : found and replaced successfully !!!" );
        								} else if( line.indexOf( GIT_CREDENTIALS_OLD ) > 0 ) {
        									line = line.replace( GIT_CREDENTIALS_OLD, GIT_CREDENTIALS_NEW );
        									System.out.println( "   " + GIT_CREDENTIALS_OLD + " : found and replaced successfully !!!" );
        								}
        								return line;
				                   }
			             )
            		.collect( Collectors.toList() );
            Files.write( path, replaced );
            lines.close();
            replacedInFile = true;
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return replacedInFile;
    }
    
    public static void main(String args[]) {
    	System.out.println( "\n Start " );
    	try {
			repositories = Files.lines( Paths.get( ALL_SERVICES_DICTIONARY_FILEPATH ) )
							        	.map( l -> l.split(":") )
							        	.collect( Collectors.toMap ( l -> l[0], l -> l[1] ) );
		} catch ( IOException e ) {
			e.printStackTrace();
		}	
    	
        environmentVariables.put("MID", "${MID_GIT_URL_POST_MIG}");
        environmentVariables.put("CA", "${MID_CA_GIT_URL_POST_MIG}");
               
    	RepositoriesScanner test = new RepositoriesScanner();
    	test.searchJenkinFile();
    	
    	System.out.println( "\n end " );
    }
 
} 