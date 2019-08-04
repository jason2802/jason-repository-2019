package it.nexi.mt.JenkinFileSearcher.Config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class JenkinsConfig {

    @Value ( "${jenkins.base-folder}" )
    private String baseFolder;

    @Value ( "${jenkins.searched-file}" )
    private String searchedFile;

    @Value ( "${jenkins.word-replace-from}" )
    private String wordReplaceFrom;

    @Value ( "${jenkins.word-replace-to}" )
    private String wordReplaceTo;

}

