#!/bin/bash
#Script to get all repositories under a user from bitbucket
#source: 
echo "=== START === "
curl -u josueguetsa:Nexi2802 https://api.bitbucket.org/1.0/users/digitalicbpi > repoinfo
all_services_dictionary_filename=all_services_dictionary.txt
all_services_dictionary_directoryPath="C:/dev/perso/"
all_services_dictionary_filenamePath=$all_services_dictionary_directoryPath$all_services_dictionary_filename

while IFS= read -r line
do
		echo "  "
	IFS=':' read -ra ADDR <<< "$line"
	service=${ADDR[0]} 
		echo "-- Let's change current directory to : $service"
	
	echo "Cloning " $service.git
	git clone https://josueguetsa@bitbucket.org/digitalicbpi/$service.git
    echo "---"
		
	
done < "$all_services_dictionary_filenamePath"
echo "=== DONE === "