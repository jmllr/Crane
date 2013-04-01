public class Main {

    public static void main(String[] args) {
        // write your code here
        if (args.length == 0) {
            System.out.println("No arguments specified!");

            return;
        }

        if (args[0].equals("init"))  {
            System.out.println("This is init");
        }

        if (args[0].equals("history"))  {
            System.out.println("This is history");
        }

        if (args[0].equals("snapshot"))  {
            System.out.println("This is snapshot");
        }

        if (args[0].equals("restore"))  {

            if (args.length == 1) {
             System.out.println("id is not specified!");

                return;

            }
            System.out.println("This is restore for id " + args[1]);
        }


        if (args[0].equals("test"))  {

            Index test = new Index();
            test.readTestFile();
        }
    }
}
