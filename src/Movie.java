public class Movie {

   private String title;
   private int views = 0;
   private int likes = 0;
   private int dislikes = 0;
   private int duration;

   Object lock1 = new Object();
   Object lock2 = new Object();
   Object lock3 = new Object();

   public Movie(String title, int duration) {
      this.title = title;
      this.duration = duration;
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

   public int getLikes() {
      return likes;
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
