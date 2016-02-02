# iOS Flagship Automation
This project contains the tests for the iHeart Radio flagship iOS app. 

## Setup 
Run:

	./setup.sh
	
This executes commands to build gradle, download dependencies, and create an Eclipse project. 

####Note
You may need to remove the src/ folder from your build path from within Eclipse. If you are seeing a build error after cloning and runing setup, simply right click the src/ directory, highlight build path, and select remove from build path. This should remove all errors.

## Propeties Files
Properties files are copied from templates to the properties directory. You only edit templates if you're adding properties that everyone will need access to. Set the device name, UDID, path to app, etc in the "local" properties flile, which will be in properties/ios.properties.local. Git knows to ignore all *.local files.