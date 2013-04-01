public class Main {

    public static void main(String[] args) {
	// write your code here

        for (int i = 0; i < args.length; i++)
        {

            if (args[i] == "init")  {
                System.out.println("Das ist init");
            }

            if (args[i] == "history")  {
                System.out.println("Das ist history");
            }

            if (args[i] == "snapshot")  {
                System.out.println("Das ist snapshot");
            }

            if (args[i] == "restore")  {
                System.out.println("Das ist restore");
            }

        }
    }
}
