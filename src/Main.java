public class Main {

    public static void main(String[] args) {
        // write your code here
        if (args.length == 0) {
            System.out.println("No arguments specified!");

            return;
        }

        if (args[0].equals("init"))  {
            System.out.println("Das ist init");
        }

        if (args[0].equals("history"))  {
            System.out.println("Das ist history");
        }

        if (args[0].equals("snapshot"))  {
            System.out.println("Das ist snapshot");
        }

        if (args[0].equals("restore"))  {
            System.out.println("Das ist restore");
        }

    }
}
