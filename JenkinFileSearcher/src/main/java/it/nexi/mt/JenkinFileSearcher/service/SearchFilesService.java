package it.nexi.mt.JenkinFileSearcher.service;

import it.nexi.mt.JenkinFileSearcher.Config.JenkinsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SearchFilesService {

    @Autowired
    JenkinsConfig jenkinsConfig;

    public String searchJenkinFile() {
        String baseFolder = jenkinsConfig.getBaseFolder();
        String searchedFile = jenkinsConfig.getSearchedFile();
        String wordReplaceFrom = jenkinsConfig.getWordReplaceFrom();
        String wordReplaceTo = jenkinsConfig.getWordReplaceTo();

        final File startFolder = new File( baseFolder );

        File file = findFile( startFolder, searchedFile );

        replaceInFile( file, wordReplaceFrom, wordReplaceTo );

        System.out.println( "************* baseFolder =  " + baseFolder + "************* searchedFile =  " + searchedFile );
        return "";
    }

    private static File findFile( File dir, String searchedFilename ) {
        File result = null; // no need to store result as String, you're returning File anyway
        File[] dirlist = dir.listFiles();

        for ( int i = 0; i < dirlist.length; i++ ) {
            if ( dirlist[i].isDirectory() ) {
                result = findFile( dirlist[i], searchedFilename );
                if ( result != null ) break; // recursive call found the file; terminate the loop
            } else if ( dirlist[i].getName().matches( searchedFilename ) ) {
                return dirlist[i]; // found the file; return it
            }
        }
        return result; // will return null if we didn't find anything
    }

    public static void replaceInFile( File foundFile, String wordFrom, String wordTo ) {
        try {
            Path path = Paths.get( foundFile.toURI() );
            Stream<String> lines = Files.lines( path );
            List<String> replaced = lines.map( line -> line.replaceAll( wordFrom, "${MID_GIT_URL_POST_MIG}" ) ).collect( Collectors.toList() );
            Files.write( path, replaced );
            lines.close();
            System.out.println( "Find and Replace done!!!" );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

}
