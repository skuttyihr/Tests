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



### Importing to Eclipse, fixing Build Path

After cloning and running ./setup.sh, you may still have issues importing the project into Eclipse. This is partially due to a bug in Gradle (if it's been fixed, ignore this). Follow the steps below on how to import this project to Eclipse and fix the Build Path if Gradle still has the dulplicate entry bug:

1. You ran ./setup.sh
2. Now open Eclipse
3. Exit to the workspace if this is your first time opening Eclipse
4. On the leftmost side of the screen, you'll see a pane labeled "Package Explorer"
5. Right click in Package Explorer and Select "Import…" (You can also go to File > Import)
6. Under "General" Select "Existing Projects into Workspace"
7. Click Next
8. Select the directory where you have cloned the automation. For example, /Users/you/dev/ios-automation
9. Click Finish
10. If Gradle still has a bug in it, you'll see a red exclamation mark over the file. We're going to get rid of that by fixing the build path.
	1. Right click on the project (that has the '!')
	2. Go to Build Path > Configure Build Path
	3. Go to the "Source" view (Java build path should be selected in the left pane automatically)
	4. Select ios-automation/src/main/resources (there should be two of them) and click the Remove button. 
	5. (Delete any other duplicates, if they exist)
	6. Click apply
	7. Click OK
11. You can now begin writing code, making tests, and more. 