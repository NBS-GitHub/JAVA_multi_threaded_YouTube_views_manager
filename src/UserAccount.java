public class UserAccount {
   public static void main(String[] args) {

      Thread thread1 = new Thread(new Movie("Ultimate Funny Fails Compilation",900));
      Thread thread2 = new Thread(new Movie("Instant Karma", 367));

      thread1.start();
      thread2.start();

   }
}
