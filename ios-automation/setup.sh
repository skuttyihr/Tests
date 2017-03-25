echo "Grabbing Test Commons submodule."
git submodule init
git submodule update --remote

echo "Building project."
gradle build -x test

echo "Creating Eclipse project."
gradle eclipse

echo "Copying properties (press Ctrl + C if this isn't necessary."
java -jar copyProperties.jar

echo "Decrypting password file (press Ctrl + C if this isn't necessary."
java -jar encryptionTool.jar --decrypt --decryptedFile passwords/passwords.local --encryptedFile passwords/passwords.encrypted

echo "Finished setup!"
