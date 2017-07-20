/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
        
/**
 *
 * @author francesco
 */
public class PostFactory {
    private static PostFactory singleton;
    private String connectionString;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
   // private ArrayList<Post> listaPost=new ArrayList<Post>();
    
    private PostFactory() {
        
        /*UserFactory userFactory = UserFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContent("Ciao, miei schiavi. Datemi cibo! Adesso! Miaomiaomiaomiaomiao!");
        post1.setId(0);
        post1.setUser(userFactory.getUserById(0));

        Post post2 = new Post();
        post2.setContent("img/djanni1.jpg");
        post2.setId(1);
        post2.setUser(userFactory.getUserById(0));
        post2.setPostType(Post.Type.IMAGE);

        Post post3 = new Post();
        post3.setContent("img/djanni2.jpg");
        post3.setId(2);
        post3.setUser(userFactory.getUserById(0));
        post3.setPostType(Post.Type.IMAGE);

        Post post4 = new Post();
        post4.setContent("I need ansioliticy");
        post4.setId(3);
        post4.setUser(userFactory.getUserById(1));

        Post post5 = new Post();
        post5.setContent("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post5.setId(4);
        post5.setUser(userFactory.getUserById(1));
        post5.setPostType(Post.Type.IMAGE);

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
        listaPost.add(post5);*/
    }
    
    public Post getPostById(int id){
        UserFactory userFactory = UserFactory.getInstance();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select * from posts "
                    + "join posttype on posts.type = posttype.posttype_id "
                    + "where post_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContent(res.getString("content"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));
                
                //imposto l'autore del post
                User autore = userFactory.getUserById(res.getInt("author"));
                current.setUser(autore);

                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public List<Post> getPostList(User user){
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select * from posts "
                    + "join posttype on posts.type = posttype.posttype_id "
                    + "where author = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContent(res.getString("content"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));

                //imposto l'autore del post
                current.setUser(user);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
   
    public void addNewPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "insert into posts (post_id, content, type, author) "
                    + "values (default, ? , ? , ? )";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, post.getContent());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getUser().getId());
            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean eliminaPost(int id){
         try{
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");

            String query="DELETE FROM posts where id = ?";
            PreparedStatement stmt=conn.prepareStatement(query);

            stmt.setInt(1, id);
            stmt.executeUpdate(query);

            stmt.close();
            
            query="SELECT * FROM posts where id = ?";
            stmt=conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            ResultSet set=stmt.executeQuery(query);
            
            if(set.next()){
                stmt.close();
                conn.close();
                return false;
            }
            
            stmt.close();
            conn.close();
            return true;
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    private Post.Type postTypeFromString(String type){
        
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        
        return Post.Type.TEXT;
    }
    
    private int postTypeFromEnum(Post.Type type){
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if(type == Post.Type.TEXT)
                return 1;
            else
                return 2;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}