package interviews;

import java.util.Stack;

public class StringPathChanger {

    public static void main(String[] args) {
        String changed = changeDirectoryString("/dev/opt/java", "cd ../tomcat");
        System.out.println(changed);
    }

    public static String changeDirectoryString(String currentDirectory, String command) {

        if (!command.startsWith("cd ")) {
            throw new IllegalArgumentException("command should start with cd");
        }

        String inputPath = command.substring(3);
        String[] userPaths = inputPath.split("/");
        String[] currentDirPaths = currentDirectory.split("/");

        Stack<String> original = getDirectories(currentDirPaths, userPaths);

        StringBuilder sb = new StringBuilder("/");
        while (!original.isEmpty()) {
            sb.append(original.pop()).append("/");
        }
        return sb.toString();
    }

    private static Stack<String> getDirectories(String[] currentDirPaths, String[] userPaths) {
        Stack<String> directories = new Stack<>();

        // Push current directories to stack
        for (String currentDirPath : currentDirPaths) {
            if (!currentDirPath.isEmpty()) {
                directories.push(currentDirPath);
            }
        }

        // Extract userPaths and validate proper checks and remove from stack
        for (String path : userPaths) {
            if (path.isEmpty() || path.equals(".")) continue;

            if (path.equals("..") && !directories.isEmpty()) {
                directories.pop();
            } else {
                directories.push(path);
            }
        }

        Stack<String> original = new Stack<>();
        while (!directories.isEmpty()) {
            original.push(directories.pop());
        }
        return original;
    }
}


/*
        dir -> solution, java, task, dev
        original -> solution, java, task, dev


 */

/*
        /
       ..
        Java
        ../solution
        ../..
        java

 */

// /dev/task - [dev, task]
