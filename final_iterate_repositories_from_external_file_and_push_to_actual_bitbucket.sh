	echo "  "
all_services_dictionary_filename=all_services_dictionary.txt
all_services_dictionary_directoryPath="C:/dev/perso/"
local_services_directoryPath="C:/dev/nexi/services/clone_all_repo/"
bitbucket_remote_repository="https://bitbucket.org/digitalicbpi/"
dot_git=".git"
all_lines=`cat $all_services_dictionary_filename`
	echo "File Contents = "$all_lines
	echo "  "

	echo "=================== MASSIVE COMMIT & PUSH SCRIPT v2.0 =================== "
	echo "===== commit only few selected ( listed in external file ) repositories in a folder and push to Bibucket ====="
	echo "  "
	echo "-- Want to be sure that all of my future commits use the given information : josueguetsa"
curl -u josueguetsa:Nexi2802 https://api.bitbucket.org/1.0/users/digitalicbpi > repoinfo

echo "  "
echo "-- all_services_dictionary_filename= "$all_services_dictionary_filename
all_services_dictionary_filenamePath=$all_services_dictionary_directoryPath$all_services_dictionary_filename 
echo "  "
echo "-- all_services_dictionary_filenamePath= "$all_services_dictionary_filenamePath
echo "  "
	echo "-- Now lets iterate on selected ( external file ) repository "
	echo "  "
while IFS= read -r line
do
		echo "  "
	IFS=':' read -ra ADDR <<< "$line"
	service=${ADDR[0]} 
		echo "-- Let's change current directory to : $service"
	cd $local_services_directoryPath$service
		echo "  -- git checkout develop : to have develop as active branch"
	git checkout develop
	
		echo "  -- git add "
	git add .
		echo "  -- git commit "
	git commit -m "commit changes in Jenkinsfile Migration_2019_06_27"
		echo "  -- git status "
	git status
	remoteRepository=$bitbucket_remote_repository$service$dot_git
		echo "  -- git remote set-url origin : to read from remote repository i.e "$remoteRepository
	git remote set-url origin $remoteRepository
		echo "  -- git push on develop branch"
	git push origin develop
		echo " "
done < "$all_services_dictionary_filenamePath"
	echo "  "
echo "=== DONE === "