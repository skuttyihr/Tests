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

copyProperties.jar is ran by the setup script, but you can also run it manually by typing in this command:

	java -jar copyProperties.jar
	

For this project (and others) you'll want to use the default location for the properties. When it asks you for a path, just press enter to choose the default path. Do the same when it asks you for the path to the other file.

Then you're presented with three options. These options are here to protect your local properties files. If you already have a properties file created, and you don't want it to be modified, choose the option that says skip. If you want it to automatically replace existing files, choose that option. And, if there are multiple properties files, and you want to replace only some of them, choose the third option, and you'll be asked before each replacement. Read through the options and decide what is best for you. 



## Passwords (Vital, please read)
Passwords are no longer stored in the code. In fact, the way we store them and commit them to GitHub has changed dramatically. The system in place is just like that for the properties file. There's a file that's committed to GitHub, and there's a passwords.local version that you may update on your own machine. **However** there is a large *key* difference (pun intended!). The version that gets committed is *encrypted*. If a password is stored in plain text on GitHub, even on a private repository under the iHeart organization, there could be repercussions. *Always* use encrypted passwords. An encrptionTool.jar file has been added to this repository. It uses symmetrical hashed (SHA256) encryption keys based on a user password. Passwords must be at least 8 characters in length, with upper and lower case, although use of spaces, symbols, and numbers is encouraged. Every encrypted password file will have a password that is *shared by the team*. If you make changes or additions to your local file, you must re-run the encryption jar. If you don't want to run setup, and you just want to encrypt or decrypt a file, you can do so with this:

	java -jar encryptionTool.jar
	
It's that easy. NO AWS or Internal iHeart usernames or passwords should be committed, even encrypted. This is pretty decent encryption, but has a huge security flaw, and that's the fact that we're all sharing a password for it. If one person lets that password slip, our entire infrastructure could be compromised. Do not share your AWS or iHeart logins with GitHub, even with this encryption tool.

The tool is simple to use. A Passowrds directory will need to be added to the classpath as a resource. 

**From now on, no one will commit a password that is in the code or hardcoded in a properties file. All passwords will be encrypted using this tool and a strong password, shared with the team on confluence.**



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
	4. Select ios-automation/src/main/resources (there should be two of them) and click the Remove button. Remove the one that does NOT have excluded files. Either will work, but the other ensures that java files misplaced in here will not be compiled. 
	5. (Delete any other duplicates, if they exist)
	6. Click apply
	7. Click OK
11. You can now begin writing code, making tests, and more. 