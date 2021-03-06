package Model;
// Generated May 25, 2016 7:51:48 AM by Hibernate Tools 4.3.1


import Controller.HibernateUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Deck generated by hbm2java
 */
public class Deck  implements java.io.Serializable {


     private Integer id;
     private User user;
     private String name;
     private Set scores = new HashSet(0);
     private Set flashcards = new HashSet(0);

    public Deck() {
    }

    public Session acquireSession() {
        // All DB opening, connection etc. removed,
        // since the problem is in compilation, not at runtime.
        return null;
    }

    @SuppressWarnings("unchecked") /* <----- */

    public List<Deck> decks() {
        String query = "from Deck";
        List<Deck> list = executeHQLQuery(query);
        return list;
    }
    
    public List<Deck> decksByUser(User user) {
        String query = "from Deck where id_user="+user.getId();
        List<Deck> list = executeHQLQuery(query);
        return list;
    }
     
    private List executeHQLQuery(String hql) 
    {
        try 
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } 
        catch (HibernateException he) 
        {
            he.printStackTrace();
        }
        return null;
    }
	
    public Deck(String name) {
        this.name = name;
    }
    public Deck(User user, String name, Set scores, Set flashcards) {
       this.user = user;
       this.name = name;
       this.scores = scores;
       this.flashcards = flashcards;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getScores() {
        return this.scores;
    }
    
    public void setScores(Set scores) {
        this.scores = scores;
    }
    public Set getFlashcards() {
        return this.flashcards;
    }
    
    public void setFlashcards(Set flashcards) {
        this.flashcards = flashcards;
    }




}


