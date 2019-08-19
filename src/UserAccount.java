import java.util.Random;

public class UserAccount {
   public static void main(String[] args) {

      Movie movie1 = new Movie("Ultimate Funny Fails Compilation",900);
      Random random = new Random();

      while(true) {
         try {
            Thread.sleep(random.nextInt(1000));
            Visitor visitor = new Visitor(movie1);
            visitor.start();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }

   }
}
