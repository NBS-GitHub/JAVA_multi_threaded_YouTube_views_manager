import java.util.Random;

public class Visitor extends Thread {

   private Movie movie;
   private String title;
   private int rate;
   private int IpA;
   private int IpB;
   private int IpC;
   private int IpD;
   private Random random = new Random();

   public Visitor(Movie movie) {
      this.movie = movie;
      this.title = movie.getTitle();
      IpA = random.nextInt(256);
      IpB = random.nextInt(256);
      IpC = random.nextInt(256);
      IpD = random.nextInt(256);
   }

   public void run() {
      try {
         System.out.printf("Visitor with IP number %d.%d.%d.%d is watching the movie \"%s\"...\n", IpA, IpB, IpC, IpD, title);
         Thread.sleep(random.nextInt(movie.getDuration()));
         rate = random.nextInt(10);
         movie.incrementViewsCount();

         switch(rate) {
            case 0:
               movie.incrementDislikesCount();
               System.out.printf("Visitor with IP number %d.%d.%d.%d has given the movie \"%s\" a thumb-down.\n", IpA, IpB, IpC, IpD, title);
               break;
            case 2:
            case 3:
               System.out.printf("Visitor with IP number %d.%d.%d.%d has not rated the movie \"%s\".\n", IpA, IpB, IpC, IpD, title);
               break;
            default:
               movie.incrementLikesCount();
               System.out.printf("Visitor with IP number %d.%d.%d.%d has given the movie \"%s\" a thumb-up.\n", IpA, IpB, IpC, IpD, title);
         }

         System.out.println(movie.toString());
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

   }

}
