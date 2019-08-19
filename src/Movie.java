import java.util.Random;

public class Movie implements Runnable {

   private String title;
   private int views = 0;
   private int likes = 0;
   private int dislikes = 0;
   private int duration;
   Random random = new Random();

   Object lock1 = new Object();
   Object lock2 = new Object();
   Object lock3 = new Object();

   public Movie(String title, int duration) {
      this.title = title;
      this.duration = duration;
   }

   public void run() {
      releaseMovie();
   }

   public void releaseMovie() {
      while(true) {
         try {
            Thread.sleep(random.nextInt(1000));
            Visitor visitor = new Visitor(this);
            visitor.start();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }


   public synchronized void incrementViewsCount() {
      synchronized (lock1) {
         views++;
      }

   }

   public synchronized void incrementLikesCount() {
      synchronized (lock2) {
         likes++;
      }

   }
   public synchronized void incrementDislikesCount() {
      synchronized (lock3) {
         dislikes++;
      }
   }

   public String getTitle() {
      return title;
   }

   public int getDuration() {
      return duration;
   }

   @Override
   public String toString() {
      return "Movie " + title + " {" +
            "views=" + views +
            ", likes=" + likes +
            ", dislikes=" + dislikes +
            '}';
   }
}
