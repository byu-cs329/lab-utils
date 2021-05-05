# CS 329 Labs Utility Source Files

## Purpose

This repository contains boilerplate code which you may use to work on the labs. 
They include logic for tasks you may do over and over again, such as reading in and compiling a Java source file,
throw a runtime exception when a precondition is not met, and retrieving a specific property of an ASTNode.

You will need to run `mvn install` on this repository for the starter code given to you in the lab assignments to work.
The `mvn install` command builds and names a jar file for the project according to the `pom.xml` file and installs that jar in the local Maven cache. Run it for this project so that it is available to use in your lab assignments. 

When using Docker containers for development, you should have Docker mount your local Maven cache in the container. 
You can [read more on how to do this here]().

## Usage

1. `git clone` this repository to your local computer
2. Run `mvn install` on this repository.
3. Any other Maven projects will now be able to reference this project when this dependency tag is declared:

```xml
<dependency>
  <groupId>edu.byu.cs329</groupId>
  <artifactId>lab-utils</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

## Understanding the Boilerplate Code

To save yourself time in the long run, understand the tools given to you in this project. 
Below is a rundown of the files provided.

### ExceptionUtils.java

This contains code that can throw an exception when an unexpected behavior occurred.

### JavaSourceUtils.java

Many tests you write for your lab assignments would require tests in the format of a Java source file. 
This class contains the boilerplate code to read in and compile a Java source file to an ASTNode.

### NodePropertiesUtils.java

You will come to find that you would need to get a common property from an ASTNode (such as a name). 
Reference the starter code to see how these methods are used.

### TreeModificationUtils.java

The first three labs will require you to make modifications to a current ASTNode. 
Methods in this class allow you to modify the tree as represented by the ASTNode class.

## Troubleshooting

If your projects are having issues referencing this project, it may mean that you are running Maven differently where Maven installed this project into a cache that your other projects are not referencing. Make sure you are running `mvn install` the same way as the `mvn` command for your projects.

To check that your Maven cache reference is the same between projects, run the following command:

```mvn help:evaluate -Dexpression=settings.localRepository -q -DforceStdout```
